package org.githubproject;

import org.Gitprojectss.BaseClass;
import org.Gitprojectss.Flipkartpage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class GithubPro extends BaseClass {
	

	@BeforeClass
	public static void beforeclass() {
		System.out.println("beforeclass");
		launchBrowser3("chrome");
		implicitlyWait(10); 		
	}
	
	@Test
	public  void test()  {
		System.out.println("test");
		urllaunch("https://www.flipkart.com/");
		
		Flipkartpage f = new Flipkartpage();
		sendKeys(f.getSearchtxt(),"Iphone 16");
		pressEnterKey();
		String output = f.getResultText(driver);
		System.out.println("Output: " + output);
		
	}
	
	
	@AfterClass
	public static void afterclass() {
		System.out.println("afterclass");
		quit();
	}

}
