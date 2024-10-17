package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	
	}
	

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txt_firstName;
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txt_LastName;
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txt_Email;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txt_Telephone;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txt_Password;
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txt_Confirm_Pwd;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement btn_Agree;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btn_Continue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement cnfMsg_AccountHasBeenCreated;


    //3) Action methods

    public void setFirstName(String firstName) {
        txt_firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        txt_LastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        txt_Email.sendKeys(email);
    }

public void setTelephone(String telephone) {
        txt_Telephone.sendKeys(telephone);
}

    public void setPassword(String password) {
        txt_Password.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        txt_Confirm_Pwd.sendKeys(confirmPassword);
    }

    public void clickAgree() {
        btn_Agree.click();
    }

    public void clickContinue() {
        btn_Continue.click();
    }

    public String getConfirmationMsg() {
        try {
            return (cnfMsg_AccountHasBeenCreated.getText());
        } catch (Exception e) {
            return (e.getMessage());

        }
    }

}
