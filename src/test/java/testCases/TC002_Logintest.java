package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_Logintest  extends BaseClass
{
	
@Test(groups= {"Sanity","Master"})	
public void verify_login()
{
	try {
logger.info("************ Start test cases TC002***********");
 //Home Page    
HomePage hp = new HomePage(driver);
hp.clickmyAccount();
hp.ClickLogin();

logger.info("************ Start loginPage***********");	
//Login Page
LoginPage lp=new LoginPage(driver);
lp.clickemail(p.getProperty("email"));
lp.clickpass(p.getProperty("pas"));
lp.clicklog();

//myAccount
MyAccountPage mac=new MyAccountPage(driver);
//mac.Clicklogout();
boolean  trgpage=mac. isMyaccountpageExists();

Assert.assertEquals(trgpage,true);
Thread.sleep(5000);
mac.Clicklogout();
	}
	catch(Exception e)
	{
		Assert.fail();
	}

	
	
	
logger.info("************  End TC002***********");	

	
}
	
}
