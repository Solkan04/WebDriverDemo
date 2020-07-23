package authenticationPopUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AuthenticationDemo 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Initiate driver
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Maximize browser
		driver.manage().window().maximize();
		// Adding implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// launching browsers
		//driver.get("https://the-internet.herokuapp.com/basic_auth");
		//http://username:password@test.com
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		Thread.sleep(5000);
		
		String text=driver.findElement(By.cssSelector("p")).getText();
		System.out.println(text);
		Assert.assertEquals("Congratulations! You must have the proper credentials.",text,"Login Un-Successfull");
		driver.close();
	}
}
