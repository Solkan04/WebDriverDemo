package automation;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMaxPriceFromDynamicWebTable 
{
	public static WebDriver driver;
	public static void main(String[] args) throws ParseException 
	{
		setUp();
		getPrice();
		//getAllGroupsPrice();//needs work
		driver.quit();
	}
	public static void setUp()
	{
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
	}
	//div[contains(@style,'both')]/a
	public static void getPrice() throws ParseException
	{
		String row="//*[@id='leftcontainer']/table/tbody/tr";//will get the number of rows
		int rowData=driver.findElements(By.xpath(row)).size();
		System.out.println("No of Rows :"  +rowData);
		List<WebElement> currentprice=driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[4]"));
		
		//*[@id='leftcontainer']/table/tbody/tr[2]/td[4]
		//table row data keeps changing hence dynamic xpath is applied --*[@id='leftcontainer']/table/tbody/tr["+i+"]/td[4]
		String firstpart="//*[@id='leftcontainer']/table/tbody/tr[";
		String secondpart="]/td[4]";
		
		ArrayList<Integer> array=new ArrayList<Integer>();
		for(int i=1;i<rowData;i++)
		{
			String finalpart=firstpart+i+secondpart;
			//System.out.println(finalpart);
			//System.out.println("=======================================================================");
			String price=driver.findElement(By.xpath(finalpart)).getText();
			//convert String type(price) into double type
			/*If we use these two below statements, it'll throw number format exception as some number are separated bu comas[3,173.60] 
			 * Double dprice=Double.parseDouble(price);
			int intprice=dprice.intValue();*/
			
			NumberFormat nf=NumberFormat.getNumberInstance();
			Number num=nf.parse(price);//ragradless of the number format. it'll parse to the number
			price=num.toString();//from number we're converting to string
			//System.out.println("Before Doubling:" +price);
			Double dprice=Double.parseDouble(price);//parsing to type double as some numbers uses decimal points
			//System.out.println("After Doubling:" +price);
			int intprice=dprice.intValue();
			array.add(intprice);
		}
		Collections.sort(array);
		System.out.println("All the Prices in : " +array);
		System.out.println("=======================================================================");
		System.out.println("Lowest/Minimun Price: " +array.get(0));
		System.out.println("=======================================================================");
		System.out.println("Highest/Maximum Price: " +array.get(array.size()-1));
		System.out.println("=======================================================================");
		System.out.println("Second Lowest/Minimum Price: " +array.get(1));
		System.out.println("=======================================================================");
		System.out.println("Second Highest/Maximum Price: " +array.get(array.size()-2));
	}
	public static void getAllGroupsPrice() throws ParseException
	{
		List<WebElement> grps=driver.findElements(By.xpath("//div[contains(@style,'both')]/a"));
		System.out.println("No of Groups: " +grps.size());
		for(int j=0;j<=grps.size();j++)
		{
			WebElement ele=grps.get(j);
			ele.click();
			String row="//*[@id='leftcontainer']/table/tbody/tr";//will get the number of rows
			int rowData=driver.findElements(By.xpath(row)).size();
			System.out.println("No of Rows in Group "+j+" is :"  +rowData);
			String firstpart="//*[@id='leftcontainer']/table/tbody/tr[";
			String secondpart="]/td[4]";
			ArrayList<Integer> array=new ArrayList<Integer>();
			for(int i=1;i<rowData;i++)
			{
				String finalpart=firstpart+i+secondpart;
				String price=driver.findElement(By.xpath(finalpart)).getText();
				NumberFormat nf=NumberFormat.getNumberInstance();
				Number num=nf.parse(price);//ragradless of the number format. it'll parse to the number
				price=num.toString();//from number we're converting to string
				Double dprice=Double.parseDouble(price);//parsing to type double as some numbers uses decimal points
				int intprice=dprice.intValue();
				array.add(intprice);
			}
			Collections.sort(array);
			System.out.println("All the Prices in "+j+" : " +array);
			System.out.println("=======================================================================");
			System.out.println("Lowest/Minimun Price in "+j+" : " +array.get(0));
			System.out.println("=======================================================================");
			System.out.println("Highest/Maximum Price in "+j+" : " +array.get(array.size()-1));
			System.out.println("=======================================================================");
			System.out.println("Second Lowest/Minimum Price in "+j+" : " +array.get(1));
			System.out.println("=======================================================================");
			System.out.println("Second Highest/Maximum Price in "+j+" : " +array.get(array.size()-2));
			System.out.println("=================================NEXT ITERATION=================================");
		}
	}
}
