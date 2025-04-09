package testCases.Register;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_024 extends BaseClass {

    @Test
    public void verify_password_confirm_message(){
        logger.info("**TC_RF_024 test case started..**");
        try {
            HomePage hp = new HomePage(driver);
            hp.setLnkMyaccount();
            hp.setLnkRegister();

            AccountRegistrationPage arp = new AccountRegistrationPage(driver);
            arp.setTxtFirstName(randomString());
            arp.setTxtLastName(randomString());
            arp.setTxtEmail(randomString() + "@gmail.com");
            arp.setTxtTelephone(randomNumber());
            arp.setTxtPassword("12345a");
            arp.setTxtConfirmPassword("12345");
            arp.setClkSubscribe();
            arp.setClkAgree();
            arp.setBtnContinue();
            Assert.assertTrue(arp.isPasswordConfirmMessageDisplayed(),"The confirmation not displayed.");
        } catch (Exception e) {
            logger.error("Test case failed due to " + e.getMessage());
            Assert.fail("Test case failed due to an exception");
        }
        logger.info("**TC_RF_024 test case ended..**");
    }
}
