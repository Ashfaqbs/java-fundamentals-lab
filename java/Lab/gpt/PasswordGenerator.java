package ChatGpt;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PasswordGenerator {

    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;':\"<>,.?/~`";
    private static final String ALL_CHARS = LOWERCASE_CHARS + UPPERCASE_CHARS + NUMERIC_CHARS + SPECIAL_CHARS;

    public static void main(String[] args) {
        int passwordLength = 12; // length of the password
        String generatedPassword = generatePassword(passwordLength);
        System.out.println("Generated Password: " + generatedPassword);
    }

    public static String generatePassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";

        String allChars = upper + lower + numbers + symbols;

        Random random = new Random();

        List<Character> chars = allChars.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.shuffle(chars);

        String password = chars.stream().limit(length).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        return password;
    }
}
