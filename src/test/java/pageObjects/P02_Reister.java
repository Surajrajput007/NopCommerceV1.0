package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P02_Reister extends BasePage
{
WebDriver driver;

 public P02_Reister(WebDriver driver) {
	 super (driver);
 }
 
 @FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstname;
 @FindBy(xpath="//input[@id='input-lastname']") WebElement txt_Lastname;
 @FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
 @FindBy(xpath="//input[@id='input-telephone']") WebElement txt_Telephone;
 @FindBy(xpath="//input[@id='input-password']") WebElement txt_Password;
 @FindBy(xpath="//input[@id='input-confirm']") WebElement txt_Cnf_Password;
 @FindBy(xpath="//input[@name='agree']") WebElement Chc_Policy;
 @FindBy(xpath="//input[@value='Continue']") WebElement Btn_Continue;
 @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement Conf_Msg;
 
 
 public void SetFirstname(String fname) {
	 txt_firstname.sendKeys(fname);
 }
 
 public void Setlastname(String Lname) {
	 txt_Lastname.sendKeys(Lname);
 }
 
 public void SetEmail(String email) {
	 txt_email.sendKeys(email);
 }
 
 public void SetTelephone(String telephone) {
	 txt_Telephone.sendKeys(telephone);
 }
 
 public void SetPassword(String pass) {
	 txt_Password.sendKeys(pass);
 }
 public void SetcnfPass(String cnfmpass) {
	 txt_Cnf_Password.sendKeys(cnfmpass);
	 }
 public void SetPrivacypolicy() {
	 Chc_Policy.click();
 }
 
 public void ClickonContinue() {
	 Btn_Continue.click();
 }

 public String Successmsg() {
	 try {
		 return(Conf_Msg.getText());
	 }catch(Exception e) {
		 return(e.getMessage());
	 }
 }
 

 
 
}