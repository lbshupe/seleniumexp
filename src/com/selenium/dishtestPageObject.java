package com.selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageobject.accountLogin;

@Test
public class dishtestPageObject extends SelTestCase {


	public void testPageObject() {

		List<String>expectedLinks = Arrays.asList("Configure Email","Manage Account","Usage");
		List<String>actualLinks = new ArrayList<String>();
		accountLogin logintoaccount = new accountLogin(driver);
		driver.get("https://myaccount.dishmail.net/wbisp/dishmail.net/index.jsp");
		logintoaccount.loginToAccount();
		Assert.assertTrue(driver.findElement(By.linkText("click here")).isDisplayed());
		Reporter.log("test case passed");
		List<WebElement> anchorList = driver.findElements(By.tagName("a"));
		for(WebElement lelement:anchorList) {
			actualLinks.add(lelement.getText());
		}
		assert actualLinks.containsAll(expectedLinks);
	}
}
