package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(tagName="h1")
	WebElement login_confirmation;
	
	@FindBy(xpath="(//a[normalize-space()='Logout'])[1]")
	WebElement log_out;
	
	public boolean isMyAccountPageExist() {
		
		try {
		return (login_confirmation.isDisplayed());}
		catch(Exception e) {
			return false;
		}
	}
	public void logout() {
		log_out.click();
	}
}
