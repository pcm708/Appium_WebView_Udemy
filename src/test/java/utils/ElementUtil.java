package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static utils.PropertyFileReader.*;

public class ElementUtil {

	static WebDriverWait wait;
	
	public static void waitForElementDisplayed(AndroidDriver<AndroidElement> driver,By by) {
		wait = new WebDriverWait(driver, Integer.parseInt(getProperty("defaultExplicitWait")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public static void waitForElementToBeClickable(AndroidDriver<AndroidElement> driver,By by) {
		wait = new WebDriverWait(driver, Integer.parseInt(getProperty("defaultExplicitWait")));
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public static Boolean isElementDisplayed(AndroidDriver<AndroidElement> driver,By by) {
		waitForElementDisplayed(driver,by);
		return driver.findElement(by).isDisplayed();
	}

	public static String getElementText(AndroidDriver<AndroidElement> driver,By by) {
		waitForElementDisplayed(driver,by);
		return driver.findElement(by).getText().toString().trim();
	}
	
	public static void click(AndroidDriver<AndroidElement> driver,By by) {
		waitForElementDisplayed(driver,by);
		waitForElementToBeClickable(driver,by);
		
		driver.findElement(by).click();
	}
}
