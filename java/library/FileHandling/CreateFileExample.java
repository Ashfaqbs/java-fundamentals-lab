package FileHandling;

import java.nio.file.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class CreateFileExample {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("C:\\tmp\\javaneopackage\\tempFile.txt");

        if (!Files.exists(filePath)) {
            // Create the file
            Files.createFile(filePath);

            // Content to write
            String content = "Hello! This is the initial content of the file.\nWelcome to Java file handling!";
            Files.write(filePath, content.getBytes());

            System.out.println("File created and content written: " + filePath);
        } else {
            // Read and print the content of the file
            List<String> lines = Files.readAllLines(filePath);
            System.out.println("File already exists. Content:");
            for (String line : lines) {
                System.out.println(line);
            }
        }
    }
}
