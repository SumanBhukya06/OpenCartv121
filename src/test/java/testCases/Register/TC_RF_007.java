package testCases.Register;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_RF_007 extends BaseClass {

    @Test
    public void verify_different_ways_of_navigating_ra(){
        logger.info("**TC_RF_007 test case started..**");
        try {
            //homepage
            HomePage hp=new HomePage(driver);
            hp.setLnkMyaccount();
            hp.setLnkRegister();
            hp.setLnkMyaccount();
            hp.setLnkLogin();
            LoginPage lp=new LoginPage(driver);
            lp.setNew_cus_continue_btn();
            AccountRegistrationPage arp=new AccountRegistrationPage(driver);
            Assert.assertTrue(arp.isRegisterAccountIsDisplayed());
            hp.setLnkMyaccount();
            hp.setLnkLogin();
            lp.setRegister_btn_right_col();
            Assert.assertTrue(arp.isRegisterAccountIsDisplayed());
        }
        catch (Exception e){
            logger.error("Test case failed due to exception: " + e.getMessage());
            Assert.fail("Test case failed due to exception.");
        }
    }
}
