package alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsDemo_RediffMail 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		setUp();
		verify_UserName_Password_AlertTexts(); 
	}
	public static void setUp()
	{
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		// Maximize browser
		driver.manage().window().maximize();
		// Adding implicit wait
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}
	public static void verify_UserName_Password_AlertTexts() throws InterruptedException 
	{
		//Verifies the username alert text
		WebElement signin=driver.findElement(By.name("proceed"));
		signin.click();
		Alert alert1=driver.switchTo().alert();
		String untext=alert1.getText();
		if(untext.equals("Please enter a valid user name"))
			System.out.println("Valid User Name Alert Text is Displayed");
		else
			System.out.println("Invalid User Name Alert Text is Displayed");
		alert1.accept();
		Thread.sleep(3000);
		
		//verifies the password alert text
		driver.findElement(By.id("login1")).sendKeys("Mahesh");
		signin.click();
		Alert alert2=driver.switchTo().alert();
		String pwdtext=alert2.getText();
		if(pwdtext.equals("Please enter your password"))
			System.out.println("Valid Password Alert Text is Displayed");
		else
			System.out.println("Invalid Password Alert Text is Displayed");
		alert1.accept();
		Thread.sleep(3000);
		
		driver.quit();
	}
}
