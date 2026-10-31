package ChatGpt;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

//import javax.mail.MessagingException;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;


public class WebScrapper_mail_20min {
	

    public static void main(String[] args) throws IOException, MessagingException {
        String url = "https://news.google.com";
        String fileName = "data.txt";
        String recipient = "user@example.com";

        while (true) {
            // Scrape data from the website
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("#some-element");

            // Save the data to a file
            StringBuilder data = new StringBuilder();
            for (Element element : elements) {
                data.append(element.text()).append("\n");
            }
            Files.write(Paths.get(fileName), data.toString().getBytes());

            // Send the file via email
            sendEmail(recipient, fileName);

            // Wait 20 minutes before scraping the website again
            try {
				TimeUnit.MINUTES.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    private static void sendEmail(String recipient, String fileName) throws MessagingException {
        // Implement email sending logic here
    }

}
