package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignUpPage extends BasePage{
	
	WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") 
	WebElement fname;
	@FindBy(xpath="//input[@id='input-lastname']") 
	WebElement lname;
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement email;
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement pwd;
	@FindBy(xpath="//input[@type='checkbox' and @name='agree']")
	WebElement agreeBtn;
	
	@FindBy(xpath="//button[normalize-space()='Continue']") 
	WebElement continue_Btn;
	@FindBy(tagName="h1") 
	WebElement cnf_msg;
	
	public void setfirstName(String firstName) {
		fname.sendKeys(firstName);
	}
	public void setlastName(String lastName) {
		lname.sendKeys(lastName);
	}
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void setPasswrod(String password) {
		pwd.sendKeys(password);
		
	}
	
	public void agree() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));     
        WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(agreeBtn));
        agreeButton.click();}
		catch(Exception e) {
			System.out.println("Error while clicking is"+e.getMessage());
		}
	}
	public void continue_Btn() {
		continue_Btn.click();
	}
	public String getConfirmation() {
		return cnf_msg.getText();
	}
}
