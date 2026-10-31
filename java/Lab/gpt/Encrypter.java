package ChatGpt;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class Encrypter {
	
	

	  private static final String ALGORITHM = "AES";
	  private static final byte[] KEY = "MyVerySecureKey".getBytes();

	  public static String encrypt(String value) throws Exception {
	    Key key = new SecretKeySpec(KEY, ALGORITHM);
	    Cipher cipher = Cipher.getInstance(ALGORITHM);
	    cipher.init(Cipher.ENCRYPT_MODE, key);
	    byte[] encryptedValue = cipher.doFinal(value.getBytes());
	    return Base64.getEncoder().encodeToString(encryptedValue);
	  }

	  public static String decrypt(String value) throws Exception {
	    Key key = new SecretKeySpec(KEY, ALGORITHM);
	    Cipher cipher = Cipher.getInstance(ALGORITHM);
	    cipher.init(Cipher.DECRYPT_MODE, key);
	    byte[] decryptedValue = cipher.doFinal(Base64.getDecoder().decode(value));
	    return new String(decryptedValue);
	  }
	public static void main(String[] args) throws Exception {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		String encrypt = Encrypter.encrypt("Ashfaq@786");
		
		String decrypt = Encrypter.decrypt(encrypt);
		System.out.println(encrypt+" "+decrypt);
	}

}
/////////////////////////////////////JAVAX>MAIL email and password encryptor//////////////////////////////////////////////
//You can then use the MyAuthenticator class as the 
//authenticator when creating a Session object to send email using the JavaMail API.

//import javax.mail.Authenticator;
//import javax.mail.PasswordAuthentication;
//
//public class MyAuthenticator extends Authenticator {
//  private String email;
//  private String password;
//
//  public MyAuthenticator(String email, String password) {
//    this.email = email;
//    this.password = password;
//  }
//
//  @Override
//  protected PasswordAuthentication getPasswordAuthentication() {
//    try {
//      // Encrypt the email and password
//      String encryptedEmail = CryptographyUtils.encrypt(email);
//      String encryptedPassword = CryptographyUtils.encrypt(password);
//
//      // Return the encrypted email and password as the authentication credentials
//      return new PasswordAuthentication(encryptedEmail, encryptedPassword);
//    } catch (Exception e) {
//      e.printStackTrace();
//      return null;
//    }
//  }
//}
//Properties props = new Properties();
//props.put("mail.smtp.auth", "true");
//props.put("mail.smtp.starttls.enable", "true");
//props.put("mail.smtp.host", "smtp.example.com");
//props.put("mail.smtp.port", "587");
//
//String email = "user@example.com";
//String password = "password";
//
//Authenticator authenticator = new MyAuthenticator(email, password);
//Session session = Session.getInstance(props, authenticator);
//
//// Use the session to send