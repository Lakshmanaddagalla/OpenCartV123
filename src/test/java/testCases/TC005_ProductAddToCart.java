package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_ProductAddToCart extends BaseClass{
	@Test
	public void verify_Addto_Cart() {
		
		try {
		HomePage hPage= new HomePage(driver);
		hPage.clickMyAccount();
		hPage.clickLogin();
		logger.info("** Clicked login Page ***");
		LoginPage loginPage= new LoginPage(driver);
		loginPage.enterEmail(p.getProperty("username"));
		loginPage.enterPassword(p.getProperty("password"));
		loginPage.clickLogin();
		MyAccountPage myAccountPage=new MyAccountPage(driver);
		myAccountPage.txtSecarch("mac");
		myAccountPage.clickSearchBtn();
		SearchPage searchPage=new SearchPage(driver);
		searchPage.clickAddToCart();
	    
		String msg=searchPage.getSuccessMessage();
	   Assert.assertEquals(msg, " Success: You have added iMac to your shopping cart!");
	   
	   
		
	}catch (Exception e) {
		Assert.fail();
		// TODO: handle exception
	}
		
	}
}
