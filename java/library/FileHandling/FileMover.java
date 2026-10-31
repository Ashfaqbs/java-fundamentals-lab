package FileHandling;

import java.nio.file.*;

public class FileMover {
    public static void main(String[] args) throws Exception {
        Path source = Paths.get("C:\\tmp\\appdata\\logs\\app.log");
        Path target = Paths.get("C:\\tmp\\appdata\\logs\\archived.log");

        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);

        System.out.println("📁 File moved to: " + target);
    }
}
