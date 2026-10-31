package ChatGpt.UsingPassintxt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtil {

	private static final String KEY = "mySecretKey12345"; // secret key for encryption/decryption

	public static String encrypt(String strToEncrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY.getBytes(), "AES"));
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public static String decrypt(String strToDecrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(KEY.getBytes(), "AES"));
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

	public static void main(String[] args) {

		String encrypt = encrypt("ashfaq@gmail.com");

		String encrypt2 = encrypt("dummy123");    	


		System.out.println(encrypt);
		System.out.println("-----------------");
		System.out.println( encrypt2);
		
		System.out.println();

		System.out.println(decrypt(encrypt));
		System.out.println("-----------------");
		System.out.println(decrypt(encrypt2));


	}
}
