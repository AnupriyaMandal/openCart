package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	public HomePage hp;
	public LoginPage verLogin;
	public MyAccountPage myp;
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")
	public void VeifyDDT(String email, String pwd, String exp) {
		try{
		logger.info("*****Starting TC_003********");
		hp=new HomePage(driver);
		hp.MyAccount();
		hp.login();
		verLogin=new LoginPage(driver);
		verLogin.enter_email(email);
		verLogin.enter_password(pwd);
		verLogin.login();
	myp=new MyAccountPage(driver);	
	boolean targetPage=myp.isMyAccountPageExist();
	
	if(exp.equals("Valid")) {
		if(targetPage==true) {
			hp.MyAccount();
			myp.logout();
			Assert.assertTrue(true);
			
		}
		else {
			Assert.assertTrue(false);
		}
		
	}
	if(exp.equals("Invalid")) {
		if(targetPage==true) {
			hp.MyAccount();
			myp.logout();
			Assert.assertTrue(false);
			
		}
		else {
			Assert.assertTrue(true);
			
		}
		
	}
	
}

	catch(Exception e) {
			Assert.fail();
		}
		logger.info("*****Finished TC_003********");
	}
}
		

