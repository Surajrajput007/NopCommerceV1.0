package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P03_Loginpage extends BasePage {

	public P03_Loginpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_emailaddress;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
	@FindBy(xpath="//input[@value='Login']") WebElement btn_login;
	
	
	public void SetEmailaddress(String emailid){
		txt_emailaddress.sendKeys(emailid);
	}
	
	public void setpassword(String password) {
		txt_password.sendKeys(password);	
	}
	
	public void Clicklogin() {
		btn_login.click();
	}
	
	
	
	
	
	
	
	
}


