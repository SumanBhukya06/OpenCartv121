package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver){
        super(driver);
    }
    //Locators
    @FindBy(xpath = "//p[normalize-space()='There is no product that matches the search criteria.']")
    WebElement cap_search_text;

    @FindBy(xpath = "//input[@id='input-search']")
    WebElement keyword_search;

    @FindBy(xpath = "//input[@id='description']")
    WebElement chk_descp;

    @FindBy(xpath = "//h4//a[normalize-space()='iMac']")
    WebElement txt_mac;

    @FindBy(xpath = "//input[@id='button-search']")
    WebElement btn_search;


    //Action Methods
    public String getSearchtext(){
        return cap_search_text.getText();
    }

    public void setKeyword_search(String descrption){
        keyword_search.sendKeys(descrption);
    }

    public void setChk_descp(){
        chk_descp.click();
    }
    public boolean set_txtmac(){
        return txt_mac.isDisplayed();
    }
    public void setBtn_search(){
        btn_search.click();
    }
}
