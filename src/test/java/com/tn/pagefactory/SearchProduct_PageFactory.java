package com.tn.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct_PageFactory {
	public WebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder = 'Search']")
	private WebElement searchbar;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchbarclickbutton;
	
	@FindBy(xpath = "//a[normalize-space()='Apple Cinema 30\"']")
	private WebElement validproductconfirmation;
	
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement invalidproductconfirmation;		
	
	
	public SearchProduct_PageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void typeVALIDproductname() {
		searchbar.sendKeys("Apple");
	}
	public void typeINVALIDproductname() {
		searchbar.sendKeys("Toshiba");
	}
	public void clickonsearchbutton() {
		searchbarclickbutton.click();
	}
	public String confirmingVALIDproduct() {
		String actualsearchingVALIDproduct = validproductconfirmation.getText();
		return actualsearchingVALIDproduct;
	}
	public String confirmingINVALIDproduct() {
		String actualsearchingINVALIDproduct = invalidproductconfirmation.getText();
		return actualsearchingINVALIDproduct;
	}
	
	
}