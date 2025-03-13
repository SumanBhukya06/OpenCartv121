package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LogoutPage extends BasePage {
    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    //Logout confirm message
    @FindBy(xpath = "//h1[normalize-space()='Account Logout']")
    WebElement lgmszconfirmation;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement lgbtnContinue;

    //Action methods
    public boolean isAccountLogoutexists() {
        try {
            return (lgmszconfirmation.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

    public void setLgbtnContinue(){
        lgbtnContinue.click();
    }
}
