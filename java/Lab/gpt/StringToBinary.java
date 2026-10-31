package ChatGpt;

public class StringToBinary {

	
	 public static void main(String[] args) {
	        String inputString = "Hello World";
	        byte[] bytes = inputString.getBytes(); // convert string to byte array
	        StringBuilder binary = new StringBuilder(); // create a StringBuilder to hold binary string
	        for (byte b : bytes) {
	            int val = b;
	            for (int i = 0; i < 8; i++) {
	                binary.append((val & 128) == 0 ? 0 : 1); // append binary representation of byte to StringBuilder
	                val <<= 1;
	            }
	            binary.append(' '); // add a space between each byte
	        }
	        System.out.println("Binary representation of " + inputString + ":\n" + binary);
	    }
}
