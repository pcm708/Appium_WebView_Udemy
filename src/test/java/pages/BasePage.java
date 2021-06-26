package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static utils.ElementUtil.*;

public class BasePage{

	protected AndroidDriver<AndroidElement> driver;
	
	public BasePage(AndroidDriver<AndroidElement> driver){
		this.driver =driver;
	}
	
	By udemyLogo = MobileBy.cssSelector("img[alt='Udemy']");
	By salePrompt = MobileBy.xpath("//span[text()='New student deal']");
	By sideMenuButton = MobileBy.cssSelector("[data-purpose=\"side-menu-opener\"]");
	By menuItems = MobileBy.xpath("//div[contains(@class,'side-drawer--side-left')]//li//div");
	
	public Boolean getAppLogo() {
		return isElementDisplayed(driver,udemyLogo);
	}
	
	public Boolean getSaleAlertPromptMessage() {
		return isElementDisplayed(driver,salePrompt);
	}
	
	public void launchWebSite() {
		driver.activateApp("com.android.chrome");
		driver.get("https://www.udemy.com/");
	}
	
	public BasePage clickOnSideMenuList() {
		click(driver,sideMenuButton);
		return this;
	}
	
	public LoginPage clickOnSideMenuButton(String buttonName) {
		driver.findElements(menuItems).stream()
			.filter(ele->ele.getText().equals("Log in"))
			.findFirst().get().click();
		return new LoginPage(driver);
	}
	
	public void quitSession() {
		driver.quit();
	}
}