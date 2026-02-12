package org.Gitprojectss;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkartpage extends BaseClass {
	
	public Flipkartpage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@type=\"text\"])[1]")
     WebElement searchtxt;

	public WebElement getSearchtxt() {
		return searchtxt;
	}
	
	@FindBy(xpath="//span[@class='_Omnvo']")
	WebElement totalitemtxt;

	public String getResultText(WebDriver driver) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(totalitemtxt));

	    return totalitemtxt.getText();
	}
}
