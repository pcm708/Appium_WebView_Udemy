package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest{
	HomePage homePage;
	LoginPage loginPage;
	
	HomePageTest(){
		homePage = new HomePage(driver);
	}
	
	@Test(priority=1)
	public void verifyApplicationLogoDisplayed() {
		Assert.assertTrue(homePage.getAppLogo());
		System.out.println("Pass");
	}
	
	@Test(priority=2)
	public void verifySaleAlertPromptMessageDisplayed() {
		Assert.assertTrue(homePage.getSaleAlertPromptMessage());
		System.out.println("Pass");
	}

	@Test(priority=3)
	public void navigateToLoginPage() {
		loginPage= homePage.clickOnSideMenuList().clickOnSideMenuButton("Log in");
		Assert.assertEquals(loginPage.verifyLoginPageHeader(),"Log In to Your Udemy Account!");
	}
}