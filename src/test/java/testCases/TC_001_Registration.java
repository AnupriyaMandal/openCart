package testCases;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.SignUpPage;
import testBase.BaseClass;

public class TC_001_Registration extends BaseClass{
	
	public HomePage hp;
	public SignUpPage sp;
	
	
	@Test(groups={"Regression","Master"})
	public void verifyRegistration() throws InterruptedException {
		try {
		logger.info("****Starting testcase****");
		
		
		hp=new HomePage(driver);
		hp.MyAccount();
		logger.info("****Clicked on My Home page****");
		hp.Register();
		sp=new SignUpPage(driver);
		logger.info("****Providing details****");
		sp.setfirstName(randomeString());
		sp.setlastName(randomeString());
		sp.setEmail(randomEmail());
		sp.setPasswrod(randomAlphanumeric());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		sp.agree();
		sp.continue_Btn();
		logger.info("****Doing validation****");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(sp.getConfirmation(),"Your Account Has Been Created!");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		logger.info("****Test Case execution completed****");
		System.out.println("Account creation successfull");
		}
		catch(Exception e) {
			logger.error("Test Failed...");
			Assert.fail();
		}
	}
	

	


	

}
