package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement FirstName;
	@FindBy(xpath = "//input[@id='input-lastname']")  
	WebElement LastName;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement PhoneNO;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement passs;
	@FindBy(xpath = "(//input[@id='input-confirm'])[1]")
	WebElement  confmpasss;
	
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement Subscribe;
	@FindBy(xpath = "//input[@name='agree']")  
	WebElement agree;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continuee;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	
	WebElement msgconformation;

	public void firstname(String fname) {
		FirstName.sendKeys(fname);
	}

	public void lastname(String lname) {
		LastName.sendKeys(lname);
	}

	public void Email(String emaill) {
		email.sendKeys(emaill);
	}
	
	public void phn(String no) {
		PhoneNO.sendKeys(no);
	}

	public void passw(String pass) {
		passs.sendKeys(pass);
	}
	
	public void conpassw(String conpass) {
		 confmpasss.sendKeys(conpass);
	}


	public void subs() {
		Subscribe.click();
	}
	
	
	public void agr() {
		agree.click();
	}

	public void cont() {
		continuee.click();
	}

	public String getmas() // we can not validate the page object class
	{
		try {
			return (msgconformation.getText());

		} catch (Exception e) { // some time the capture msg it throw exception
			return (e.getMessage());
		}
	}

}
