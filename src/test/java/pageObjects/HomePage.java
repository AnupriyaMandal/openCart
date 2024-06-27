package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement myAccount_Btn;
	@FindBy(xpath="(//a[normalize-space()='Register'])[1]") 
	WebElement register_Btn;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement login_clk;
	
	public void MyAccount() {
		myAccount_Btn.click(); 
	}
	public void Register() {
		register_Btn.click();
	}
	public void login() {
		login_clk.click();
	}

}
