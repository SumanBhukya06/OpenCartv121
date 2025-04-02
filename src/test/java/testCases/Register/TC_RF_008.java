package testCases.Register;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_008 extends BaseClass {

    @Test
    public void verify_password_field_entering_different_pwd() {
        logger.info("**TC_RF_003 test case started..**");
        try {
            HomePage hp = new HomePage(driver);
            hp.setLnkMyaccount();
            hp.setLnkRegister();

            AccountRegistrationPage arp = new AccountRegistrationPage(driver);
            arp.setTxtFirstName(randomString());
            arp.setTxtLastName(randomString());
            arp.setTxtEmail(randomString() + "@gmail.com");
            arp.setTxtTelephone(randomNumber());

            arp.setTxtPassword(randomAlphanumeric());
            arp.setTxtConfirmPassword(randomAlphanumeric());

            arp.setClkSubscribe();
            arp.setClkAgree();
            arp.setBtnContinue();
            Assert.assertTrue(arp.isTextDangerPwdMismatchDisplayed(),"password confirm not displayed");
        } catch (Exception e) {
            logger.error("Test case failed due to " + e.getMessage());
            Assert.fail("Test case failed due to an exception");
        }
        logger.info("**TC_RF_003 test case ended..**");
    }
}

