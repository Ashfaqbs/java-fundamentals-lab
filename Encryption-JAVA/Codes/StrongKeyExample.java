import java.security.SecureRandom;

public class StrongKeyExample {

    public static void main(String[] args) {
        // Generate a 256-bit key using SecureRandom
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[32];
        random.nextBytes(key);

        // Convert the key to a hexadecimal string for easy storage and retrieval
        String hexKey = bytesToHex(key);
        System.out.println("Hex key: " + hexKey);
    }

    // Helper method to convert a byte array to a hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02X", b));
        }
        return hex.toString();
    }
}
