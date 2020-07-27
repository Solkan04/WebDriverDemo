package dropDowns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VerifyDropDownSortedOrNot 
{
	public static void main(String[] args) throws InterruptedException
	{
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");
				
		WebElement selweb=driver.findElement(By.id("animals"));
		//scrolling to the element
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", selweb);
		Thread.sleep(10000);

		//Getting all the options in dropdown
		Select sel=new Select(selweb);
		List<WebElement> options=sel.getOptions();
		
		//created two variables & storing all the dropdown values in it.
		List originalList=new ArrayList();
		List sortedTempList=new ArrayList();
		for(WebElement e:options)
		{
			originalList.add(e.getText());
			sortedTempList.add(e.getText());
		}
		System.out.println("Original List: " +originalList);
		System.out.println("Before Sorting Temp List: " +sortedTempList);
		
		//sorting onlt templist & not the originalList as we need to compare the two Lists
		Collections.sort(sortedTempList);
		System.out.println("After Sorting Temp List: " +sortedTempList);
		
		//comparing the two list variables
		if(originalList == sortedTempList)
			System.out.println("DropDown is Sorted");
		else
			System.out.println("DropDown is not Sorted");
		driver.close();
	}
}
