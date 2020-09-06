package webTables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderCRM_NavAuto 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		setUp();
		logIn();
		driver.close();
	}
	public static void setUp()
	{
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver_85.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ui.cogmento.com/");
	}
	public static void logIn() throws InterruptedException
	{
		driver.findElement(By.name("email")).sendKeys("maheshsc04@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Dummy01*");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		Thread.sleep(5000);
	}
	
	public static void calenderDemo() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@id='main-nav']/a/descendant::span[text()='Calendar']")).click();
		Thread.sleep(3000);
	}
}
