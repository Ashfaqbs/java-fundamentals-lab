public class StringFunctionsDemo {
    public static void main(String[] args) {
        // Initial string to play with
        String str = "Hello, World!";

        // 1. length() - Returns the length of the string
        System.out.println("Length of the string: " + str.length());
        // Output: Length of the string: 13

        // 2. charAt() - Returns the character at a specific index
        System.out.println("Character at index 7: " + str.charAt(7));
        // Output: Character at index 7: W

        // 3. substring() - Extracts a portion of the string
        System.out.println("Substring from index 7: " + str.substring(7));
        // Output: Substring from index 7: World!

        System.out.println("Substring from index 7 to 12: " + str.substring(7, 12));
        // Output: Substring from index 7 to 12: World

        // 4. toUpperCase() - Converts the string to uppercase
        System.out.println("Uppercase version: " + str.toUpperCase());
        // Output: Uppercase version: HELLO, WORLD!

        // 5. toLowerCase() - Converts the string to lowercase
        System.out.println("Lowercase version: " + str.toLowerCase());
        // Output: Lowercase version: hello, world!

        // 6. contains() - Checks if the string contains a specific sequence
        System.out.println("Does the string contain 'World'? " + str.contains("World"));
        // Output: Does the string contain 'World'? true

        // 7. startsWith() - Checks if the string starts with a specific prefix
        System.out.println("Does the string start with 'Hello'? " + str.startsWith("Hello"));
        // Output: Does the string start with 'Hello'? true

        // 8. endsWith() - Checks if the string ends with a specific suffix
        System.out.println("Does the string end with 'World!'? " + str.endsWith("World!"));
        // Output: Does the string end with 'World!'? true

        // 9. indexOf() - Finds the first occurrence of a character or substring
        System.out.println("Index of 'World': " + str.indexOf("World"));
        // Output: Index of 'World': 7

        System.out.println("Index of 'o': " + str.indexOf('o'));
        // Output: Index of 'o': 4

        // 10. lastIndexOf() - Finds the last occurrence of a character or substring
        System.out.println("Last index of 'o': " + str.lastIndexOf('o'));
        // Output: Last index of 'o': 8

        // 11. replace() - Replaces occurrences of a character or substring
        System.out.println("Replace 'World' with 'Java': " + str.replace("World", "Java"));
        // Output: Replace 'World' with 'Java': Hello, Java!

        // 12. trim() - Removes leading and trailing whitespaces
        String strWithSpaces = "   Hello, World!   ";
        System.out.println("After trim: '" + strWithSpaces.trim() + "'");
        // Output: After trim: 'Hello, World!'

        // 13. isEmpty() - Checks if the string is empty
        String emptyString = "";
        System.out.println("Is the string empty? " + emptyString.isEmpty());
        // Output: Is the string empty? true

        // 14. split() - Splits the string into an array using a delimiter
        String[] words = str.split(", ");
        System.out.println("Split by ', ': ");
        for (String word : words) {
            System.out.println(word);
        }
        // Output:
        // Split by ', ':
        // Hello
        // World!

        // 15. equals() - Compares two strings for equality
        System.out.println("Does the string equal 'Hello, World!'? " + str.equals("Hello, World!"));
        // Output: Does the string equal 'Hello, World!'? true

        // 16. equalsIgnoreCase() - Compares two strings, ignoring case
        System.out.println("Does the string equal 'hello, world!' (case insensitive)? " + str.equalsIgnoreCase("hello, world!"));
        // Output: Does the string equal 'hello, world!' (case insensitive)? true
    }
}
