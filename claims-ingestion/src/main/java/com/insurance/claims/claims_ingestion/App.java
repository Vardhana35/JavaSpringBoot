package com.insurance.claims.claims_ingestion;

//Watches the incoming_claims folder.Decides what to do with each file:If corrupt → move to error_claims.
//If valid claim → processing -> processed -> then archive (with timestamp).
//If unknown → move to error_claims. Keeps looping forever, checking every 2 seconds the incoming claim folder

import org.slf4j.Logger; // Logging interface
import org.slf4j.LoggerFactory; // Used to create logger instances

import com.insurance.claims.claims_ingestion.config.Config; // Import Config class (holds settings)
import com.insurance.claims.claims_ingestion.service.IngestionService; // Import IngestionService class (main logic)

public class App {
	// Logger for this class: used to print messages (INFO, ERROR, etc.)
	private static final Logger log = LoggerFactory.getLogger(App.class);

	// Main method: entry point of the program
	public static void main(String[] args) {
		try {
			// Load configuration from application.properties (or defaults if missing)
			var config = Config.load();

			// Create the ingestion service with the loaded config
			var service = new IngestionService(config);

			// Ensure all required directories exist (incoming, processing, processed,
			// error, archive)
			service.initDirectories();

			// Log a message showing which directory will be monitored
			log.info("Starting directory monitoring in: {}",
					config.baseDir().resolve("incoming_claims").toAbsolutePath());

			// Start the ingestion service (polls incoming directory continuously)
			service.start();

		} catch (Exception e) {
			// If any fatal error occurs, log it and exit the program
			log.error("Fatal error starting the ingestion service", e);
			System.exit(1); // Exit with status code 1 (indicates error)
		}
	}
}

/*App.java = the front door (entry point).

Config.java = the blueprint (settings).

IngestionService.java = the workers doing the job (logic).

application.properties = the checklist of materials (external settings).

logback.xml = the security cameras (logging/monitoring).*/
