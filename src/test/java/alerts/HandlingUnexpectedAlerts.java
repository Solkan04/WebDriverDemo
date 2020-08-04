package alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingUnexpectedAlerts 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		setUp();
		handlingAlertsUsingWebDriverWaits();			
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
		driver.get("http://only-testing-blog.blogspot.com/2014/06/alert_6.html");
	}
	public static void handlingAlertsUsingWebDriverWaits() throws InterruptedException
	{
		try
		{
			//WebDriverWait wait=new WebDriverWait(driver,30);
			//wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
		}catch(Exception e)
		{
			System.out.println("Unexpected Alert Handled");
		}
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("fname");
		driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("lname");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}
