package ChatGpt;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Pattern;

public class FileSearcher {

	
	  public static void search(Path dir, Pattern pattern) throws IOException {
		    Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
		      @Override
		      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		        if (pattern.matcher(file.toString()).matches()) {
		          System.out.println(file);
		        }
		        return FileVisitResult.CONTINUE;
		      }
		    });
		  }
}
////calling this method
//Path dir = Paths.get("/path/to/dir");
//Pattern pattern = Pattern.compile(".*\\.txt");
//FileSearcher.search(dir, pattern);


//This search method takes a Path object representing the directory to search, and a Pattern object representing the pattern to search for. It uses the walkFileTree method of the Files class to traverse the directory tree, and the visitFile method of a SimpleFileVisitor to process each file. The visitFile method 
//checks if the file's path matches the given pattern, and if it does, it prints the file's path to the console.
//This will search the directory tree rooted at /path/to/dir for files with a .txt extension, and print their paths to the console.
//
//Note that this example is just one way to solve the problem. There are many other ways you could implement a
//recursive file search in Java, using different classes and methods from the standard library.