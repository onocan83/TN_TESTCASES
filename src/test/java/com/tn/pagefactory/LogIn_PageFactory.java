package com.tn.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn_PageFactory {

public WebDriver driver;
	
	
	@FindBy(linkText = "My Account")
	private WebElement myaccountpart;

	@FindBy(linkText = "Login")
	private WebElement loginpart;
	
	@FindBy(css = "input#input-email")
	private WebElement emailsection;
	
	@FindBy(css = "input#input-password")
	private WebElement passwordsection;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginbutton;
	
	@FindBy(xpath = "//h2[normalize-space()='My Affiliate Account']")
	private WebElement messageaftervalidcredentialsigningin;
	
	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	private WebElement messageafterinvalidcredentialssigningin;
	

	public LogIn_PageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public void clickingmyaccountpart() {
		myaccountpart.click();
	}
	public void clickingloginpart() {
		loginpart.click();	
	}
	public void typingVALIDemail() {
		emailsection.sendKeys("cnonur@gmail.com");
	}
	public void typingINVALIDemail() {
		emailsection.sendKeys("cnonur@mynet.com");
	}
	public void typingVALIDpassword() {
		passwordsection.sendKeys("Onur123@");
	}
	public void typingINVALIDpassword() {
		passwordsection.sendKeys("BBB123@");
	}
	public void clickingloginbutton() {
		loginbutton.click();
    }
	public String verificationaftersignin() {
		String actualitemaftercorrectcredentials = messageaftervalidcredentialsigningin.getText();
		return actualitemaftercorrectcredentials;
	}
	public String warningmessageafterINVALIDlogin() {
	     String actualwarningmessageforINVALIDcredentials = messageafterinvalidcredentialssigningin.getText();
	     return actualwarningmessageforINVALIDcredentials;
}
	
}

