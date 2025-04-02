package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement msgHeading;
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement lnklogout;
    //click on my account drop menu
    /*@FindBy(xpath = "//span[normalize-space()='My Account']" )
    WebElement lnkMyAccount;*/

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
    WebElement myALogout;

    @FindBy(xpath = "//a[normalize-space()='Subscribe / unsubscribe to newsletter']")
    WebElement btn_subscribe_Unsubscribe;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement subscription_des;


    public boolean isMyAccountPageExits(){
        try {
            return (msgHeading.isDisplayed());
        }
        catch (Exception e){
            return false;
        }
    }

    /*public void setLnkMyAccount(){
        lnkMyAccount.click();
    }*/

    public void setMyALogout(){
        myALogout.click();
    }

    public void setLnklogout(){
        lnklogout.click();
    }

    public void setBtn_subscribe_Unsubscribe(){
        btn_subscribe_Unsubscribe.click();
    }

    public boolean getSubscriptionIsDisplayed(){
        return subscription_des.isDisplayed();
    }
}
