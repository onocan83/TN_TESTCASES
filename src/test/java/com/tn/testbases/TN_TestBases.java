package com.tn.testbases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tn.utilities.UtilitiesForTN;

public class TN_TestBases {

    public WebDriver driver;
	public Properties prop;
	public FileInputStream ip;
	
	public TN_TestBases() {
		
prop = new Properties();
		
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\tn\\configfiles\\TN_Files");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	public WebDriver initializeBrowserAndOpenApplication(String browser) {
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilitiesForTN.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UtilitiesForTN.PAGE_lOAD_TIMEOUT));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(UtilitiesForTN.SCRIPT_TIMEOUT));
		driver.get(prop.getProperty("URL"));
	
		return driver;
	}

	
	
}
