package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class accountLogin {
	
	private WebDriver driver;
	
	public accountLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginToAccount() {
		
		driver.findElement(By.id("uid")).sendKeys("les1962");
		driver.findElement(By.id("userPassword")).sendKeys("testtest");
		driver.findElement(By.id("theSubmit")).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Manage Account")));
	}

}
