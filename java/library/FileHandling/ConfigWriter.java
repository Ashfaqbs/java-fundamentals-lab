package FileHandling;

import java.nio.file.*;
import java.io.IOException;

public class ConfigWriter {
    public static void main(String[] args) throws IOException {
        Path configPath = Paths.get("C:\\tmp\\appdata\\configs\\app.properties");

        String configData = """
                app.name=NeoPackage
                app.version=1.0
                app.author=Ashfaq
                """;

        Files.writeString(configPath, configData); // overwrites if exists
        System.out.println("✅ Config file written at: " + configPath);
    }
}
