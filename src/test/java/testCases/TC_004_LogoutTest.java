package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_004_LogoutTest extends BaseClass {
    @Test(groups = {"Sanity","Master"})
    public void verify_logout(){
        logger.info("***verify logout test is stated");
        try {
            //Home page
            logger.info("**Homepage methods**");
            HomePage hp=new HomePage(driver);
            logger.info("clicked on my account");
            hp.setLnkMyaccount();
            logger.info("clicked on login");
            hp.setLnkLogin();
            logger.info("Login page methods");
            //Login page
            LoginPage lp=new LoginPage(driver);
            logger.info("email text");
            lp.setLoginEmail(p.getProperty("email"));
            logger.info("pwd text");
            lp.setLoginpassword(p.getProperty("password"));
            logger.info("clicked on login");
            lp.setBtnLogin();
            //my account page
            logger.info("***Myaccount page methods*");
            MyAccountPage myacc=new MyAccountPage(driver);
            //myacc.setLnkMyAccount();
            logger.info("clicked on my account");
            hp.setLnkMyaccount();
            logger.info("clicked on logout");
            myacc.setMyALogout();
            logger.info("**Logout page methods**");
            //Logout page
            LogoutPage lo=new LogoutPage(driver);

            boolean logout_txt=lo.isAccountLogoutexists();
            Assert.assertTrue(logout_txt);
            logger.info("clicked on my account");
            hp.setLnkMyaccount();

            boolean isLotext=hp.setLnkLogin1();
            Assert.assertTrue(isLotext);
            logger.info("clicked on continue");
            lo.setLgbtnContinue();

            String url1=hp.setpageURL();
            if (url1.equalsIgnoreCase(p.getProperty("appURL"))){
                Assert.assertTrue(true);
            }
            else {
                Assert.fail();
            }
        }catch (Exception e){
            Assert.fail();
        }
        logger.info("**verify logout test is finished**");
    }

}
