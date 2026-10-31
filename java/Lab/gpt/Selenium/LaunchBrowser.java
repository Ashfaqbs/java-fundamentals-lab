package ChatGpt.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class LaunchBrowser {
   public static void main(String[] args) {
      System.setProperty("webdriver.edge.driver", "C:\\Users\\Ashfaq PC\\Downloads\\msdriver\\msedgedriver.exe");
      WebDriver driver =new EdgeDriver();
      driver.get("https://www.google.com");
      
      driver.findElement(By.name("q")).sendKeys("youtube");

      // Submit the search query by pressing Enter
      driver.findElement(By.name("q")).submit();
   }
}
