package ChatGpt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleNewsScraper {

    public static void main(String[] args) throws Exception {
        String query = "money AND (gold OR stock)";
        String url1 = "https://www.google.com/search?q=" + query + "&tbm=nws";
        URLConnection connection = new URL(url1).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String html = response.toString();

        // Extract the article titles and URLs using regular expressions
        Pattern titlePattern = Pattern.compile("<h3 class=\"[^>]*\"><a[^>]*>(.*?)</a></h3>");
        Pattern urlPattern = Pattern.compile("<h3 class=\"[^>]*\"><a href=\"(.*?)\"[^>]*>");

        Matcher titleMatcher = titlePattern.matcher(html);
        Matcher urlMatcher = urlPattern.matcher(html);

        List<String> articleTitles = new ArrayList<>();
        List<String> articleUrls = new ArrayList<>();

        while (titleMatcher.find() && urlMatcher.find()) {
            String title = titleMatcher.group(1);
            String url = urlMatcher.group(1);
            articleTitles.add(title);
            articleUrls.add(url);
        }

        // Print the list of article titles and URLs
        System.out.println("Latest news articles about money, gold, and stocks:");
        for (int i = 0; i < articleTitles.size(); i++) {
            System.out.println("- " + articleTitles.get(i) + ": " + articleUrls.get(i));
        }
    }
}
