package PS3;

//Watches the incoming_claims folder.Decides what to do with each file:If corrupt → move to error_claims.
//If valid claim → processing -> processed -> then archive (with timestamp).
//If unknown → move to error_claims. Keeps looping forever, checking every 2 seconds the incoming claim folder
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Path: An interface that represents a file or directory path in the file system. Represents a file or directory location.
//Paths.get("..."): Creates a path object pointing to a folder.
//.resolve("..."): Creates a subfolder inside the base folder.
public class ClaimsIngestionApp {
    private static final Path BASE = Paths.get("claims_processing");
    private static final Path INCOMING = BASE.resolve("incoming_claims");
    private static final Path PROCESSING = BASE.resolve("processing_claims");
    private static final Path PROCESSED = BASE.resolve("processed_claims");
    private static final Path ERROR = BASE.resolve("error_claims");
    private static final Path ARCHIVE = BASE.resolve("claims_archive");

    //POLLING_MS = 2000: The program waits 2000 milliseconds (2 seconds) between checks.
    //FORMATTER: Defines how date/time will look, e.g. 20260103_0627
    private static final long POLLING_MS = 2000;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    //throws IOException, InterruptedException: Declares that this method might throw errors related to files or thread sleeping.
    public static void main(String[] args) throws IOException, InterruptedException {
        // Ensure directories exist
    	//Creates all required folders if they don’t already exist.
        for (Path dir : new Path[]{BASE, INCOMING, PROCESSING, PROCESSED, ERROR, ARCHIVE}) {
            Files.createDirectories(dir);
        }
        
        //Prints messages to the console with timestamps.
        //BASE.toAbsolutePath(): Shows the full path on your computer.
        logInfo("Directory structure validated/created under " + BASE.toAbsolutePath());
        logInfo("Starting directory monitoring in: " + INCOMING.toAbsolutePath());

        while (true) {
        	
        	//pollIncoming() → checks for new files.
            //Waits 2 seconds (Thread.sleep(POLLING_MS)) before checking again
            pollIncoming();
            Thread.sleep(POLLING_MS);
        }
    }

    private static void pollIncoming() {
    	
    	//Files.list(INCOMING): Lists all files in the incoming_claims folder.
        //.filter(Files::isRegularFile): Only considers actual files (not folders).
        //.forEach(file -> { ... }): Loops through each file found.
        try {
            Files.list(INCOMING).filter(Files::isRegularFile).forEach(file -> {
                String name = file.getFileName().toString().toLowerCase();
                try {
                    if (name.contains("unreadable") || name.endsWith(".corrupt")) {
                        move(file, ERROR.resolve(file.getFileName()), "Corrupt file sent to error: " + name);
                    } else if (name.startsWith("claim_")) {
                        processClaim(file);
                    } else {
                        move(file, ERROR.resolve(file.getFileName()), "Unknown file sent to error: " + name);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processClaim(Path file) throws IOException {
    	//Moves the file into the processing_claims folder.
        Path inProc = PROCESSING.resolve(file.getFileName());
        move(file, inProc, "Moved to processing_claims: " + file.getFileName());

        //Simulates processing by waiting 200ms.
        try { Thread.sleep(200); } catch (InterruptedException ignored) {}

        //Moves file into processed_claims folder.
        Path done = PROCESSED.resolve(inProc.getFileName());
        move(inProc, done, "Moved to processed_claims: " + done.getFileName());

        //Creates a new archive folder named with current date/time.
        //Moves the processed file into that archive.
        Path archiveDir = ARCHIVE.resolve(LocalDateTime.now().format(FORMATTER));
        Files.createDirectories(archiveDir);
        move(done, archiveDir.resolve(done.getFileName()),
             "Archived to " + archiveDir.getFileName() + ": " + done.getFileName());
    }

    //Moves a file from one folder to another.
    //StandardCopyOption.REPLACE_EXISTING: Overwrites if file already exists.
    //Logs a message after moving.
    private static void move(Path from, Path to, String message) throws IOException {
        Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
        if (message != null) logInfo(message);
    }

    // Helper to print with timestamp + thread name
    private static void logInfo(String message) {
        String time = java.time.LocalTime.now().toString();
        String thread = Thread.currentThread().getName();
        System.out.printf("%s [%s] INFO  %s%n", time, thread, message);
    }
}
