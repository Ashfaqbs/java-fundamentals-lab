
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AES256Encryption {

    private static final String ALGORITHM = "AES";
    private static final String CIPHER_TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final String CHARSET = "UTF-8";

    public static String encrypt(String plaintext, SecretKeySpec secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(ciphertext);
    }

    public static String decrypt(String ciphertext, SecretKeySpec secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decryptedBytes);
    }

    public static SecretKeySpec generateStrongSecretKey() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[32];
        secureRandom.nextBytes(key);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, ALGORITHM);
        return secretKeySpec;
    }
    
    public static void main(String[] args) throws Exception {
        SecretKeySpec secretKey = AES256Encryption.generateStrongSecretKey();
        String plaintext = "Hello Good morning";
        String encryptedText = AES256Encryption.encrypt(plaintext, secretKey);
        String decryptedText = AES256Encryption.decrypt(encryptedText, secretKey);

        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted text: " + encryptedText);
        System.out.println("Decrypted text: " + decryptedText);
    }

}


o/p

Plaintext: Hello Good morning
Encrypted text: 7YB5RGfqoKRSEiTiqHkE0BeFpy4mwCnDHqYAbIzjdEg=
Decrypted text: Hello Good morning
