package FileHandling;

import java.nio.file.*;
import java.io.IOException;

public class TempDirFileExample {
    public static void main(String[] args) {
        try {
            // Step 1: Define the temp directory path
            Path tempDir = Paths.get("C:\\tmp\\myTempDir");

            // Step 2: Create the directory if it doesn't exist
            if (!Files.exists(tempDir)) {
                Files.createDirectories(tempDir); // creates all missing parent dirs
                System.out.println("Temp directory created at: " + tempDir);
            } else {
                System.out.println("Temp directory already exists: " + tempDir);
            }

            // Step 3: Create a file inside the temp directory
            Path filePath = tempDir.resolve("sample.txt");

            if (!Files.exists(filePath)) {
                String content = "This is a test file inside the temp directory.";
                Files.write(filePath, content.getBytes());
                System.out.println("File created with content: " + filePath);
            } else {
                System.out.println("File already exists: " + filePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

