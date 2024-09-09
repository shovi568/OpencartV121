package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement InputEmail;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement InputPass;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement Loginlog;

	public void clickemail(String email) {
		InputEmail.sendKeys(email);
	}

	public void clickpass(String pass) {
		InputPass.sendKeys(pass);
	}

	public void clicklog() {
		Loginlog.click();
	}

}
