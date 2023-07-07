package com.tn.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration_PageFactory {
public WebDriver driver;
	
@FindBy(linkText = "Register")
private WebElement registerpart;

@FindBy(id = "input-firstname")
private WebElement firstname;

@FindBy(id = "input-lastname")
private WebElement lastname;

@FindBy(id = "input-email")
private WebElement email;

@FindBy(id = "input-telephone")
private WebElement telephone;

@FindBy(id = "input-password")
private WebElement password;

@FindBy(id = "input-confirm")
private WebElement passwordconfirm;

@FindBy(xpath = "//input[@value='0']")
private WebElement radiobuttonNO;

@FindBy(xpath = "//input[@value = '1' and @name = 'newsletter']")
private WebElement radiobuttonYES;

@FindBy(name = "agree")
private WebElement privacypolicy;

@FindBy(css = "input.btn.btn-primary")
private WebElement continuebutton;

@FindBy(css = "div.alert")
private WebElement existingemailIDwarning ;


public Registration_PageFactory(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}
public void clickingregistrationpartt() {
	registerpart.click();
}
public void typefirstname() {
	firstname.sendKeys("Ono");
}
public void typelastname() {
	lastname.sendKeys("Can");
}
public void typeemailaddress() {
	email.sendKeys("cnonur@hotmail.com");
}
public void typeEXISTINGemailaddress() {
	email.sendKeys("cnonur@gmail.com");
}
public void typetelephonenumber() {
	telephone.sendKeys("2029991515");
}
public void typepassword() {
	password.sendKeys("Onur@555");
}
public void typeEXISTINGpassword() {
	password.sendKeys("Onur@123");
}
public void confirmthepassword() {
	passwordconfirm.sendKeys("Onur@123");
}
public void confirmtheEXISTINGpassword() {
	passwordconfirm.sendKeys("Onur@123");
}
public void chooseNOradiobuttonfornewsletter() {
	radiobuttonNO.click();
}
public void chooseYESradiobuttonfornewsletter() {
	radiobuttonYES.click();
}
public void agreeprivacypolicy() {
	privacypolicy.click();
}
public void clickcontinuebutton() {
	continuebutton.click();
}
public String existingemailIDwarningmessage() {
	String existingemailIDactualwarningmessage = existingemailIDwarning.getText();
	return existingemailIDactualwarningmessage;
}






}

