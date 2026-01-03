package com.insurance.claims.claims_ingestion.service;
// Package declaration: groups related classes together (like a folder structure)

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
// Static import: allows using ATOMIC_MOVE directly without prefix
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
// Static import: allows using REPLACE_EXISTING directly

import java.io.IOException; // Handles input/output errors
import java.nio.file.AtomicMoveNotSupportedException; // Exception if atomic move not supported
import java.nio.file.DirectoryStream; // Used to iterate through files in a directory
import java.nio.file.Files; // Utility class for file operations
import java.nio.file.NoSuchFileException; // Exception when a file/directory doesn’t exist
import java.nio.file.Path; // Represents a file or directory path
import java.time.LocalDateTime; // Represents current date and time
import java.time.format.DateTimeFormatter; // Formats date/time into strings
import java.util.concurrent.Executors; // Creates thread pools for scheduling tasks
import java.util.concurrent.TimeUnit; // Defines time units (milliseconds, seconds, etc.)

import org.slf4j.Logger; // Logging interface
import org.slf4j.LoggerFactory; // Creates logger instances

import com.insurance.claims.claims_ingestion.config.Config;
// Custom config class that holds directory paths, polling interval, timestamp format

public class IngestionService {
	// Logger instance for this class
	private static final Logger log = LoggerFactory.getLogger(IngestionService.class);

	// Config object holding directory paths and settings
	private final Config config;
	// Formatter for timestamps (used in archive folder names)
	private final DateTimeFormatter formatter;

	// Constructor: initializes config and formatter
	public IngestionService(Config config) {
		this.config = config;
		this.formatter = DateTimeFormatter.ofPattern(config.timestampFormat());
	}

	// Ensures all required directories exist
	public void initDirectories() throws IOException {
		createIfMissing(config.baseDir());
		createIfMissing(config.incoming());
		createIfMissing(config.processing());
		createIfMissing(config.processed());
		createIfMissing(config.error());
		createIfMissing(config.archive());
		log.info("Directory structure validated/created under {}", config.baseDir().toAbsolutePath());
	}

	// Starts the ingestion service
	public void start() {
		// Create a scheduler that runs tasks in a background thread.
		// Executors.newSingleThreadScheduledExecutor() creates a background scheduler
		// with one thread that runs tasks repeatedly or after delays. It’s perfect for
		// jobs like your claims poller, which checks the incoming directory every few
		// seconds.
		var scheduler = Executors.newSingleThreadScheduledExecutor(r -> {
			Thread t = new Thread(r, "claims-poller"); // Name the thread "claims-poller"
			t.setDaemon(true); // Daemon thread: won’t block program exit
			// Daemon threads are suitable for background tasks like logging, monitoring, or cleanup.
			// Daemon threads do not prevent the JVM from exiting.
			// When all user threads finish, the JVM will automatically stop, even if daemon
			// threads are still running.
			return t;
		});

		// Schedule pollIncoming() to run repeatedly
		scheduler.scheduleWithFixedDelay(this::pollIncoming, 0, // start immediately
				config.pollingMs(), // repeat every pollingMs milliseconds
				TimeUnit.MILLISECONDS);

		// Keep the main thread alive so scheduler keeps running
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt(); // Reset interrupt flag
			log.warn("Main thread interrupted");
		}
	}

	// Polls the incoming directory for new files
	private void pollIncoming() {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(config.incoming())) {
			for (Path file : stream) {
				if (Files.isDirectory(file))
					continue; // Skip directories

				String name = file.getFileName().toString().toLowerCase(); // Get file name in lowercase

				// If file is corrupt → move to error directory
				if (isCorrupt(name)) {
					moveAtomic(file, config.error().resolve(file.getFileName()));
					log.warn("Corrupt/unreadable file routed to error_claims: {}", file.getFileName());
					continue;
				}

				// If file is a valid claim → process it
				if (isValidClaim(name)) {
					processClaim(file);
				} else {
					// Unknown file pattern → move to error directory
					moveAtomic(file, config.error().resolve(file.getFileName()));
					log.info("Unknown file pattern routed to error_claims: {}", file.getFileName());
				}
			}
		} catch (NoSuchFileException nsfe) {
			// If directory doesn’t exist → reinitialize
			try {
				initDirectories();
			} catch (IOException e) {
				log.error("Failed to reinitialize directories", e);
			}
		} catch (IOException e) {
			log.error("Error polling incoming directory", e);
		}
	}

	// Handles processing of a valid claim file
	private void processClaim(Path incomingFile) throws IOException {
		// Move file from incoming → processing
		Path inProc = config.processing().resolve(incomingFile.getFileName());
		moveAtomic(incomingFile, inProc);
		log.info("Moved to processing_claims: {}", incomingFile.getFileName());

		// Simulate processing work (short sleep)
		simulateProcessing(inProc);

		// Move file from processing → processed
		Path done = config.processed().resolve(inProc.getFileName());
		moveAtomic(inProc, done);
		log.info("Moved to processed_claims: {}", done.getFileName());

		// Create timestamped archive folder
		String stamp = LocalDateTime.now().format(formatter);
		Path archiveDir = config.archive().resolve(stamp);
		createIfMissing(archiveDir);

		// Move file from processed → archive
		Path archived = archiveDir.resolve(done.getFileName());
		moveAtomic(done, archived);
		log.info("Archived to {}: {}", archiveDir.getFileName(), archived.getFileName());
	}

	// Simulates claim processing by sleeping for 200ms
	private void simulateProcessing(Path file) {
		try {
			Thread.sleep(200); // Pretend to process
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt(); // Reset interrupt flag
		}
	}

	// Checks if file name is a valid claim
	private boolean isValidClaim(String name) {
		return name.startsWith("claim_");
	}

	// Checks if file name indicates corruption
	private boolean isCorrupt(String name) {
		return name.contains("unreadable") || name.endsWith(".corrupt");
	}

	// Moves file atomically (safe move). Falls back to replace if atomic not
	// supported
	private void moveAtomic(Path from, Path to) throws IOException {
		try {
			Files.move(from, to, ATOMIC_MOVE);
		} catch (AtomicMoveNotSupportedException e) {
			Files.move(from, to, REPLACE_EXISTING);
		}
	}

	// Creates directory if it doesn’t exist
	private void createIfMissing(Path dir) throws IOException {
		if (!Files.exists(dir)) {
			Files.createDirectories(dir);
		}
	}
}
