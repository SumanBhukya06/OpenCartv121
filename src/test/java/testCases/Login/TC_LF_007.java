package testCases.Login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_007 extends BaseClass {
    @Test
    public void verify_key_board_actions(){
        HomePage hp=new HomePage(driver);
        hp.setLnkMyaccount();
        hp.setLnkLogin();
        LoginPage lp=new LoginPage(driver);
        Actions actions=new Actions(driver);
        actions.sendKeys(lp.LoginEmailKey()).sendKeys((p.getProperty("email"))).sendKeys(Keys.TAB).perform();
        actions.sendKeys(lp.LoginPassWordKey()).sendKeys(p.getProperty("password")).sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(lp.LoginButtonKey()).sendKeys(Keys.ENTER).perform();

        MyAccountPage map=new MyAccountPage(driver);
        Assert.assertTrue(map.isMyAccountPageExits(),"Not existed..");
    }
}
