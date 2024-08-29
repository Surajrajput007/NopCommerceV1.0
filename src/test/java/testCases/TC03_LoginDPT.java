package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.P01_HomePage;
import pageObjects.P03_Loginpage;
import pageObjects.P04_Myaccount;
import testBase.BaseClass;
import utilities.D01_LoginData;

/* Data is Valid --> Login Success --> Logout
 * Data is valid --> Login Fail --> Test fail
 * 
 * Data is invalid --> Login Success --> Test Fail --> Logout
 * Data is invalid -->login Fail --> Test Pass
 */
public class TC03_LoginDPT extends BaseClass  {
	
	@Test(dataProvider= "LoginData",dataProviderClass=D01_LoginData.class,groups="DataDriven")
	
	public void Login_DAtadrivenTest(String email,String pass, String expres) {
	
		logger.info("Test Starting using ddt");
	
	try {
	P01_HomePage hp = new P01_HomePage(driver);
	hp.ClickMyaccount();
	logger.info("clicking on login");
	hp.ClickonLogin();
	
	logger.info("creating object of loginPage");
	P03_Loginpage lp = new P03_Loginpage(driver);
	lp.SetEmailaddress(email);
	lp.setpassword(pass);
	lp.Clicklogin();

	logger.info("Creating Object for MyAccount");
	P04_Myaccount ma = new P04_Myaccount(driver);
	boolean status = ma.ismyaccountexits();
	
	logger.info("using valid data so login success ");
	if(expres.equalsIgnoreCase("valid")) {
		if(status==true) {
		ma.ClickonLogout();
		Assert.assertTrue(true);
			}
		else {
			Assert.assertTrue(false);
		}
	}

	if(expres.equalsIgnoreCase("Invalid")) {
		if(status==true) {
			ma.ClickonLogout();
			Assert.assertTrue(false);
				}
		else {
			Assert.assertTrue(true);
		}
	}
	}catch(Exception e) {
		Assert.fail();
	}
	   }
}