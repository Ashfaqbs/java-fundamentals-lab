package ChatGpt;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class IP_ddress {
	
	  public static void main(String[] args) {
		    try {
		      InetAddress inetAddress = InetAddress.getLocalHost();
		      String ipAddress = inetAddress.getHostAddress();
		      System.out.println("IP address: " + ipAddress);
		    } catch (UnknownHostException e) {
		      e.printStackTrace();
		    }
		  }


}
//To get the IP address of the current host in Java, you can use the InetAddress class
//from the java.net package. Here is an example of how you can use InetAddress to get the IP address of the current host:
