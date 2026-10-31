### Java Regex

Regex (short for regular expression) is a sequence of characters that forms a search pattern. It is commonly used in programming languages and text editors to search for and manipulate text based on specific patterns.

A regex pattern can include a combination of literal characters and special characters, also known as metacharacters, which have a special meaning. For example, the dot (.) metacharacter matches any single character, while the asterisk (*) metacharacter matches zero or more occurrences of the preceding character or group.

Here are some common metacharacters used in regex:

^ Matches the beginning of a line or string.
$ Matches the end of a line or string.
. Matches any single character.
Matches zero or more occurrences of the preceding character or group.
Matches one or more occurrences of the preceding character or group.
? Matches zero or one occurrence of the preceding character or group.
 Matches any single character within the brackets.
( ) Groups characters together and creates a capture group.
{ } Specifies a range of occurrences for the preceding character or group.
For example, the regular expression pattern "^[A-Za-z]+$" matches any string that contains only uppercase or lowercase letters, while the pattern "^[0-9]{3}-[0-9]{2}-[0-9]{4}$" matches a valid US social security number in the format xxx-xx-xxxx.

Regex can be a powerful tool for text manipulation and searching, but it can also be complex and difficult to understand. It is important to carefully design and test regular expressions to ensure they behave as intended.


In Java, regular expressions are supported by the java.util.regex package, which provides the Pattern and Matcher classes for working with regex patterns.

Here is an example of using regex in Java to match email addresses:
         
           import java.util.regex.*;
      public class RegexExample {
        public static void main(String[] args) {
          String email = "john.doe@example.com";
          String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    
          // Compile the pattern
          Pattern p = Pattern.compile(pattern);
    
                / Create a matcher object
                atcher m = p.matcher(email);
    
          // Check if the email matches the pattern
          if (m.matches()) {
            System.out.println("Valid email address");
          } else {
            System.out.println("Invalid email address");
          }
        }
      }
      
   In Java, regular expressions are supported by the java.util.regex package, which provides the Pattern and Matcher classes for working with regex patterns.

Here is an example of using regex in Java to match email addresses:

## EG- 1

import java.util.regex.*;

public class RegexExample {
  public static void main(String[] args) {
    String email = "john.doe@example.com";
    String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    
    // Compile the pattern
    Pattern p = Pattern.compile(pattern);
    
    // Create a matcher object
    Matcher m = p.matcher(email);
    
    // Check if the email matches the pattern
    if (m.matches()) {
      System.out.println("Valid email address");
    } else {
      System.out.println("Invalid email address");
      }
      }
      }
      
      
      
In this example, we define a regex pattern that matches valid email addresses. The pattern consists of:

^ Matches the beginning of the string
[a-zA-Z0-9._%+-]+ Matches one or more occurrences of any letter, digit, period, underscore, percent sign, plus sign, or hyphen
@ Matches the at sign
[a-zA-Z0-9.-]+ Matches one or more occurrences of any letter, digit, period, or hyphen
\\. Matches a period (since the period is a metacharacter, we need to escape it with a backslash)
[a-zA-Z]{2,} Matches two or more occurrences of any letter
$ Matches the end of the string
We then use the Pattern class to compile the regex pattern and create a Matcher object, which we use to check if the email matches the pattern. If the email is valid, we print "Valid email address"; otherwise, we print "Invalid email address".




The output of the Java code example I provided will be:

          Valid email address



## EG-2

Assuming that the text file is in plain text format and the content follows a predictable structure where the "Skills" and "Projects" sections always begin with those words on a new line, you could use regex to extract the sentences following those headers.

Here's an example Java code snippet that reads in a text file and extracts the sentences following the "Skills" and "Projects" headers:

    import java.io.*;
    import java.util.regex.*;

     public class RegexExample {
    public static void main(String[] args) throws IOException {
    String fileName = "resume.txt";
    String skillsPattern = "(?<=Skills:\\n).*";
    String projectsPattern = "(?<=Projects:\\n).*";
    
    // Read in the file contents
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    StringBuilder content = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
      content.append(line).append("\n");
    }
    reader.close();
    
    // Extract the skills and projects
    String skills = extractText(content.toString(), skillsPattern);
    String projects = extractText(content.toString(), projectsPattern);
    
    // Print the results
    System.out.println("Skills: " + skills);
    System.out.println("Projects: " + projects);
    }
   
    private static String extractText(String input, String pattern) {
     Pattern p = Pattern.compile(pattern, Pattern.DOTALL);
    Matcher m = p.matcher(input);
    if (m.find()) {
        return m.group().trim();
      } else {
      return "";
       }
       }
       }





In this example, we define two regular expression patterns: skillsPattern and projectsPattern. These patterns use positive lookbehind assertions to match the content following the "Skills" and "Projects" headers, respectively. The Pattern.DOTALL flag is used to enable the . metacharacter to match any character, including newlines.

We then read in the contents of the text file using a BufferedReader and extract the "Skills" and "Projects" sections using the extractText method, which takes the input text and regex pattern as arguments. This method uses the Pattern and Matcher classes to match the regex pattern against the input text and extract the matched text.

Finally, we print out the extracted "Skills" and "Projects" sections. Note that if a section is not found in the input text, the extractText method returns an empty string.


Here's an example input file called "resume.txt" that we can use for testing the Java code I provided earlier:

  John Doe
 123 Main Street
 Anytown, USA 12345
 (123) 456-7890
 johndoe@email.com

 Objective:
 To obtain a position as a software engineer at a growing company.

 Skills:
  - Proficient in Java, Python, and C++
 - Strong problem-solving skills
 - Experience with Agile methodologies

 Education:
 Bachelor of Science in Computer Science
 XYZ University, Anytown, USA
 Graduated May 20xx

 Experience:
 Software Engineer
 ABC Company, Anytown, USA
 June 20xx - Present
 - Developed and maintained company's flagship product
 - Led a team of developers on a major feature release

 Projects:
 - Developed a mobile app that received over 1 million downloads on the Google Play Store
 - Contributed to open-source project XYZ


When you run the Java code I provided earlier, it should output the following:

 Skills: 
 - Proficient in Java, Python, and C++
 - Strong problem-solving skills
 - Experience with Agile methodologies

 Projects: 
 - Developed a mobile app that received over 1 million downloads on the Google Play Store
 - Contributed to open-source project XYZ
 
 
This output shows the extracted "Skills" and "Projects" sections from the input file. Note that the "Skills" section contains a list of bullet points, while the "Projects" section contains a list of short phrases. The regex pattern used in the Java code is able to extract these sections regardless of their specific formatting or content.



