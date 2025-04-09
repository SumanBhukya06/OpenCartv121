package testCases.Register;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_020 extends BaseClass {
    @Test
    public void verify_privacy_policy_default_checked() {
        logger.info("**TC_RF_020 started**");
        HomePage hp = new HomePage(driver);
        hp.setLnkMyaccount();
        hp.setLnkRegister();

        AccountRegistrationPage arp = new AccountRegistrationPage(driver);
        boolean isChecked=arp.isPrivacyPolicyChecked();
        System.out.println("Privacy policy checkbox status: "+isChecked);

        Assert.assertTrue(isChecked,"Privacy Policy checkbox should be checked by default but it's not.");
        logger.info("**TC_RF_020 ended...**");
    }
}
