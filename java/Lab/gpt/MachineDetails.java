package ChatGpt;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class MachineDetails {
	
	public static void main(String[] args) throws UnknownHostException {
	    // Get the IP address of the machine
		
		InetAddress inetAddress1 = InetAddress.getLocalHost();
	      String ipAddress1 = inetAddress1.getHostAddress();
	    String ipAddress = ipAddress1;  // Replace with the desired IP address
	    InetAddress inetAddress = null;
	    try {
	      inetAddress = InetAddress.getByName(ipAddress);
	    } catch (UnknownHostException e) {
	      e.printStackTrace();
	    }

	    if (inetAddress != null) {
	      // Get the host name
	      String hostName = inetAddress.getHostName();

	      // Get the IP address
	      String ip = inetAddress.getHostAddress();

	      
	      
	      
	      // Get the canonical host name
	      String canonicalHostName = inetAddress.getCanonicalHostName();

	      // Print the details
	      System.out.println("Host name: " + hostName);
	      System.out.println("IP address: " + ip);
	      System.out.println("Canonical host name: " + canonicalHostName);
	    }
	  }
	

}


//This code uses the getByName method of the InetAddress class to look up the details of the machine with the
//specified IP address. It then uses the getHostName, getHostAddress, and
//getCanonicalHostName methods to get the host name, IP address, and canonical host name of the machine, respectively.
//
//Keep in mind that this code will only work if the IP address of the machine
//is reachable from the machine where the code is being executed. If the machine is not reachable, 
//the getByName method will throw a UnknownHostException.