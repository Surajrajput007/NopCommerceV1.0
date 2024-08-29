package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P01_HomePage extends BasePage {

	public P01_HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']") 
	WebElement Lnk_MyAccount;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement Lnk_Register;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement Lnk_login;

	public void ClickMyaccount() {
		Lnk_MyAccount.click();
	}

	public void ClickRegister() {
		Lnk_Register.click();
	}


	public void ClickonLogin() {
		Lnk_login.click();
	}
	
	
	
	
	

}

