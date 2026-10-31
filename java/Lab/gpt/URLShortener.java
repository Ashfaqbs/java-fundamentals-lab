package ChatGpt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class URLShortener {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the URL to shorten: ");
        String longUrl = reader.readLine();

        URL url = new URL("http://tinyurl.com/api-create.php?url=" + URLEncoder.encode(longUrl, "UTF-8"));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        
        BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String shortUrl = responseReader.readLine();
        responseReader.close();

        System.out.println("Short URL: " + shortUrl);
    }
}
