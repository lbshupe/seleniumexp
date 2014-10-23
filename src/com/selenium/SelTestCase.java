package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class SelTestCase {
	
	WebDriver driver;
	
	@BeforeMethod
	@Parameters("browser")
	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:/Users/wbadmin/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("FF")) {
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.ie.driver","C:/Users/wbadmin/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
