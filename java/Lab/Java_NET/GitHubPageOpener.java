/**
 * Code developed by Ashfaq (© [Year])
 * GitHub: https://github.com/DarkSharkAsh
 */



package Java_NET;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GitHubPageOpener {
    public static void main(String[] args) {
        String githubUrl = "https://github.com/DarkSharkAsh"; // Replace with your GitHub URL
        int totalRequests = 100;
        int delayInSeconds = 2;

        try {
            for (int i = 0; i < totalRequests; i++) {
                System.out.println("Opening GitHub page attempt " + (i + 1));
                openGitHubPage(githubUrl);

                // Sleep for the specified delay in seconds
                Thread.sleep(delayInSeconds * 1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void openGitHubPage(String url) {
        try {
            URL githubURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) githubURL.openConnection();
            connection.setRequestMethod("GET");

            // Read the response from GitHub
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // You can print or process the GitHub page content here
            // For now, we'll just print the response code
            System.out.println("Response Code: " + connection.getResponseCode());

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
