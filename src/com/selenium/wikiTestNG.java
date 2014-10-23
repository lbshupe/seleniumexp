package com.selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

@Test
public class wikiTestNG extends SelTestCase {


	public void testWikipedia() {

		List<String>expectedLinks = Arrays.asList("Privacy policy","About Wikipedia","Disclaimers");
		List<String>actualLinks = new ArrayList<String>();
		
		driver.get("http://www.wikipedia.org/");
		driver.findElement(By.id("searchInput")).sendKeys("Selenium Software");
		driver.findElement(By.name("go")).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Selenium (software)")));
		driver.findElement(By.linkText("Selenium (software)")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("img[src='//upload.wikimedia.org/wikipedia/en/5/5c/Seleniumlogo.png']")).isDisplayed());
		Reporter.log("test case passed");
		List<WebElement> anchorList = driver.findElements(By.tagName("a"));
		for(WebElement lelement:anchorList) {
			actualLinks.add(lelement.getText());
		}
		assert actualLinks.containsAll(expectedLinks);
	}
}
