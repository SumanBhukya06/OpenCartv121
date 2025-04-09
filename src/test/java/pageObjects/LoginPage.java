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

    //new customer continue
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement new_cus_continue_btn;

    //register button from right column
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Register']")
    WebElement register_btn_right_col;

    //Mismatch text of email and password
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement isNoMatchEmailPasswordTextDisplayed;

    //Forgotten password link
    @FindBy(xpath = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
    WebElement isForgottenPasswordDisplayed;

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

    public void setNew_cus_continue_btn(){
        new_cus_continue_btn.click();
    }

    public void setRegister_btn_right_col(){
        register_btn_right_col.click();
    }

    public boolean isNoMatchEmailPassWordDisplayed(){
        return isNoMatchEmailPasswordTextDisplayed.isDisplayed();
    }

    //forgotten password link
    public boolean isForgottenPwdDisplayed(){
        if (isForgottenPasswordDisplayed.isDisplayed()){
            isForgottenPasswordDisplayed.click();
            return true;
        }else {
            return false;
        }
    }
    public WebElement LoginEmailKey(){
        return loginEmail;
    }

    public WebElement LoginPassWordKey(){
        return loginpassword;
    }

    public WebElement LoginButtonKey(){
       return btnLogin;
    }
}
