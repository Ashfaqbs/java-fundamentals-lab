package ChatGpt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class TripleDESEncryption {

    private static final String ALGORITHM = "DESede";
    private static final String CIPHER_TRANSFORMATION = "DESede/ECB/PKCS5Padding";
    private static final String CHARSET = "UTF-8";

    public static String encrypt(String plaintext, String key) throws Exception {
        byte[] keyBytes = key.getBytes(CHARSET);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(ciphertext);
    }

    public static String decrypt(String ciphertext, String key) throws Exception {
        byte[] keyBytes = key.getBytes(CHARSET);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decryptedBytes);
    }
    
    
    public static void main(String[] args) throws Exception {
		
    	
    	String plaintext = "Ashfaq";
        String key = "123456789012345678901234";//other keys are not  wokring

        // Encrypt plaintext using Blowfish
        String ciphertext = TripleDESEncryption.encrypt(plaintext, key);
        System.out.println("Encrypted: " + ciphertext);

        // Decrypt ciphertext using Blowfish
        String decryptedText = TripleDESEncryption.decrypt(ciphertext, key);
        System.out.println("Decrypted: " + decryptedText);
		
	}
}

//key generator for TDES encry
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//import java.security.NoSuchAlgorithmException;
//
//public class KeyGeneratorExample {
//
//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
//        keyGenerator.init(192); // set key size to 192 bits
//        SecretKey secretKey = keyGenerator.generateKey();
//        byte[] keyBytes = secretKey.getEncoded();
//        String hexKey = bytesToHex(keyBytes);
//        System.out.println("Hex key: " + hexKey);
//    }
//
//    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
//
//    public static String bytesToHex(byte[] bytes) {
//        char[] hexChars = new char[bytes.length * 2];
//        for (int i = 0; i < bytes.length; i++) {
//            int v = bytes[i] & 0xFF;
//            hexChars[i * 2] = HEX_ARRAY[v >>> 4];
//            hexChars[i * 2 + 1] = HEX_ARRAY[v & 0x0F];
//        }
//        return new String(hexChars);
//    }
//}
