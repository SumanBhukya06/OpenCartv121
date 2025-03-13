package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

    //Constructor invoke
    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtConfirmPassword;

    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement clkSubscribe;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement clkAgree;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    //Action Methods
    public void setTxtFirstName(String fname) {
        txtFirstName.sendKeys(fname);
    }

    public void setTxtLastName(String lname) {
        txtLastName.sendKeys(lname);
    }

    public void setTxtEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setTxtTelephone(String telephone) {
        txtTelephone.sendKeys(telephone);
    }

    public void setTxtPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void setTxtConfirmPassword(String cpwd) {
        txtConfirmPassword.sendKeys(cpwd);
    }

    public void setClkSubscribe() {
        clkSubscribe.click();
    }
    public void setClkAgree() {
        clkAgree.click();
    }
    public void setBtnContinue(){
        btnContinue.click();
    }

    public String getConfirmationmsz() {
        try {
            return (msgConfirmation.getText());
        } catch (Exception e) {
            return (e.getMessage());
        }
    }
}
