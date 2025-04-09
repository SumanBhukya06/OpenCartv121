package testCases.Login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_003 extends BaseClass {

    @Test
    public void verify_Invalid_Email_Valid_Password(){
        HomePage hp=new HomePage(driver);
        hp.setLnkMyaccount();
        hp.setLnkLogin();

        LoginPage lp=new LoginPage(driver);
        lp.setLoginEmail(p.getProperty("iemail"));//invalid email
        lp.setLoginpassword(p.getProperty("password"));//valid password
        lp.setBtnLogin();
        Assert.assertTrue(lp.isNoMatchEmailPassWordDisplayed(),"Not displayed");
    }
}
