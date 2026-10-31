package ChatGpt;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class BlowfishEncryption {

    private static final String ALGORITHM = "Blowfish";
    private static final String CIPHER_TRANSFORMATION = "Blowfish/ECB/PKCS5Padding";
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
        String key = "ThisIsABlowfishKey";

        // Encrypt plaintext using Blowfish
        String ciphertext = BlowfishEncryption.encrypt(plaintext, key);
        System.out.println("Encrypted: " + ciphertext);

        // Decrypt ciphertext using Blowfish
        String decryptedText = BlowfishEncryption.decrypt(ciphertext, key);
        System.out.println("Decrypted: " + decryptedText);
		
    	
    	
	}
}
