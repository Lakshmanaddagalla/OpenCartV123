package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProduct extends BaseClass {

	@Test
	public void verify_Search_Product() {
		
		logger.info("**** Stating TC004_SearchProduct ****");
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
		
		SearchPage sPage=new SearchPage(driver);
	boolean searchLink=	sPage.isSearchLInkExits();
	
	Assert.assertTrue(searchLink);
	logger.info("** Finished TC004_SearchProduct ***");
	}catch(Exception e) {
		Assert.fail();
	}
	}
}
