package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends  BasePage
{
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement msgmyacc;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logout;
	
	
	
	
	public void Clicklogout()
	{
		logout.click();
	}
	
	public boolean isMyaccountpageExists()
	{
		try
		{
			return(msgmyacc.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
