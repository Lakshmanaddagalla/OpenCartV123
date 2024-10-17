package testCases;




import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass{

	

	@Test(groups = {"Regression","Master"})
	public void verify_Account_Registration() {
		
		logger.info("**** Stating TC001_AccountRegistration  ****");
		
		try {
		HomePage hP= new HomePage(driver);
		hP.clickMyAccount();
		logger.info("clicked on myaccount link..");
		hP.clickRegister();
		logger.info("clicked on register link..");
		AccountRegistrationPage repPage=new AccountRegistrationPage(driver);
		logger.info("I am  providing details..");
		repPage.setFirstName(randomString());
		repPage.setLastName(randomString());
		repPage.setEmail(randomString()+"@gmail.com");
		repPage.setTelephone(randomNumber());
		
     	String password=randomAlphaNumaric();
		
		repPage.setPassword(password);
		repPage.setConfirmPassword(password);
		repPage.clickAgree();
		repPage.clickContinue();
		logger.info("Validating expected message..");
	String confMsg=	repPage.getConfirmationMsg();
	Assert.assertEquals(confMsg, "Your Account Has Been Created!");
	}	catch (Exception e) {
		logger.error("Test Failed..");
		logger.debug("Debug logs..");
	 Assert.fail();
	}
		logger.info("**** Finished TC001_AccountRegistration  ****");
	
	
	
	}	
}
