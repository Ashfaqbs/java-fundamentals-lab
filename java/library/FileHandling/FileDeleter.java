package FileHandling;

import java.nio.file.*;

public class FileDeleter {
    public static void main(String[] args) throws Exception {
        Path fileToDelete = Paths.get("C:\\tmp\\appdata\\configs\\app.backup.properties");

        if (Files.exists(fileToDelete)) {
            Files.delete(fileToDelete);
            System.out.println("❌ Deleted: " + fileToDelete);
        } else {
            System.out.println("⚠️ File doesn't exist: " + fileToDelete);
        }
    }
}
