package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.P01_HomePage;
import pageObjects.P02_Reister;
import testBase.BaseClass;

public class TC01_Account_RegistrationTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void Account_registration() {
		logger.info("*********TC01_Account_RegistrationTest TEsting started*******");
		
		logger.info("Creating the homepage object");
		P01_HomePage hp = new P01_HomePage(driver);
	
		try{
		hp.ClickMyaccount();
		logger.info("clicked on Myaccont Link");
		hp.ClickRegister();
		logger.info("clicked on Registeration link");
        P02_Reister Reg = new P02_Reister(driver);
		logger.info("providing registration details");
		Reg.SetFirstname(RandomString().toUpperCase());
		Reg.Setlastname(RandomString().toUpperCase());
		Reg.SetEmail(RandomString() + "@gmail.com");
		String RAndompass = password();
		Reg.SetPassword(RAndompass);
		Reg.SetcnfPass(RAndompass);
		Reg.SetTelephone(phone());
		Reg.SetPrivacypolicy();
		Reg.ClickonContinue();
		String cnfmsg = Reg.Successmsg();
		if(cnfmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		//Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");
		else {
			logger.error("test failed...");
       	 logger.debug("Debug logs");
     	Assert.assertTrue(false);
		}
		
		 }
         catch(Exception e) {
        	 Assert.fail();
         }
    logger.info("Test finished");
	}
	

}
