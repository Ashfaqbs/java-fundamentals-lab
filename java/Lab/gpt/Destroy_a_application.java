package ChatGpt;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Destroy_a_application {
	
	 public static void main(String[] args) throws Exception {
		 
	        // Replace "applicationName" with the name of the application you want to terminate
	        String applicationName = "chrome";

	        // Execute the command to kill the process
	        Process process = Runtime.getRuntime().exec("taskkill /F /IM " + applicationName + ".exe");
	        int exitCode = process.waitFor();

	        // Print the output of the command
	        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            System.out.println(line);
	        }

	        // Check the exit code of the command
	        if (exitCode == 0) {
	            System.out.println("Successfully terminated the application.");
	        } else {
	            System.out.println("Failed to terminate the application.");
	        }
	    }
	
	
	
	
	
	
	
	
	
	

}
