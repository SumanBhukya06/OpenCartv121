package testCases.Register;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.newsLetterPage;
import testBase.BaseClass;

public class TC_RF_005 extends BaseClass {
    @Test
    public void verify_Registering_when_yes_option_selected_Newsletter_field() {
        logger.info("**TC_RF_005 test case started..**");
        try {
            HomePage hp = new HomePage(driver);
            hp.setLnkMyaccount();
            hp.setLnkRegister();

            AccountRegistrationPage arp = new AccountRegistrationPage(driver);
            arp.setTxtFirstName(randomString());
            arp.setTxtLastName(randomString());
            arp.setTxtEmail(randomString() + "@gmail.com");
            arp.setTxtTelephone(randomNumber());
            String password = randomAlphanumeric();
            arp.setTxtPassword(password);
            arp.setTxtConfirmPassword(password);
            arp.setClkSubscribe();
            arp.setClkAgree();
            arp.setBtnContinue();
            String msz_confirm = arp.getConfirmationmsz();
            if (msz_confirm.equals("Your Account Has Been Created!")) {
                Assert.assertTrue(true);
            } else {
                logger.error("Test failed");
                logger.debug("Debug logs");
                Assert.fail();
            }
            arp.setBtn_Continue_success();
            String expected_url = "https://tutorialsninja.com/demo/index.php?route=account/account";
            Assert.assertTrue(driver.getCurrentUrl().equals(expected_url));
            //My account page
            MyAccountPage map=new MyAccountPage(driver);
            map.setBtn_subscribe_Unsubscribe();

            //news letter page
            newsLetterPage nlp=new newsLetterPage(driver);
            nlp.setRadio_sub_unsub();
            nlp.setBtn_continue_nl();

            String actual_sub_text="Success: Your newsletter subscription has been successfully updated!";
            Assert.assertTrue(map.getSubscriptionIsDisplayed(),actual_sub_text);

        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("**TC_RF_005 test case ended..**");
    }
}

