package ChatGpt.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandling {
    public static void main(String[] args) {
        // Set the path to the EdgeDriver executable
    	 System.setProperty("webdriver.edge.driver", "C:\\Users\\Ashfaq PC\\Downloads\\msdriver\\msedgedriver.exe");
        // Launch the Edge browser
        WebDriver driver = new EdgeDriver();

        // Navigate to the main window
        driver.get("https://www.example.com");

        // Open a new window
        driver.findElement(By.linkText("New Window")).click();

        // Switch to the new window
        String newWindowHandle = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(newWindowHandle);

        // Navigate to a website in the new window
        driver.get("https://www.google.com");

        // Close the new window
        driver.close();

        // Switch back to the main window
        String mainWindowHandle = driver.getWindowHandles().toArray()[0].toString();
        driver.switchTo().window(mainWindowHandle);

        // Close the main window
        driver.quit();
    }
}
