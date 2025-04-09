package testCases.Login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_001 extends BaseClass {

    @Test
    public void verify_valid_credentials(){
        HomePage hp=new HomePage(driver);
        hp.setLnkMyaccount();
        hp.setLnkLogin();

        LoginPage lp=new LoginPage(driver);
        lp.setLoginEmail(p.getProperty("email"));
        lp.setLoginpassword(p.getProperty("password"));
        lp.setBtnLogin();

        MyAccountPage map=new MyAccountPage(driver);
        Assert.assertTrue(map.isMyAccountPageExits(),"Not existed");
    }
}
