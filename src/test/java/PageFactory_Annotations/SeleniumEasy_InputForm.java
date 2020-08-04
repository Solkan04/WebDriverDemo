package PageFactory_Annotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumEasy_InputForm 
{
	public static WebDriver driver;
	public static ObjectRepo1 or;
	@Test(priority=1)
	public static void demo()
	{
		
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		or=new ObjectRepo1(driver);
	}
	@Test(priority=2)
	public void findBys_And_findAll_findBy_Demo() throws InterruptedException 
	{
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		or.eithercriterion.sendKeys("10");//findAll
		or.bothcriteria.sendKeys("20");//findBys
		or.getTotal().click();//findBy
		Thread.sleep(5000);
		driver.quit();
	}
}
