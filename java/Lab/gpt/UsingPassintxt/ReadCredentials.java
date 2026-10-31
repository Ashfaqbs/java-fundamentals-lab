package ChatGpt.UsingPassintxt;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadCredentials {

	public static void main(String[] args) {
		//basic file with open email and pass
		//        File credentialsFile = new File("C:\\Users\\Ashfaq PC\\eclipse-workspace\\Javacore8\\src\\ChatGpt\\UsingPassintxt\\credentials.txt");

		//    	passing encrypt mail and pass file
		File credentialsFile = new File("C:\\Users\\Ashfaq PC\\eclipse-workspace\\Javacore8\\src\\ChatGpt\\UsingPassintxt\\credentialsEnc.txt");


		String username = "";
		String password = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader(credentialsFile));
			String line;
			while ((line = br.readLine()) != null) {
				Pattern pattern = Pattern.compile("^(.+: )?(.*)$");
				Matcher matcher = pattern.matcher(line);
				if (matcher.find()) {
				    String encryptedValue = matcher.group(2);
				    if (username.isEmpty()) {
				    	
				        username = EncryptionUtil.decrypt(encryptedValue);
						System.out.println("Username: " + encryptedValue);

				    } else if (password.isEmpty()) {
				        password = EncryptionUtil.decrypt(encryptedValue);
						System.out.println("Password: " + encryptedValue);

				    }
				}
							}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
	}
}
