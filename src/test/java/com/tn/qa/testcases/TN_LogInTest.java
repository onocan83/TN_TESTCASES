package com.tn.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.pagefactory.LogIn_PageFactory;
import com.tn.testbases.TN_TestBases;



public class TN_LogInTest extends TN_TestBases {
	
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	public LogIn_PageFactory tnloginpage = new LogIn_PageFactory(driver);
	
	public TN_LogInTest() {
	super();
	}
	
	@BeforeMethod
	public void initialSetup() {
	driver = new ChromeDriver();	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
	driver.get("https://tutorialsninja.com/demo/");
	}
   
	@Test(priority = 1)
	public void loginWithValidCredentials() {
		LogIn_PageFactory tnloginpage = new LogIn_PageFactory(driver);
		tnloginpage.clickingmyaccountpart();
		tnloginpage.clickingloginpart();
		tnloginpage.typingVALIDemail();
		tnloginpage.typingVALIDpassword();
	    tnloginpage.clickingloginbutton();

		String itemaftercorrectcredentials = tnloginpage.verificationaftersignin();
		String actualitemaftercorrectcredentials = "My Affiliate Account";
		softassert.assertEquals(itemaftercorrectcredentials, actualitemaftercorrectcredentials );
		softassert.assertAll();
	}
		
		@Test(priority = 2)
	public void loginWithInvalidCredentials() {
			LogIn_PageFactory tnloginpage = new LogIn_PageFactory(driver);
			tnloginpage.clickingmyaccountpart();
			tnloginpage.clickingloginpart();
			tnloginpage.typingINVALIDemail();
			tnloginpage.typingINVALIDpassword();
		    tnloginpage.clickingloginbutton();
		
		String warningmessageforINVALIDcredentials = tnloginpage.warningmessageafterINVALIDlogin();
		String actualwarningmessageforINVALIDcredentials = "Warning: No match for E-Mail Address and/or Password.";
		softassert.assertEquals(warningmessageforINVALIDcredentials, actualwarningmessageforINVALIDcredentials );
		softassert.assertAll();
		}
		
		@Test(priority =3)
		public void loginWithNoCredential() {
			LogIn_PageFactory tnloginpage = new LogIn_PageFactory(driver);
			tnloginpage.clickingmyaccountpart();
			tnloginpage.clickingloginpart();
			tnloginpage.clickingloginbutton();
			
			String warningmessageforNOcredentials = tnloginpage.warningmessageafterINVALIDlogin();
			String actualwarningmessageforNOcredentials = "Warning: No match for E-Mail Address and/or Password.";
			softassert.assertEquals(warningmessageforNOcredentials, actualwarningmessageforNOcredentials );
			softassert.assertAll();
			
		}
		
		@AfterMethod
		public void tearDown() {
		driver.quit();
		
}
	
	
}