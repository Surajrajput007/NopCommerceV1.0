package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public Properties p;
	
public Logger logger;
	public static WebDriver driver;
	@BeforeClass(groups = {"Regression","Master","Sanity","DataDriven"})
	@Parameters({"os","browser"})
	public void setup(String os,String browser) throws IOException {
		FileReader file = new FileReader("D:\\Frameworks\\NopCommerce1.0\\src\\test\\resources\\configdata.properties");
		p = new Properties();
		p.load(file);
	logger=	LogManager.getLogger(this.getClass());
	
		switch(browser.toLowerCase()){
		case "chrome": driver = new ChromeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		case "safari": driver = new SafariDriver(); break;
		default : System.out.println("please enter istalled browser"); return;
		}
		
		//driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.get(p.getProperty("URL"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
		
	}
	@AfterClass(groups = {"Regression","Master","Sanity","DataDriven"})
	public void teardown() {
		driver.quit();
	}
	 public String RandomString() {
		 String rantext=	RandomStringUtils.randomAlphabetic(7);
		 	 return rantext;
		  }

		 public String phone() {
		 String phoneran=	RandomStringUtils.randomNumeric(10);
		 	return phoneran;
		 }
		 public String password() { 
		 String Randomalpha=	RandomStringUtils.randomAlphabetic(4);
		  String RandomNum=RandomStringUtils.randomNumeric(7);
		 return(Randomalpha+ "@"+RandomNum);
		 }


		 public String captureScreen (String tname) throws IOException {
			 String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			 TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			 File sourceFile = takesScreenshot.getScreenshotAs (OutputType.FILE);
			 String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" +tname + timeStamp + ".png";
			// String targetFilePath = ("D:\\Frameworks\\NopCommerce1.0\\screenshots" + tname+timeStamp+".png");
			 File targetFile=new File(targetFilePath);
			 sourceFile.renameTo(targetFile);			 
			 return targetFilePath;
			 }
			 

}
