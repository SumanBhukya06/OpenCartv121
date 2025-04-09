package testCases.Login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_004 extends BaseClass {

    @Test
    public void verify_valid_email_invalid_password(){
        HomePage hp=new HomePage(driver);
        hp.setLnkMyaccount();
        hp.setLnkLogin();

        LoginPage lp=new LoginPage(driver);
        lp.setLoginEmail(p.getProperty("email"));//valid email
        lp.setLoginpassword(p.getProperty("ipassword"));//invalid password
        lp.setBtnLogin();
        Assert.assertTrue(lp.isNoMatchEmailPassWordDisplayed(),"Not displayed");
    }
}
