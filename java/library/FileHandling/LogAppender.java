package FileHandling;

import java.nio.file.*;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogAppender {
    public static void main(String[] args) throws IOException {
        Path logPath = Paths.get("C:\\tmp\\appdata\\logs\\app.log");

        String logLine = LocalDateTime.now() + " - App started...\n";

        // Append mode: create file if not exists, append otherwise
        Files.writeString(
                logPath,
                logLine,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );

        System.out.println("✅ Log written to: " + logPath);
    }
}

