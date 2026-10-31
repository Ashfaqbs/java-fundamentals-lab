package FileHandling;

import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;

public class LogDirectoryWatcher {
    public static void main(String[] args) throws Exception {
        Path logDir = Paths.get("C:\\tmp\\appdata\\logs");

        WatchService watchService = FileSystems.getDefault().newWatchService();

        logDir.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);

        System.out.println("👀 Watching directory: " + logDir);

        while (true) {
            WatchKey key = watchService.take(); // waits for an event

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                @SuppressWarnings("unchecked")
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path fileName = ev.context();

                System.out.printf("🔔 Event: %-10s -> %s%n", kind.name(), fileName);
            }

            boolean valid = key.reset(); // resets for next event
            if (!valid) {
                System.out.println("🔁 Watch key no longer valid");
                break;
            }
        }
    }
}
/*
Keep this Java program running.

Open C:\tmp\appdata\logs.

Create a file (test.log) → it prints ENTRY_CREATE

Edit it → it prints ENTRY_MODIFY

Delete it → ENTRY_DELETE

This works like file-level observability in real-time, like what IDEs or log processors do internally.



App output

PS C:\tmp\java\library\FileHandling> java .\LogDirectoryWatcher.java
???? Watching directory: C:\tmp\appdata\logs
???? Event: ENTRY_CREATE -> New Text Document.txt
???? Event: ENTRY_DELETE -> New Text Document.txt
???? Event: ENTRY_CREATE -> test.log
???? Event: ENTRY_MODIFY -> test.log
???? Event: ENTRY_MODIFY -> test.log
???? Event: ENTRY_MODIFY -> test.log
???? Event: ENTRY_MODIFY -> test.log
???? Event: ENTRY_MODIFY -> test.log
???? Event: ENTRY_MODIFY -> test.log
???? Event: ENTRY_MODIFY -> test.log
???? Event: ENTRY_MODIFY -> test.log
???? Event: ENTRY_MODIFY -> test.log
???? Event: ENTRY_MODIFY -> test.log
???? Event: ENTRY_MODIFY -> test.log
???? Event: ENTRY_MODIFY -> test.log
???? Event: ENTRY_MODIFY -> test.log
???? Event: ENTRY_DELETE -> test.log


 */