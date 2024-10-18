package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//a[normalize-space()='Search']")
	WebElement searchLink;

	
	public boolean isSearchLInkExits() {
		try {
		return(searchLink.isDisplayed());
	}catch (Exception e) {
		return false;
	}	}
}
