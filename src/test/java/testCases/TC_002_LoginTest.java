package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

    @Test(groups = {"Sanity","Master"})
    public void verify_login(){
    logger.info("*** TC_002_LoginTest started***");
    //Homepage
    try {
    HomePage hp=new HomePage(driver);
    logger.info("***clicked on my account***");
    hp.setLnkMyaccount();
    logger.info("***clicked on login");
    hp.setLnkLogin();
    //Login page
    LoginPage lp=new LoginPage(driver);
    logger.info("*** entered email***");
    lp.setLoginEmail(p.getProperty("email"));
    logger.info("*** entered password***");
    lp.setLoginpassword(p.getProperty("password"));
    lp.setBtnLogin();
    //My account
    MyAccountPage myac=new MyAccountPage(driver);
    boolean headingexists=myac.isMyAccountPageExits();
    //Assert.assertEquals(headingexists,true,"Login failed");
    Assert.assertTrue(headingexists);
    }
    catch (Exception e) {
        Assert.fail();
    }
    }
}
