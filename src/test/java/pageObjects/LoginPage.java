package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    //constructor invoke
    public LoginPage(WebDriver driver){
        super(driver);
    }
    //Locators
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement loginEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement loginpassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    //Action Methods
    public void setLoginEmail(String lemail){
        loginEmail.sendKeys(lemail);
    }
    public void setLoginpassword(String lpwd){
        loginpassword.sendKeys(lpwd);
    }

    public void setBtnLogin(){
        btnLogin.click();
    }

}
