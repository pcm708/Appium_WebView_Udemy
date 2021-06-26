package pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static utils.ElementUtil.*;

public class LoginPage extends BasePage{

	public LoginPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	By loginHeader = MobileBy.cssSelector("#auth-to-udemy-title");
	By loginBtn = MobileBy.cssSelector("#submit-id-submit");
	
	public String verifyLoginPageHeader() {
		return getElementText(driver,loginHeader);
	}
}