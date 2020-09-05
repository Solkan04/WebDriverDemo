package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DebugDemo_StepOver_F6
{
	WebDriver driver=null;
	@Test
	public void test1()
	{
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver_85.exe");
		driver=new ChromeDriver();//WebDriver driver=new ChromeDriver();
		driver.get("http://learn-automation.com/");
		String title=driver.getTitle();
		boolean value=title.contains("Selenium");
		System.out.println("Status Value Is:" +value);
	}
	@Test
	public void test2()
	{
		driver.quit();
	}
}
