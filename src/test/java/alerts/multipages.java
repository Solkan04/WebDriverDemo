package alerts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class multipages 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		setUp();
		pages2();		
	}
	public static void setUp() throws InterruptedException
	{
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		// Maximize browser
		driver.manage().window().maximize();
		// Adding implicit wait
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/");
		Thread.sleep(3000);
	}
	
	public static void pages() throws InterruptedException
	{
		List<WebElement> list=driver.findElements(By.xpath("//i[@class='glyphicon glyphicon-chevron-right']"));
		for(int i=0;i<list.size();i++)
		{
			list.get(i).click();
			Thread.sleep(3000);
			String thirdpage=driver.findElement(By.xpath("//h3[contains(text(),'Examples with Components')]")).getText();
			System.out.println(thirdpage);
			if(thirdpage.contains("ADVANCED EXAMPLES WITH COMPONENTS"))
				System.out.println("Navigated to Third Page");
			else
				System.out.println("Not Navigated to Third Page");
			Thread.sleep(3000);
		}
		driver.quit();
	}
	public static void pages1() throws InterruptedException
	{
		try
		{
			String thirdpage=driver.findElement(By.xpath("//h3[contains(text(),'Examples with Components')]")).getText();
			System.out.println(thirdpage);
			if(thirdpage.contains("ADVANCED EXAMPLES WITH COMPONENTS"))
				System.out.println("Navigated to Third Page");
			else
				System.out.println("Not Navigated to Third Page");
			Thread.sleep(3000);	
		}catch(Exception e)
		{
			System.out.println(e);
		}
		driver.findElement(By.xpath("//a[@id='btn_basic_example']")).click();
		Thread.sleep(3000);
		String firstpage=driver.findElement(By.xpath("//h3[contains(text(),'Examples to start with Selenium')]")).getText();
		if(firstpage.contains("BASIC EXAMPLES TO START WITH SELENIUM"))
			System.out.println("Navigated to First Page");
		else
			System.out.println("Not Navigated to First Page");
		driver.findElement(By.xpath("//a[@id='btn_inter_example']")).click();
		Thread.sleep(3000);
		String secondpage=driver.findElement(By.xpath("//h3[contains(text(),'Examples with most popular components')]")).getText();
		if(secondpage.contains("INTERMEDIATE EXAMPLES WITH MOST POPULAR COMPONENTS"))
			System.out.println("Navigated to Second Page");
		else
			System.out.println("Not Navigated to Second Page");
		driver.findElement(By.xpath("//a[@id='btn_advanced_example']")).click();
		Thread.sleep(3000);
	}
	public static void pages2() throws InterruptedException
	{
		
		try
		{
		/*	WebDriverWait wait =new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Examples with Components')]")));*/
			WebElement web=driver.findElement(By.xpath("//h3[contains(text(),'Examples with Components')]"));
			if(web.isDisplayed())
				System.out.println("Element is Present");
			else
				System.out.println("Element is not present");
			Thread.sleep(3000);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		driver.findElement(By.xpath("//a[@id='btn_basic_example']")).click();
		driver.findElement(By.xpath("//a[@id='btn_inter_example']")).click();
		driver.findElement(By.xpath("//a[@id='btn_advanced_example']")).click();
		driver.quit();
	}
}
