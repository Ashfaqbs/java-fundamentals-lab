package FileHandling;

import java.nio.file.*;

import java.nio.file.*;
import java.io.IOException;

public class FileCopier {
    public static void main(String[] args) throws IOException {
        Path configDir = Paths.get("C:\\tmp\\appdata\\configs");
        Path source = configDir.resolve("app.properties");
        Path target = configDir.resolve("app.backup.properties");

        // Copy the file
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("📁 File copied to backup: " + target);

        // List all files in the configs directory
        System.out.println("📂 Files in 'configs' directory:");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(configDir)) {
            for (Path file : stream) {
                System.out.println(" - " + file.getFileName());
            }
        }
    }
}
