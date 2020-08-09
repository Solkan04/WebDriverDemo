package alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptAlertsDemo 
{
	public static WebDriver driver;
	public static String promptxt="This Is Demo Text";
	@Test(priority=1)
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
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
	}
	@Test(priority=2)
	public static void javaScript_AlertBox() throws InterruptedException
	{
		driver.findElement(By.xpath("//p[text()='Click the button to display an alert box:']/following-sibling::button[text()='Click me!']")).click();
		Alert alert1=driver.switchTo().alert();
		String alerttext1=alert1.getText();
		if(alerttext1.equals("I am an alert box!"))
			System.out.println("Valid Alert1 Text is Displayed");
		else
			System.out.println("Invalid Alert1 Text is Displayed");
		alert1.accept();
		Thread.sleep(3000);
	}
	@Test(priority=3)
	public static void javaScript_ConfirmBox() throws InterruptedException
	{
		WebElement alt=driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
		alt.click();
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		WebElement ele1=driver.findElement(By.xpath("//p[text()='You pressed OK!']"));
		String alerttext1=ele1.getText();
		if(alerttext1.equals("You pressed OK!"))
			System.out.println("Pressed on OK Button");
		else
			System.out.println("Ok Button Not Pressed");
		Thread.sleep(3000);
		
		alt.click();
		Alert alert2=driver.switchTo().alert();
		alert2.dismiss();
		WebElement ele2=driver.findElement(By.xpath("//p[text()='You pressed Cancel!']"));
		String alerttext2=ele2.getText();
		if(alerttext2.equals("You pressed Cancel!"))
			System.out.println("Pressed on Cancel Button");
		else
			System.out.println("Cancel Button Not Pressed");
		Thread.sleep(3000);
	}
	@Test(priority=4)
	public static void javaScript_PromptBox() throws InterruptedException
	{
		WebElement alt=driver.findElement(By.xpath("//button[text()='Click for Prompt Box']"));
		alt.click();
		Alert alert1=driver.switchTo().alert();
		alert1.sendKeys(promptxt);
		alert1.accept();
		WebElement ele1=driver.findElement(By.xpath("//p[contains(text(),'"+promptxt+"')]"));
		String alerttext1=ele1.getText();
		if(alerttext1.contains(promptxt))
			System.out.println("Entered Text is Displayed Correctly");
		else
			System.out.println("Entered Text is Displayed Incorrectly");		
		Thread.sleep(3000);
		driver.quit();
	}
}
