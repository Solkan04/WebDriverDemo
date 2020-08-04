package PageFactory_Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ObjectRepo1 
{
	public ObjectRepo1(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBys
	(
			{
				@FindBy(how = How.CLASS_NAME, using = "form-group"),
				@FindBy(how = How.ID, using = "sum2")
			}
	)
	public  WebElement bothcriteria;

	@FindAll
	(
			{
				@FindBy(how = How.NAME, using = "Enter value"),//doesn't match
				@FindBy(how = How.CLASS_NAME, using = "form-control1"),//doesn't match
				@FindBy(how = How.ID, using = "sum1")//matches
			}
	)
	public WebElement eithercriterion;
	
	@FindBy(xpath="//button[@onclick='return total()']")
	WebElement gettotal;
	public WebElement getTotal()
	{
		return gettotal;
	}

	/*@FindAll
	(
			{
				@FindBy(how = How.XPATH, using = "//button[@onclick='return total()']"),// matches
				@FindBy(how = How.XPATH, using = "//button[contains(text(),'Get Total')]"),//matches
			}
	)
	public WebElement getTotal;*/
}
