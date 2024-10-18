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
	
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement macAddToCart;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement confirmation_Msg;

	
	public boolean isSearchLInkExits() {
		try {
		return(searchLink.isDisplayed());
	}catch (Exception e) {
		return false;
	}	}
	
	public void clickAddToCart() {
		macAddToCart.click();
	}
	
	public String getSuccessMessage() {
		try {
		return(confirmation_Msg.getText());
		
	}catch(Exception e) {
		return(e.getMessage());
	}
	}
}
