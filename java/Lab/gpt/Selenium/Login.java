package ChatGpt.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Login {
	public static void main(String[] args) throws InterruptedException {




		System.setProperty("webdriver.edge.driver", "C:\\Users\\Ashfaq PC\\Downloads\\msdriver\\msedgedriver.exe");
		WebDriver driver =new EdgeDriver();

		driver.get("https://hub.docker.com/login");

		// Find the email and password input fields, and populate them with your credentials
		Thread.sleep(5000);
		WebElement emailInput = driver.findElement(By.id("username"));
		emailInput.sendKeys("ash001x@gmail.com");

		//	   /html/body/div[2]/main/section/div/div/div/form/div[2]/button
		WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/main/section/div/div/div/form/div[2]/button"));
		loginButton.click();

		Thread.sleep(5000);

		WebElement passwordInput = driver.findElement(By.xpath(" /html/body/div[2]/main/section/div/div/div/form/div[1]/div/div[2]/div/input"));
		passwordInput.sendKeys("Ashfaq@786");
		Thread.sleep(5000);

		WebElement continueD =driver.findElement(By.xpath("/html/body/div[2]/main/section/div/div/div/form/div[2]/button")) ;
		continueD.click();
		Thread.sleep(5000);
		driver.quit();

		// Find and click the login button
		//	   WebElement loginButton = driver.findElement(By.cssSelector("button.btn-primary"));
		//	   loginButton.click();
		//	
		//	      /html/body/div[2]/main/section/div/div/div/form/div[1]/div/div[2]/div/input
	}
}
