package FileHandling;

import java.nio.file.*;

public class FileReaderDemo {
    public static void main(String[] args) throws Exception {
        Path configPath = Paths.get("C:\\tmp\\appdata\\configs\\app.properties");

        String content = Files.readString(configPath);
        System.out.println("📄 Config file content:\n" + content);
    }
}
