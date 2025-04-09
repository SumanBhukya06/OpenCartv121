package testCases.Login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_005 extends BaseClass {
    @Test
    public void verify_without_providing_credentials(){
        HomePage hp=new HomePage(driver);
        hp.setLnkMyaccount();
        hp.setLnkLogin();

        LoginPage lp=new LoginPage(driver);
        lp.setLoginEmail("");
        lp.setLoginpassword("");
        lp.setBtnLogin();
        Assert.assertTrue(lp.isNoMatchEmailPassWordDisplayed(),"Not displayed");
    }
}
