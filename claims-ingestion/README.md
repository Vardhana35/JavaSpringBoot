//claim ingestion explanation

1. create directories if doesn't exist -> base dir(claims-ingestion -> processing -> processed -> then archive (with timestamp -> yyyyMMdd_HHmmss)
Watches the incoming_claims folder.Decides what to do with each file:If corrupt → move to error_claims.
If valid claim → processing -> processed -> then archive (with timestamp).
If unknown → move to error_claims. Keeps looping forever, checking every 2 seconds the incoming claim folder

import: Allows you to use classes from other libraries.
java.io.IOException: Handles input/output errors (like file problems).
java.nio.file.*: Provides classes for working with files and directories (Path, Files, etc.).
java.time.LocalDateTime: Represents date and time.
java.time.format.DateTimeFormatter: Helps format date/time into readable strings

📦 Dependencies & Usage
JDK (Java SE 8 or higher)
✅ Already included with Java.
Usage: Provides java.nio.file, java.time, java.util.concurrent, etc. (core APIs used for file handling, scheduling, and timestamps).

SLF4J + Logback (Logging is an interface)
Dependency: org.slf4j:slf4j-api + ch.qos.logback:logback-classic.
Usage: Replace System.out.println with structured logging (log.info(), log.error()). Supports log levels, file logging, and better debugging.

Commons Configuration (Config Management)
Dependency: org.apache.commons:commons-configuration2
Usage: Reads application.properties cleanly. Makes it easy to manage external configuration without hardcoding values.

JUnit (Testing)
Dependency: org.junit.jupiter:junit-jupiter
Usage: Write unit tests for file ingestion logic (e.g., test corrupt file handling, archive naming). Ensures program works as expected.

Key Types in java.nio.file

Path → An interface that represents a file or directory path in the filesystem. It’s more flexible than the old File class and supports advanced path operations (like normalization, joining, and relative paths).
Paths → A final class with static factory methods to create Path objects easily (e.g., Paths.get("file.txt")).
Files → A final class containing static utility methods for file operations such as reading, writing, copying, moving, and deleting.
FileSystems → A final class that provides access to the default filesystem and allows creation or retrieval of custom filesystems.
WatchService → An interface that lets you register directories and listen for file system events (like file creation, deletion, or modification).
StandardWatchEventKinds → A final class containing constants that represent event types (ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY) used with the WatchService API.

Path: Represents a file or directory location.
Paths.get("..."): Creates a path object pointing to a folder.
.resolve("..."): Creates a subfolder inside the base folder.

These variables define the folder structure:

File Handling Workflow:
BASE → main folder claims_processing
INCOMING → subfolder incoming_claims
PROCESSING → subfolder processing_claims
PROCESSED → subfolder processed_claims
ERROR → subfolder error_claims
ARCHIVE → subfolder claims_archive

POLLING_MS = 2000: The program waits 2000 milliseconds (2 seconds) between checks.

FORMATTER: Defines how date/time will look, e.g. 20260103_0627

throws IOException, InterruptedException: Declares that this method might throw errors related to files or thread sleeping.

Creates all required folders if they don’t already exist. Files.createDirectories(dir): Makes sure each directory exists

logInfo(message) -> Prints messages to the console with timestamps.

BASE.toAbsolutePath(): Shows the full path on your computer.

Files.list(INCOMING): Lists all files in the incoming_claims folder.
.filter(Files::isRegularFile): Only considers actual files (not folders).
.forEach(file -> { ... }): Loops through each file found
File.move() -> Moves a file from one folder to another.
StandardCopyOption.REPLACE_EXISTING: Overwrites if file already exists.
logInfo(message) -> Logs a message after moving.

In Java, a daemon thread is a background thread that runs behind the scenes. It’s different from a user thread: User threads keep the JVM alive until they finish.
Daemon threads do not prevent the JVM from exiting. When all user threads finish, the JVM will automatically stop, even if daemon threads are still running.

Executors

This is a utility class in Java (java.util.concurrent.Executors) that helps you create and manage threads easily.
Instead of manually creating threads with new Thread(...), you use Executors to get a ready‑made thread pool.
newSingleThreadScheduledExecutor(): This method creates a ScheduledExecutorService with only one thread.

"Scheduled" means it can run tasks repeatedly or after a delay.
"SingleThread" means only one background thread will be used to run tasks, so tasks run one after another (no parallel execution).

var scheduler
var is Java’s local variable type inference (since Java 10). It automatically figures out the type of scheduler based on what newSingleThreadScheduledExecutor() returns.
In this case, the type is ScheduledExecutorService.


App.java

Entry point (main method).
Starts the application: loads config, initializes directories, starts the service.
Think of it as the “switch that turns everything on.”

Config.java

Handles configuration (like base directory, polling interval, timestamp format).
Reads values from application.properties.
Provides helper methods to get paths (incoming, processing, etc.).
Keeps all settings in one place so they’re easy to change.

IngestionService.java
Core business logic.
Watches the incoming_claims folder.
Decides what to do with each file (process, archive, error).
Runs continuously in a background thread.
This is the “engine” of your application.

application.properties (external config file)

Stores settings outside the code (like base.dir, polling.ms).
Makes the app flexible: you can change behavior without editing Java code.
