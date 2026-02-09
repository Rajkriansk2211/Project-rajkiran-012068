package org.Gitprojectss;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	
// Launch browser based on name
	public  static WebDriver driver;
	
    public static void launchBrowser3(String browserName) {

        if (browserName == null) {
            browserName = "chrome"; // default
        }

        switch (browserName.toLowerCase()) {

        case "chrome":

            WebDriverManager.chromedriver().setup();

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(chromeOptions);
            break;

        case "firefox":

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions firefoxOptions = new FirefoxOptions();

            driver = new FirefoxDriver(firefoxOptions);
            break;

        case "edge":

            WebDriverManager.edgedriver().setup();

            driver = new EdgeDriver();
            break;

        default:

            System.out.println("Invalid browser name: " + browserName);
            System.out.println("Launching default browser: Chrome");

            WebDriverManager.chromedriver().setup();

            ChromeOptions defaultOptions = new ChromeOptions();
            defaultOptions.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(defaultOptions);
            break;
        }

        driver.manage().window().maximize();
    }

    public static void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }
    }

	
//	UrlLaunch	
	public static void urllaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
//	SendKeys
	public static void sendKeys(WebElement e, String value) {
		e.sendKeys(value);
		}
	
//implicility wait
	
		public static  void implicitlyWait (int a) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));

		}
		
// Select dropdown by string value
	    public static void selectByValue(WebElement element, String value) {
	        Select select = new Select(element);
	        select.selectByValue(value);
	    }  
		    
//Select By Index
	    public static void selectByIndex(WebElement element, int index) {
	        Select select = new Select(element);
	        select.selectByIndex(index);
	    }
		
//	    get Dropdown text
	    public String getSelectedDropdownText(WebElement element) {
	        Select sc = new Select(element);
	        return sc.getFirstSelectedOption().getText();
	    }
	
	    
//Click
		
		public static void click(WebElement e, String value) {
			e.click();
		}
		
//GetUrl
		
		public static String getCurrentUrl() {
		   String url = driver.getCurrentUrl();
		   return url;
		}
		
//Quit
		
		public static void quit() {
			driver.quit();
	}
		
//getTitle
		
		public static String getTitle() {
			String title = driver.getTitle();
			return title;

		}

		
//		Alertaccepts
		
		public void alertOk() {
			Alert a = driver.switchTo().alert();
			a.accept();
		}
		
		
//		DomAttributes
		public static String getDomAttributes(WebElement e) {
			String attribute = e.getDomAttribute("value");
			return attribute;

		}
		
//getStringArrtributes		
		public static String getStringAttributes(WebElement e) {
			String attribute = e.getAttribute("value");
			return attribute;
		}
		
//	DragandDrop	
		public static void dragAndDrop (WebElement src , WebElement tar) {
			Actions a = new Actions(driver);
			a.dragAndDrop(src, tar);

		}
		
//select index	
		public static void selectByIndexint(WebElement e, int index) {
			Select s = new Select(e);
			s.selectByIndex(index);

		  }
		
//		Press Enter Keyboad action using Robot
		
		public static void pressEnterKey() {
			Robot robot;
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				
				e.printStackTrace();
			}
		}
		public static void pageDown() {
		 Actions a1 = new Actions (driver);
		 a1.sendKeys(Keys.PAGE_DOWN).perform();

		}
		
//switch frame by index
		
		public void switchToFrameByIndex(int index) {
	        driver.switchTo().frame(index);
	    }		
		public static void switchToFrame(WebElement frameElement) {
		    driver.switchTo().frame(frameElement);
		}		
		public static void scrollToElement(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }		
// Verify text equality (custom assertion)
	    public void verifyTextEquals(String actual, String expected) {
	        if (actual.equals(expected)) {
	            System.out.println("PASS: Text matches -> " + actual);
	        } else {
	            System.out.println("FAIL:");
	            System.out.println("Expected: " + expected);
	            System.out.println("Actual  : " + actual);
	        }
	    }
	    
//DateFeild Resuablecode using Keycontrols = adactin
	    
	    public static void enterDate(WebElement element, String date) {
	        element.click();
	        element.sendKeys(Keys.CONTROL + "a");
	        element.sendKeys(Keys.DELETE);
	        element.sendKeys(date);
	        element.sendKeys(Keys.TAB);
	    }
	    
//adactin  Get text from table using row and column
	    public String getTableCellText(WebElement table, int row, int column) {

	        WebElement cell = table.findElement(
	                By.xpath(".//tr[" + row + "]/td[" + column + "]")
	        );
	        return cell.getText().trim();
	    }
	    
// adactin Verify expected vs actual value
	    public void verifyTableValue(WebElement table, int row, int column, String expectedValue) {

	        String actualValue = getTableCellText(table, row, column);

	        if (actualValue.equals(expectedValue)) {
	            System.out.println("Value MATCHED : " + actualValue);
	        } else {
	            System.out.println("Value NOT MATCHED");
	            System.out.println("Expected: " + expectedValue);
	            System.out.println("Actual  : " + actualValue);
	        }
	    }
	    
// Get text from any element
	    public String getText(WebElement element) {
	        return element.getText().trim();
	    }
 // Print text to console
	    public void printText(String label, String value) {
	        System.out.println(label + " : " + value);
	    }
	    
	    
	    
	    
	    public void switchToWindow(int index) {
	    	Set<String> all = driver.getWindowHandles();
			List<String> li = new ArrayList<String>();
			li.addAll(all);
			driver.switchTo().window(li.get(index));
		}
	    


}
