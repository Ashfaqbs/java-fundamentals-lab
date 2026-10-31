/**
 * Code developed by Ashfaq (© [Year])
 * GitHub: https://github.com/DarkSharkAsh
 */



package Java_NET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class GitHubPageOpenerSel {
    public static void main(String[] args) {
        // Set the path to your Chrome WebDriver executable
    	System.setProperty("webdriver.edge.driver", "C:\\Users\\Ashfaq PC\\Downloads\\msdriver\\msedgedriver.exe");
		WebDriver driver =new EdgeDriver();

		driver.get("https://hub.docker.com/login");
		
		
		driver.quit();
    }
}
