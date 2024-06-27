package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	
	public HomePage hp;
	public MyAccountPage myp;
	public LoginPage verLogin;
	
	@Test(groups={"Sanity","Master"})
	public void verify_Login() {
		
		try{
		logger.info("*****Starting TC_002*****");
		hp=new HomePage(driver);
		hp.MyAccount();
		hp.login();
		verLogin=new LoginPage(driver);
		verLogin.enter_email(p.getProperty("email"));
		verLogin.enter_password(p.getProperty("password"));
		verLogin.login();
	myp=new MyAccountPage(driver);	
	boolean targetPage=myp.isMyAccountPageExist();
	Assert.assertEquals(targetPage, true);
	hp.MyAccount();
	myp.logout();

	
	logger.info("*****Completed TC_002******");}
		catch(Exception e) {
			Assert.fail();
			logger.info("*****Test Case Failed****");
		}
		
	}
}
