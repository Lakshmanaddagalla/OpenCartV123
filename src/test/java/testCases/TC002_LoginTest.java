package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest  extends BaseClass{
	
	@Test(groups = {"sanity","Master"})
	public void verify_Login() {
		
		logger.info("***Starting TC002_LoginTest ***");
		 try {
		HomePage hP=new HomePage(driver);
		hP.clickMyAccount();
		logger.info("***Clicked on Myaccount ***");
		hP.clickLogin();
		logger.info("***Clicked on Login ***");
		LoginPage lPage=new LoginPage(driver);
		lPage.enterEmail(p.getProperty("username"));
		lPage.enterPassword(p.getProperty("password"));
		lPage.clickLogin();
		
		MyAccountPage mypage=new MyAccountPage(driver);
	    boolean targetPage=	mypage.isMyAccountPageExist();
	
	    //Assert.assertEquals(targetPage,true,"Login Failed");
	    Assert.assertTrue(targetPage);
	
	    logger.info("***Finished TC002_LoginTest ***");
	}catch(Exception e) {
		Assert.fail();
	}
	}
}
