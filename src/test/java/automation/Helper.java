package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Helper 
{
	public static void typeIntoInputBox(WebDriver driver, String id, String text)
	{
		System.out.println("Trying to enter for the element whose id is :" +id);
		driver.findElement(By.xpath(id)).sendKeys(text);//Exception is thrown here
		System.out.println("Text elementedfor the element which has id " +id);
	}
}
