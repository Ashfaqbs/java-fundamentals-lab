package ChatGpt.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class youtube {
	 public static void main(String[] args) throws InterruptedException {
	      System.setProperty("webdriver.edge.driver", "C:\\Users\\Ashfaq PC\\Downloads\\msdriver\\msedgedriver.exe");
	      WebDriver driver =new EdgeDriver();
	      driver.get("https://www.youtube.com");
	      driver.findElement(By.name("search_query")).sendKeys("CodeWithHarry");
	      Thread.sleep(5000);
	      driver.findElement(By.id("search-icon-legacy")).click();

	      Thread.sleep(5000);
	   // Open the first video in the search results
	      driver.findElement(By.cssSelector("a#video-title")).click();

	      Thread.sleep(5000);
	      // Click on the "Python Crash Course in Hindi" video
	      driver.findElement(By.xpath("(//a[contains(.,'Python Crash Course in Hindi')])[2]")).click();
	      
	      
	      Thread.sleep(5000);
	      driver.quit();
	 
	 }
}
