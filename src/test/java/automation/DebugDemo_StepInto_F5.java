package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DebugDemo_StepInto_F5 
{
	public static void main(String[] args)
	{
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver_85.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://learn-automation.com/");
		//driver.get("http://opensource.demo.orangehrmlive.com/");
		Helper.typeIntoInputBox(driver, "txtUsername", "admin");
		driver.quit();
	}
}
