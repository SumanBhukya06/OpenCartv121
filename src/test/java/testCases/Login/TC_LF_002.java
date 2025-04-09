package testCases.Login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_002 extends BaseClass {

    @Test
    public void verify_invalid_credentials(){
        HomePage hp=new HomePage(driver);
        hp.setLnkMyaccount();
        hp.setLnkLogin();

        LoginPage lp=new LoginPage(driver);
        lp.setLoginEmail(p.getProperty("iemail"));
        lp.setLoginpassword(p.getProperty("ipassword"));
        lp.setBtnLogin();
        Assert.assertTrue(lp.isNoMatchEmailPassWordDisplayed(),"Not displayed");
    }
}
