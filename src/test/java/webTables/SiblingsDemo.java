package webTables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SiblingsDemo 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		setUp();
		followingSibling();
		following();
		precedingSibling();
		preceding();
		tableHeaders_Descendant_Child();
		ancester_Parent();
		driver.close();
	}
	public static void setUp()
	{
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///D:/Mahesh/WorkSpaces/VMD1/WebDriverDemo/Library/WebTableHTML.html");
	}
	
	//Enter Salary for Rahul Dravid
	public static void followingSibling() throws InterruptedException
	{
		WebElement ele=driver.findElement(By.xpath("//table/tbody/tr/td[text()='Rahul Dravid']/following-sibling::td/input"));
		ele.sendKeys("40000");
		Thread.sleep(3000);
	}
	
	//Enter the salary for the youngest sibling of Narendra Modi
	public static void following() throws InterruptedException
	{
		WebElement ele=driver.findElement(By.xpath("//tbody/tr/td[text()='Narendra Modi']/following::tr/td[text()='Sushma Swaraj']/following-sibling::td/input"));
		ele.sendKeys("1000000");
		Thread.sleep(3000);
	}
	
	//Check the checkbox[satus] for sachin tendulkar
	public static void precedingSibling() throws InterruptedException
	{
		WebElement ele=driver.findElement(By.xpath("//tbody/tr/td[text()='Sachin Tendulkar']/preceding-sibling::td/input"));
		ele.click();
		Thread.sleep(3000);
	}
	
	//Select the city for eldest sibling of Rahul Dravid
	public static void preceding() throws InterruptedException
	{
		WebElement ele=driver.findElement(By.xpath("//tbody/tr/td[text()='Rahul Dravid']/preceding::tr/td[text()='Narendra Modi']/following-sibling::td/select"));
		Select sel=new Select(ele);
		sel.selectByVisibleText("Gujarath");
		Thread.sleep(3000);
	}
	
	//Get the text of all the table headers
	public static void tableHeaders_Descendant_Child() throws InterruptedException
	{
		List<WebElement> list=driver.findElements(By.xpath("//form/descendant::tr/child::th"));
		for(int i=0;i<list.size();i++)
		{
			String headers=list.get(i).getText();
			System.out.println("Header Text of " +i+ " Header is: " +headers);
		}
		Thread.sleep(2000);
	}
	
	//check the status of the eldest sibling of Indian Politician
	public static void ancester_Parent() throws InterruptedException
	{
		WebElement ele=driver.findElement(By.xpath("//tbody/tr/td[text()='Indian Politician']/ancestor::tr/parent::tbody/tr/td[text()='Narendra Modi']/preceding-sibling::td/input"));
		ele.click();
		Thread.sleep(3000);
	}
}
