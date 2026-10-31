package ChatGpt;

public class Code_to_get_computer_details {

	
	
	
	
	public static void main(String[] args) {
	    // Get the current working directory
	    String currentDirectory = System.getProperty("user.dir");
	    System.out.println("Current working directory: " + currentDirectory);

	    // Get the current user's home directory
	    String homeDirectory = System.getProperty("user.home");
	    System.out.println("Current user's home directory: " + homeDirectory);

	    // Get the name of the operating system
	    String osName = System.getProperty("os.name");
	    System.out.println("Operating system name: " + osName);

	    // Get the version of the operating system
	    String osVersion = System.getProperty("os.version");
	    System.out.println("Operating system version: " + osVersion);

	    // Get the architecture of the operating system
	    String osArchitecture = System.getProperty("os.arch");
	    System.out.println("Operating system architecture: " + osArchitecture);
	    

	  }
	
	
	
}
//You can also use the java.lang.Runtime class to get information about the computer's hardware, 
//such as the number of processors and the amount of available memory. For example:
//import java.lang.Runtime;
//
//public class Main {
//  public static void main(String[] args) {
//    // Get the runtime instance
//    Runtime runtime = Runtime.getRuntime();
//
//    // Get the number of processors
//    int processors = runtime.availableProcessors();
//    System.out.println("Number of processors: " + processors);
//
//    // Get the amount of available memory
//    long freeMemory = runtime.freeMemory();
//    System.out.println("Amount of available memory (bytes): " + freeMemory);
//  }
//} 
