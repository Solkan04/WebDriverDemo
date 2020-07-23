package brokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyIfLinksAreBroken 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//Initiate driver
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Maximize browser
		driver.manage().window().maximize();
		//Adding implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//launching browsers
		driver.get("http://demo.guru99.com/test/newtours/");
		Thread.sleep(5000);
		
		//capture all links
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		//Number of links in a webpage
		System.out.println("Number of Links: " +links.size());
		
		for(int i=0; i<links.size();i++)
		{
			//By using href attribute we can get URL of required link
			WebElement ele=links.get(i);
			String url=ele.getAttribute("href");
			URL link=new URL(url);
			
			//create a connection using url object 'link'
			HttpURLConnection httpCon=(HttpURLConnection) link.openConnection();
			Thread.sleep(2000);
			//Establish connection
			httpCon.connect();
			
			int rescode=httpCon.getResponseCode();//return response if res code is above 400:broken link
			if(rescode>=400)
				System.out.println(url + " - " + " is broken link");
			else
				System.out.println(url + " - " + " is valid link");
		}
		driver.close();
	}
}
