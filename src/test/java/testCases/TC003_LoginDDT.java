package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{
	
@Test(dataProvider ="LoginData",dataProviderClass =DataProviders.class)
 public void verify_loginDDT(String email,String pwd,String exp)
 {
	 //Home Page
	 //Home Page    
	 HomePage hp = new HomePage(driver);
	 hp.clickmyAccount();
	 hp.ClickLogin();

	
	 //Login Page
	 LoginPage lp=new LoginPage(driver);
	 lp.clickemail("email");
	 lp.clickpass("pwd");
	 lp.clicklog();

	 //myAccount
	 MyAccountPage mac=new MyAccountPage(driver);
	 mac.Clicklogout();
	 boolean  trgpage=mac. isMyaccountpageExists();
	 
	 /* Data is valid - login success - test pass -logout
	                    login failed - test -failed
	                    
	     Data is invalid - login success - test failed -logout
	                    login failed - test -pass
	                                   
	  */
	 
	 
	 
	 
		if (exp.equalsIgnoreCase("Valid")) {
			if (trgpage == true) {
				Assert.assertTrue(true);
				mac.Clicklogout();
			} else {
				Assert.assertTrue(false);
			}

			if (exp.equalsIgnoreCase("inValid")) {

				if (trgpage == true) {
					
					mac.Clicklogout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
		 
	 }
	 
	 
	 
 }
}
