package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement mail;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pwd;
	@FindBy(xpath="//input[@value='Login']")
	WebElement login_button;
	
	public void enter_email(String email) {
		mail.sendKeys(email);
		
	}
	public void enter_password(String password) {
		pwd.sendKeys(password);
	}
	
	public void login() {
		login_button.click();
	}

}
