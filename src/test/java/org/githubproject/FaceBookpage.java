package org.githubproject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookpage extends BaseClass{
	
	public FaceBookpage() {
		   PageFactory.initElements(driver, this);
		}
	
	@FindBy(id="email")
	 WebElement textuser;

	public WebElement getTextuser() {
		return textuser;
	}

}
