package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P04_Myaccount extends BasePage {
 public P04_Myaccount(WebDriver driver) {
	 super(driver);
 }
 
 @FindBy(xpath="//h2[normalize-space()='My Account']") WebElement msgHeading;
 @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement lnk_logout;
 
 
 public void ClickonLogout() {
	 lnk_logout.click();
 }
 
 
 public boolean ismyaccountexits () {
	try {
	 return (msgHeading.isDisplayed());
 }
	catch (Exception e) {
		return false;
	}
 }
 
 
 
}
