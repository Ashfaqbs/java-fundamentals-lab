package ChatGpt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadCredentials {

    public static void main(String[] args) {
//        File credentialsFile = new File("C:\\Users\\Ashfaq PC\\Documents\\credentials.txt");
        File credentialsFile = new File("credentials.txt");

        String username = "";
        String password = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(credentialsFile));
            String line;
            while ((line = br.readLine()) != null) {
                Pattern pattern = Pattern.compile("username: ([\\w\\d.@]+)|password: ([\\w\\d]+)");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    if (matcher.group(1) != null) {
                        username = matcher.group(1);
                    } else if (matcher.group(2) != null) {
                        password = matcher.group(2);
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
