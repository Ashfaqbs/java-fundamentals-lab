# Encryption-JAVA

Encryption is the process of converting plain text into a secret code or cipher text using an algorithm and a key. The encrypted message can only be decrypted back into the original plain text by someone who knows the key.

Encryption is used to protect sensitive data from unauthorized access or to keep the data secret from hackers, attackers, or eavesdroppers. It is used in various fields such as finance, healthcare, government, military, and communications.

In Java, encryption can be implemented using various cryptographic algorithms such as AES, Blowfish, DES, and RSA. These algorithms provide different levels of security and encryption strength.

To implement encryption in Java, you need to follow these steps:

Choose a cryptographic algorithm: Select an encryption algorithm based on your security needs and requirements.

Generate a key: The encryption algorithm requires a key to encrypt and decrypt the data. The key should be kept secure and secret.

Create a Cipher object: The Cipher class provides methods for encryption and decryption. Create a Cipher object and initialize it with the encryption algorithm and key.

Encrypt the data: Pass the data to be encrypted to the Cipher object's encrypt method. The encrypt method returns the encrypted data in bytes.

Decrypt the data: Pass the encrypted data to the Cipher object's decrypt method. The decrypt method returns the original data in bytes.

Convert the data: Convert the encrypted or decrypted bytes into a readable format such as a string or a file.



## Why do we need a key here , and what it should  be
Encryption is a process of transforming plaintext (original message) into ciphertext (encrypted message) using a secret key. The key is used to control the transformation of plaintext into ciphertext and vice versa, so that the encrypted message can only be read by someone who knows the key.

In the case of Blowfish and Triple DES encryption, you need to provide a secret key to the encryption and decryption algorithms. The key should be a sequence of bytes with a specific length depending on the encryption algorithm. For Blowfish, the key size can be between 32 and 448 bits (4 to 56 bytes), and for Triple DES, the key size is 168 bits (24 bytes).

It's important to choose a strong and secure key to ensure the confidentiality of the encrypted data. A strong key should be long and complex, using a combination of upper and lower case letters, numbers, and special characters. It's also recommended to use a key derivation function to generate the key from a password or passphrase, which can increase the security of the key.

In practice, you should generate a random key using a secure random number generator or derive a key using a key derivation function like PBKDF2 or bcrypt, and store the key securely, for example, in a key management system or a secure file system.



The best encryption algorithm to use depends on the specific use case and the level of security required. Generally speaking, the Advanced Encryption Standard (AES) is considered to be one of the most secure encryption algorithms available today.

To implement AES encryption in Java, you can use the built-in Java Cryptography Extension (JCE) library.

          import javax.crypto.Cipher;
          import javax.crypto.spec.SecretKeySpec;
          import java.util.Base64;

     public class AESEncryption {

    private static final String ALGORITHM = "AES";
    private static final String CIPHER_TRANSFORMATION = "AES/ECB/PKCS5Padding";
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
        String plaintext = "This is a secret message";
        String key = "0123456789abcdef";
        String ciphertext = encrypt(plaintext, key);
        System.out.println("Encrypted Text: " + ciphertext);
        String decryptedText = decrypt(ciphertext, key);
        System.out.println("Decrypted Text: " + decryptedText);
     }
     }


Strong key Gen


     import javax.crypto.KeyGenerator;
     import javax.crypto.SecretKey;

     public class AESKeyGenerator {
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // AES-256
        return keyGen.generateKey();
      }
       }

    
    
    
   In this example, the AESEncryption class has two methods: encrypt and decrypt. The encrypt method takes a string input and a key, creates an instance of the AES cipher, initializes it with the key, and then uses it to encrypt the input string. The resulting encrypted bytes are then converted to a string and returned. The decrypt method does the reverse: it takes an encrypted string input and a key, creates an instance of the AES cipher, initializes it with the key, and then uses it to decrypt the input string. The resulting decrypted bytes are then converted to a string and returned.

To use this class, you can create an instance of AESEncryption and call the encrypt and decrypt methods as needed. In the example main method, we create an instance of the class and use it to encrypt and decrypt a sample string.

Note that AES is a strong encryption algorithm, but this example uses a static key for simplicity. In practice, you should use a more secure method for generating and managing your encryption keys.



Java class that generates and manages AES encryption keys securely:


     import javax.crypto.*;
       import javax.crypto.spec.SecretKeySpec;
     import java.nio.charset.StandardCharsets;
     import java.security.InvalidKeyException;
    import java.security.NoSuchAlgorithmException;
     import java.security.SecureRandom;
     import java.util.Base64;

     public class SecureAESEncryption {

    private static final String AES_ALGORITHM = "AES";
    private static final int KEY_SIZE = 256;

    private SecretKeySpec secretKeySpec;

    public SecureAESEncryption() throws NoSuchAlgorithmException {
        this.generateSecretKey();
    }

    public String encrypt(String input) throws NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, this.secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String input) throws NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, this.secretKeySpec);
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
     }

    private void generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance(AES_ALGORITHM);
        SecureRandom secureRandom = new SecureRandom();
        keyGen.init(KEY_SIZE, secureRandom);
        SecretKey secretKey = keyGen.generateKey();
        byte[] encodedKey = secretKey.getEncoded();
        this.secretKeySpec = new SecretKeySpec(encodedKey, AES_ALGORITHM);
     }

    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException   {
        String input = "This is a string to be encrypted with AES.";

        // Create an instance of SecureAESEncryption
        SecureAESEncryption encryption = new SecureAESEncryption();

        // Encrypt the input string
        String encryptedString = encryption.encrypt(input);
        System.out.println("Encrypted string: " + encryptedString);

        // Decrypt the encrypted string
        String decryptedString = encryption.decrypt(encryptedString);
        System.out.println("Decrypted string: " + decryptedString);
     }
     }
     
     
     
  Sure! Here's an example of a Java class that generates and manages AES encryption keys securely:


      import javax.crypto.*;
       import javax.crypto.spec.SecretKeySpec;
     import java.nio.charset.StandardCharsets;
     import java.security.InvalidKeyException;
    import java.security.NoSuchAlgorithmException;
    import java.security.SecureRandom;
     import java.util.Base64;

     public class SecureAESEncryption {

    private static final String AES_ALGORITHM = "AES";
    private static final int KEY_SIZE = 256;

    private SecretKeySpec secretKeySpec;

    public SecureAESEncryption() throws NoSuchAlgorithmException {
        this.generateSecretKey();
    }

    public String encrypt(String input) throws NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, this.secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String input) throws NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, this.secretKeySpec);
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    private void generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance(AES_ALGORITHM);
        SecureRandom secureRandom = new SecureRandom();
        keyGen.init(KEY_SIZE, secureRandom);
        SecretKey secretKey = keyGen.generateKey();
        byte[] encodedKey = secretKey.getEncoded();
        this.secretKeySpec = new SecretKeySpec(encodedKey, AES_ALGORITHM);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        String input = "This is a string to be encrypted with AES.";

        // Create an instance of SecureAESEncryption
        SecureAESEncryption encryption = new SecureAESEncryption();

        // Encrypt the input string
        String encryptedString = encryption.encrypt(input);
        System.out.println("Encrypted string: " + encryptedString);

        // Decrypt the encrypted string
        String decryptedString = encryption.decrypt(encryptedString);
        System.out.println("Decrypted string: " + decryptedString);
    }
}
In this example, the SecureAESEncryption class uses the KeyGenerator class to generate a 256-bit AES key. The key is then stored securely in a SecretKeySpec object, which is used to initialize the cipher in the encrypt and decrypt methods. This ensures that the encryption key is generated securely and managed properly.

To use this class, you can create an instance of SecureAESEncryption and call the encrypt and decrypt methods as needed. In the example main method, we create an instance of the class and use it to encrypt and decrypt a sample string.


Note that this example uses Base64 encoding to convert the encrypted bytes to a string, and vice versa. This is necessary because the encrypted bytes may contain binary data that cannot be represented as a string directly.

