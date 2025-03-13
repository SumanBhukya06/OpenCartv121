package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage{
    //constructor invoke
    public HomePage(WebDriver driver){
        super(driver);
    }
    //Locators

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyaccount;
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement lnkRegister;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement lnkLogin;
    String current_url=driver.getCurrentUrl();
    //Search box
    @FindBy(xpath = "//input[@name='search']")
    WebElement txt_Search;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement clkbtnSearch;

    //Action methods
    public void setLnkMyaccount(){
        lnkMyaccount.click();
    }
    public void setLnkRegister(){
        lnkRegister.click();
    }
    public void setLnkLogin(){
        lnkLogin.click();
    }
    public boolean setLnkLogin1(){
        return lnkLogin.isDisplayed();
    }

    public String setpageURL(){
        try {
            return current_url;
    }catch (Exception e){
            return e.getMessage();
        }
    }

    public void setTxt_Search(String prod){
        txt_Search.sendKeys(prod);
        txt_Search.clear();
    }

    public void setClkbtnSearch(){
        clkbtnSearch.click();
    }


}
