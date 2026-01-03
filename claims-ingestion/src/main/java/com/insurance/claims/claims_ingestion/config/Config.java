package com.insurance.claims.claims_ingestion.config;

import java.io.IOException; // Exception type for input/output errors
import java.nio.file.Path; // Represents a file or directory path
import java.nio.file.Paths; // Utility class to create Path objects
import java.util.Properties; // Used to load key-value pairs from a properties file

// A record in Java is a special type of class that automatically provides:
// - private final fields
// - a constructor
// - getters
// - equals(), hashCode(), and toString()
// Here, Config holds three pieces of configuration data.
public record Config(Path baseDir, long pollingMs, String timestampFormat) {

	// Static method to load configuration from application.properties file
	public static Config load() throws IOException {
		Properties props = new Properties(); // Create a Properties object to hold key-value settings

		// Try to open the "application.properties" file from the classpath
		try (var is = Config.class.getClassLoader().getResourceAsStream("application.properties")) {
			if (is != null)
				props.load(is); // If file exists, load its contents into props
		}

		// Read base directory from properties, default to "claims_processing" if not
		// set
		String baseDir = props.getProperty("base.dir", "claims_processing").trim() // remove spaces
				.toLowerCase(); // convert to lowercase

		// Read polling interval (milliseconds), default to 2000 if not set
		long pollingMs = Long.parseLong(props.getProperty("polling.ms", "2000").trim());

		// Read timestamp format for archive folder names, default to yyyyMMdd_HHmmss
		String ts = props.getProperty("archive.timestamp.format", "yyyyMMdd_HHmmss").trim();

		// Return a new Config object with the loaded values
		return new Config(Paths.get(baseDir), pollingMs, ts);
	}

	// Helper methods to build subdirectory paths based on baseDir

	// Path to incoming claims folder
	public Path incoming() {
		return baseDir.resolve("incoming_claims");
	}

	// Path to processing claims folder
	public Path processing() {
		return baseDir.resolve("processing_claims");
	}

	// Path to processed claims folder
	public Path processed() {
		return baseDir.resolve("processed_claims");
	}

	// Path to error claims folder
	public Path error() {
		return baseDir.resolve("error_claims");
	}

	// Path to archive folder
	public Path archive() {
		return baseDir.resolve("claims_archive");
	}
}
