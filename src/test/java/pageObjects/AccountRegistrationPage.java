package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement emailExistTextDanger;

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement setTxtFirstName1;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement setTxtLastName1;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement setTxtEmail1;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement setTxtTelephone1;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement setTxtPassword1;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement setTxtConfirmPassword1;

    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement setClkSubscribe1;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement setClkAgree1;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement BtnContinue1;

    //Action Methods
    public void setTxtFirstName(String fname) {
        txtFirstName.sendKeys(fname);
    }

    public void setTxtLastName(String lname) {
        txtLastName.sendKeys(lname);
    }

    public void setTxtEmail(String email) {
            txtEmail.clear(); // Clear any existing value
            txtEmail.sendKeys(email); // Enter email
    }
    public void setTxtTelephone(String telephone) {
        txtTelephone.clear();
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

    public boolean isTextDangerEmailExistsIsDisplayed(){
        return emailExistTextDanger.isDisplayed();
    }
    public String getEmailValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", txtEmail);
    }

    public String getPhoneNumberValidationMessage(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",txtTelephone);
    }

    public WebElement setTxtFirstNameKey() {
        return setTxtFirstName1;
    }

    public WebElement setTxtLastNameKey(){
        return setTxtLastName1;
    }

    public WebElement setTxtEmail1(){
        return setTxtEmail1;
    }
    public WebElement setTxtTelephone1(){
        return setTxtTelephone1;
    }
    public WebElement setTxtPassword1(){
        return setTxtPassword1;
    }
    public WebElement setTxtConfirmPassword1(){
        return setTxtConfirmPassword1;
    }
    public WebElement ClkSubscribe1(){
        return setClkSubscribe1;
    }
    public WebElement ClkAgree1(){
        return setClkAgree1;
    }
    public WebElement BtnContinue1(){
        return BtnContinue1;
    }
}
