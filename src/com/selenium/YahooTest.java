package com.selenium;

import java.util.List;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class YahooTest extends SelTestCase {
	
	
	public void testYahoo() {
		
		Map <String, String> usernamepasswd = new HashMap<String, String>();
		usernamepasswd.put("modisshupe","Lester1234");
		usernamepasswd.put("modislaura","Justin1234");
		Iterator mit = usernamepasswd.entrySet().iterator();
//		while (mit.hasNext()) {
//			Map.Entry pairs = (Map.Entry) mit.next();
			driver.get("https://mail.yahoo.com");
//			WebDriverWait ywait = new WebDriverWait(driver, 100);
			Wait<WebDriver> ywait = new FluentWait<WebDriver>(driver)
				    .withTimeout( 60, TimeUnit.SECONDS )
				    .pollingEvery( 5, TimeUnit.SECONDS )
				    .ignoring(StaleElementReferenceException.class);
			System.out.println("before first wait");
			WebElement yelement = ywait.until(ExpectedConditions.elementToBeClickable(By.id(".save")));
			System.out.println("after first wait");
//			driver.findElement(By.id("username")).sendKeys((String)pairs.getKey());
//			driver.findElement(By.id("passwd")).sendKeys((String)pairs.getValue());
			driver.findElement(By.id("username")).sendKeys("modisshupe");
			driver.findElement(By.id("passwd")).sendKeys("Lester1234");
			driver.findElement(By.id(".save")).click();
			yelement = ywait.until(ExpectedConditions.presenceOfElementLocated(By.id("yucs-logo")));
			List<WebElement> anchorList = driver.findElements(By.tagName("a"));
			for(WebElement element:anchorList) {
				System.out.println(element.getText());
			}
			Assert.assertTrue(driver.findElement(By.id("yucs-logo-ani")).isDisplayed());
//		}
	}
}