package webTables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableCRM_NavAuto 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		setUp();
		logIn();
		method1();
		method2();
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
	
	//Not recommended
	public static void method1() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@href='/contacts']/span[text()='Contacts']")).click();
		Thread.sleep(3000);
		String before="//tbody/tr[";
		String after="]/td[2]";		
		for(int i=1;i<=4;i++)
		{
			String name=driver.findElement(By.xpath(before+i+after)).getText();
			//String name=driver.findElement(By.xpath("//div[@class='ui fluid container main-content']/table/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(name);
			if(name.contains("Yashwanth Kumar"))
			{
				driver.findElement(By.xpath("//div[@class='ui fluid container main-content']/table/tbody/tr["+i+"]/td[1]/div")).click();
			}
		}
	}

	public static void method2() throws InterruptedException
	{
		driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'Yashwanth Kumar')]/preceding-sibling::td/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'Naveen SC')]/preceding-sibling::td/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'Mahesh SC')]/preceding-sibling::td/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'First1 Last1')]/preceding-sibling::td/div")).click();
	}
}
