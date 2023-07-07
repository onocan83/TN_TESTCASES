package com.tn.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.pagefactory.SearchProduct_PageFactory;
import com.tn.testbases.TN_TestBases;



public class TN_SearchProduct extends TN_TestBases {

	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	public SearchProduct_PageFactory tnsearchproduct = new SearchProduct_PageFactory(driver);
	
	public 	TN_SearchProduct() {
		super();	
	}
	
	@BeforeMethod
	public void initialSetup() throws Exception {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
	    Thread.sleep(7000);
	}
	
	public void searchWithValidProduct() {
		SearchProduct_PageFactory tnsearchproduct = new SearchProduct_PageFactory(driver);
		tnsearchproduct.typeVALIDproductname();
		tnsearchproduct.clickonsearchbutton();
		
		String searchingVALIDproduct = tnsearchproduct.confirmingVALIDproduct();
		String actualsearchingVALIDproduct = "Apple Cinema 30\"";
		softassert.assertEquals(searchingVALIDproduct, actualsearchingVALIDproduct);
		softassert.assertAll();
	}
	
	@Test(priority = 2)
	public void searchWithInvalidProduct() {
		SearchProduct_PageFactory tnsearchproduct = new SearchProduct_PageFactory(driver);
		tnsearchproduct.typeINVALIDproductname();
		tnsearchproduct.clickonsearchbutton();
		
        String searchingINVALIDproduct = tnsearchproduct.confirmingINVALIDproduct();
		String actualsearchingINVALIDproduct = "There is no product that matches the search criteria.";
		softassert.assertTrue(searchingINVALIDproduct.equals(actualsearchingINVALIDproduct));
		softassert.assertAll();
		
		}
	
	@Test(priority = 3)
	public void verifySearchWithoutProduct() {
		SearchProduct_PageFactory tnsearchproduct = new SearchProduct_PageFactory(driver);
		tnsearchproduct.clickonsearchbutton();
		
		String searchingINVALIDproduct = tnsearchproduct.confirmingINVALIDproduct();
		String actualsearchingINVALIDproduct = "There is no product that matches the search criteria.";
		softassert.assertTrue(searchingINVALIDproduct.equals(actualsearchingINVALIDproduct));
		softassert.assertAll();
		
	}
	@AfterMethod
	public void tearDown() {
	driver.quit();
	
	}
	
	
}

	
	
	

		
	
	
	
	
	