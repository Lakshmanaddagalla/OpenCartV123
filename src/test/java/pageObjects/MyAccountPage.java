package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement pageHeading;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchField;
	
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement btn_search;
	
	public boolean isMyAccountPageExist() {
		try {
		return(pageHeading.isDisplayed());
	 	
	   }catch(Exception e) {
		return false;
	}
	
	}
	
	public void clickLogout() {
		logout.click();
	}
	
	public void txtSecarch(String item) {
		searchField.sendKeys(item);
	}

	public void clickSearchBtn() {
		btn_search.click();
	}
	}

