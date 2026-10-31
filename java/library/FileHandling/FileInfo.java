package FileHandling;

import java.nio.file.*;
import java.nio.file.attribute.*;

public class FileInfo {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("C:\\tmp\\appdata\\configs\\app.properties");

        BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);

        System.out.println("📦 File Info:");
        System.out.println("Size: " + attrs.size() + " bytes");
        System.out.println("Created: " + attrs.creationTime());
        System.out.println("Last Modified: " + attrs.lastModifiedTime());
        System.out.println("Is Directory: " + attrs.isDirectory());
    }
}

/*
PS C:\tmp\java\library\FileHandling> java .\FileInfo.java
???? File Info:
Size: 54 bytes
Created: 2025-04-14T06:47:52.060261Z
Last Modified: 2025-04-14T06:47:52.0612589Z
Is Directory: false
PS C:\tmp\java\library\FileHandling>

 */