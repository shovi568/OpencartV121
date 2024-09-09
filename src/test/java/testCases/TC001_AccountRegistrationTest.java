package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regration","Master"})
	public void verify_account_registration() {
		
		try {
		logger.info("*******Starting Test case*********");
		
		HomePage hp = new HomePage(driver);
		hp.clickmyAccount();
		hp.clickregister();
		logger.info("*******Click on resister link*********");
		
		
		AccountRegistrationPage ar = new AccountRegistrationPage(driver);
		
		logger.info("*******providing customer data*********");

		ar.firstname(randomeString().toUpperCase());
		ar.lastname(randomeString().toUpperCase());
		ar.Email(randomeString() + "@gmail.com");

		ar.phn(randomno());

		String password = randomaphanum();
		ar.passw(password);
		ar.conpassw(password);
		ar.agr();
		ar.subs();
		ar.cont();
		logger.info("*******validating  expected msg*********");
		String confor = ar.getmas();
		if(confor.equals("Your Account Has Been Created!"))
		{
				Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*****************Finish TC001_AccountRegistrationTest **********");

	}
	

}
