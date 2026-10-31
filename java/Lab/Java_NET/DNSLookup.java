package Java_NET;

import java.net.InetAddress;

public class DNSLookup {
 public static void main(String[] args) throws Exception {
//   InetAddress[] addresses = InetAddress.getAllByName("localhost");
   InetAddress[] addresses = InetAddress.getAllByName("www.amazon.in");


   for (InetAddress address : addresses) {
       System.out.println(address.getHostAddress());
   }
}
}