package tests;

import static mdFactory.MobileWebdriverFactory.getMobileDriver;
import static utils.PropertyFileReader.getProperty;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pages.BasePage;

public class BaseTest {
	
	public AndroidDriver<AndroidElement> driver= null;
	public BasePage basePage;

	BaseTest(){
		try {
			driver = getMobileDriver(getProperty("udid"),getProperty("emulatorName"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		basePage= new BasePage(driver);
	}
	
	@BeforeTest
	public void setup() throws MalformedURLException{
		basePage.launchWebSite();
		Assert.assertTrue(basePage.getAppLogo());
	}

	@AfterTest
	public void tearDown(){
		basePage.quitSession();
	}
}
