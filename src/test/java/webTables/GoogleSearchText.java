package webTables;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchText 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		setUp();
		searchGoogle();
		driver.quit();
	}
	public static void setUp()
	{
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver_85.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com/");
	}
	
	public static void searchGoogle() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("java");
		List<WebElement> ele=driver.findElements(By.xpath("//div/ul[@role='listbox']/li/descendant::div[@role='option']/div[@class='sbl1']"));
		System.out.println("Total No of Suggestions:" +ele.size());
		for(int i=0; i<ele.size();i++)
		{
			System.out.println(ele.get(i).getText());
			if(ele.get(i).getText().contains("java tutorial"))
				ele.get(i).click();
			Thread.sleep(10000);
			break;
		}

	}
}
