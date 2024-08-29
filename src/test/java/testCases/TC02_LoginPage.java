package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.P01_HomePage;
import pageObjects.P03_Loginpage;
import pageObjects.P04_Myaccount;
import testBase.BaseClass;

public class TC02_LoginPage extends BaseClass {

	
	
	@Test(groups={"Sanity","Master"})
	public void logintest() {
		try {
		logger.info("Test Starting");
		P01_HomePage hp = new P01_HomePage(driver);
		hp.ClickMyaccount();
		logger.info("clicking on login");
		hp.ClickonLogin();
		
		logger.info("creating object of loginPage");
		P03_Loginpage lp = new P03_Loginpage(driver);
		lp.SetEmailaddress(p.getProperty("Usernamme"));
		lp.setpassword(p.getProperty("password"));
		lp.Clicklogin();
		P04_Myaccount ma = new P04_Myaccount(driver);
		boolean status = ma.ismyaccountexits();
		Assert.assertTrue(status);
		}catch(Exception e) {
			Assert.fail();
		}
	}
	
	
}
