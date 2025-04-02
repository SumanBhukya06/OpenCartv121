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

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement btn_Continue_success;

    //Account Reg page text
    @FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
    WebElement firstNameDes;

    @FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    WebElement lastNameDes;

    @FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
    WebElement eMailDes;

    @FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]" )
    WebElement telePhoneDes;

    @FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]" )
    WebElement passwordDes;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement policyDes;

    @FindBy(xpath = "//h1[normalize-space()='Register Account']")
    WebElement registerAccountHeading;

    @FindBy(xpath = "//div[@class='text-danger']")
    WebElement confirm_pwd_text_danger;


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
    public void setBtn_Continue_success(){
        btn_Continue_success.click();
    }

    public boolean getfirstNameDes(){
        return firstNameDes.isDisplayed();
    }

    public boolean getlastNameDes(){
        return lastNameDes.isDisplayed();
    }

    public boolean getEmailDes(){
        return eMailDes.isDisplayed();
    }

    public boolean getTelephoneDes(){
        return telePhoneDes.isDisplayed();
    }

    public boolean getPasswordDes(){
        return passwordDes.isDisplayed();
    }

    public boolean getPolicyDes(){
        return policyDes.isDisplayed();
    }

    public boolean isRegisterAccountIsDisplayed(){
        return registerAccountHeading.isDisplayed();
    }

    public boolean isTextDangerPwdMismatchDisplayed(){
        return confirm_pwd_text_danger.isDisplayed();
    }
}
