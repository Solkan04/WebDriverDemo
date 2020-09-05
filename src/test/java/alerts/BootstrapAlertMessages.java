package alerts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class BootstrapAlertMessages 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		setUp();
	//	autoCloseAble();
	//	System.out.println("_______________________________________________________________________");
	//	normalCloseAble();
	//	System.out.println("_______________________________________________________________________");
	//	auto_Normal_CloseAble();
	//	System.out.println("_______________________________________________________________________");
		//verify_Color();
		//getColorNameFromRgb(int r, int g, int b);
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
		driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
	}
	public static void autoCloseAble() throws InterruptedException
	{
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='col-md-4']//button[contains(text(),'Autocloseable')]"));
		for(int i=0;i<list.size();i++)
		{
			WebElement ele=list.get(i);
			ele.click();
			List<WebElement> msgs=driver.findElements(By.xpath("//div[@class='col-md-6']/div[contains(text(),'autocloseable')]"));
			for(int j=i;j<=i;j++)
			{
				WebElement ele1=msgs.get(j);
				String txts=ele1.getText();
				System.out.println("Auto Closeable Messages: " +txts);
			}
		}
	}
	
	public static void normalCloseAble() throws InterruptedException
	{
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='col-md-4']//button[contains(text(),'Normal')]"));
		for(int i=0;i<list.size();i++)
		{
			WebElement ele=list.get(i);
			ele.click();
			List<WebElement> msgs=driver.findElements(By.xpath("//div[@class='col-md-6']/div[contains(@class,'normal')]"));
			for(int j=i;j<=i;j++)
			{
				WebElement ele1=msgs.get(j);
				String txts=ele1.getText();
				System.out.println("Normal Closeable Messages: " +txts);
				List<WebElement> close=driver.findElements(By.xpath("//div/button[contains(@class,'close')]"));
				for(int k=j;k<=j;k++)
				{
					WebElement ele2=close.get(k);
					ele2.click();
				}
			}
		}
	}
	public static void auto_Normal_CloseAble() throws InterruptedException
	{
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='col-md-4']//button[contains(text(),'message')]"));
		for(int i=0;i<list.size();i++)
		{
			WebElement ele=list.get(i);
			ele.click();
			List<WebElement> msgs=driver.findElements(By.xpath("//div[@class='col-md-6']/div[contains(@class,'alert')]"));
			for(int j=i;j<=i;j++)
			{
				WebElement ele1=msgs.get(j);
				String txts=ele1.getText();
				System.out.println("Auto & Normal Closeable Messages: " +txts);
				List<WebElement> close=driver.findElements(By.xpath("//div/button[contains(@class,'close')]"));
				for(int k=0;k<close.size();k++)
				{
					WebElement ele2=close.get(k);
					if(ele2.isDisplayed())
						ele2.click();
				}
			}
		}
	}
/*	
	public static void verify_Color() throws InterruptedException
	{
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='col-md-4']//button[contains(text(),'message')]"));
		for(int i=0;i<list.size();i++)
		{
			WebElement ele=list.get(i);
			String color=ele.getCssValue("background-color");
			System.out.println(color);
			String hex=Color.fromString(color).asHex();
			System.out.println(hex);
			String hexval[]=color.replace("rgba(", "").replace(")", "").split(",");
			System.out.println(hexval);
			
			hexval[0]=hexval[0].trim();
			int hexval1=Integer.parseInt(hexval[0]);
			
			hexval[1]=hexval[1].trim();
			int hexval2=Integer.parseInt(hexval[1]);

			hexval[2]=hexval[2].trim();
			int hexval3=Integer.parseInt(hexval[2]);
			
			String actclr=String.format("#%02x%02x%02x", hexval1, hexval2, hexval3);
			//here %02x will convert the provided arguments in a 2-digit value of base-16
			
			System.out.println(actclr);
			Assert.assertTrue(actclr.equals("#0045d0"), "Test Case Fail as the color is not same");

		}
		public String getColorNameFromHex(int hexColor) 
		{
		        int r = (hexColor & 0xFF0000) >> 16;
		        int g = (hexColor & 0xFF00) >> 8;
		        int b = (hexColor & 0xFF);
		        return getColorNameFromRgb(r, g, b);
		}
		public int colorToHex(Color c) {
	        return Integer.decode("0x"
	                + Integer.toHexString(c.getRGB()).substring(2));
	    }

	    public String getColorNameFromColor(Color color) {
	        return getColorNameFromRgb(color.getRed(), color.getGreen(),
	                color.getBlue());
	    }
	}

	
	public static Object getColorNameFromRgb(int r, int g, int b) 
	{
		// TODO Auto-generated method stub
		
	}
*/}
