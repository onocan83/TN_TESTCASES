package com.tn.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.pagefactory.LogIn_PageFactory;
import com.tn.pagefactory.Registration_PageFactory;
import com.tn.testbases.TN_TestBases;

public class TN_Registration extends TN_TestBases{
	
public WebDriver driver;
public SoftAssert softassert = new SoftAssert();
public LogIn_PageFactory tnloginpage = new LogIn_PageFactory(driver);
public Registration_PageFactory tnregistrationpage = new Registration_PageFactory(driver);
	
	
public 	TN_Registration() {
	super();
}

@BeforeMethod
	public void initialSetup() throws Exception {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
	    Thread.sleep(7000);
	}

	
	@Test (priority=1, enabled=false)
	public void registerWithMandatoryFields()  {
		LogIn_PageFactory tnloginpage = new LogIn_PageFactory(driver);
		Registration_PageFactory tnregistrationpage = new Registration_PageFactory(driver);
		tnloginpage.clickingmyaccountpart();
		tnregistrationpage.clickingregistrationpartt();
		tnregistrationpage.typefirstname();
		tnregistrationpage.typelastname();
		tnregistrationpage.typeemailaddress();
		tnregistrationpage.typetelephonenumber();
		tnregistrationpage.typepassword();
		tnregistrationpage.confirmthepassword();
		tnregistrationpage.chooseNOradiobuttonfornewsletter();
		tnregistrationpage.agreeprivacypolicy();
		tnregistrationpage.clickcontinuebutton();
	
		String registerverificationmessage = driver.findElement(By.cssSelector("div[id='content'] h1")).getText();
		String registeractualverificationmessage = "Your Account Has Been Created!";
	    softassert.assertEquals(registerverificationmessage,registeractualverificationmessage);
	    softassert.assertAll();
	    
	}
	
	@Test(priority = 2)
	public void registerAccountWithExistingEmail() {
		LogIn_PageFactory tnloginpage = new LogIn_PageFactory(driver);
		Registration_PageFactory tnregistrationpage = new Registration_PageFactory(driver);
		tnloginpage.clickingmyaccountpart();
		tnregistrationpage.clickingregistrationpartt();
		tnregistrationpage.typefirstname();
		tnregistrationpage.typelastname();
		tnregistrationpage.typeEXISTINGemailaddress();
		tnregistrationpage.typetelephonenumber();
		tnregistrationpage.typeEXISTINGpassword();
		tnregistrationpage.confirmtheEXISTINGpassword();
		tnregistrationpage.chooseYESradiobuttonfornewsletter(); //radio button newsletter chosen yes
		tnregistrationpage.agreeprivacypolicy();
		tnregistrationpage.clickcontinuebutton();
		
		String existingemailIDwarningmessage = tnregistrationpage.existingemailIDwarningmessage();
		String existingemailIDactualwarningmessage = "Warning: E-Mail Address is already registered!";
		softassert.assertEquals(existingemailIDwarningmessage, existingemailIDactualwarningmessage);
	    softassert.assertAll();
	
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	
}
	
	
}
