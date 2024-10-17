package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = {"Datadriver","Master"})
	public void verify_LoginDDT(String email,String pwd,String exp) {
		
		logger.info("***Start TC003_LoginDDT ***");
		try {
		HomePage hP=new HomePage(driver);
		hP.clickMyAccount();
		logger.info("***Clicked on Myaccount ***");
		hP.clickLogin();
		logger.info("***Clicked on Login ***");
		LoginPage lPage=new LoginPage(driver);
		lPage.enterEmail(email);
		lPage.enterPassword(pwd);
		lPage.clickLogin();
		MyAccountPage mypage=new MyAccountPage(driver);
	    boolean targetPage=	mypage.isMyAccountPageExist();
	    
	    /*Valid data -- login success -- test pass
	     * valid data -- login failed-- test failed
	     * 
	     * invalid data--- login failed-- test pass
	     * invalid data-- login success-- test failed
	     */
	    
	    if(exp.equalsIgnoreCase("valid")) {
	    	if(targetPage==true) {
	    		mypage.clickLogout();
	    		Assert.assertTrue(true);
	    	}else {
	    		Assert.assertFalse(false);
	    	}
	    }
	    if(exp.equalsIgnoreCase("invalid")) {
	    	if(targetPage==true) {
	    		mypage.clickLogout();
	    		Assert.assertTrue(false);
	    	}else {
	    		Assert.assertTrue(true);
			}
	    	  }
	}catch (Exception e) {
		Assert.fail();
	}
	
		logger.info("***Finished TC003_LoginDDT ***");
	}
	
}
