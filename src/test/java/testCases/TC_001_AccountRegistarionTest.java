package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.time.Duration;

public class TC_001_AccountRegistarionTest extends BaseClass {

    @Test(groups = {"Regression","Master"})
    public void verify_Account_registration()
    {
        logger.info("*** TC_001_AccountRegistarionTest started....***");

        HomePage hp=new HomePage(driver);
        logger.info("***clicked on my account....***");
        hp.setLnkMyaccount();
        logger.info("***clicked on register....***");
        hp.setLnkRegister();

        AccountRegistrationPage ac_register=new AccountRegistrationPage(driver);
        logger.info("***New customer details....***");
        ac_register.setTxtFirstName(randomString());
        ac_register.setTxtLastName(randomString());
        ac_register.setTxtEmail(randomString()+"@gmail.com");
        ac_register.setTxtTelephone(randomNumber());

        String password=randomAlphanumeric();
        ac_register.setTxtPassword(password);
        ac_register.setTxtConfirmPassword(password);

        ac_register.setClkSubscribe();
        ac_register.setClkAgree();
        ac_register.setBtnContinue();
        String msz_confirm=ac_register.getConfirmationmsz();
        //Assert.assertEquals(msz_confirm,"Your Account Has Been Created!");
        if (msz_confirm.equals("Your Account Has Been Created!")){
            Assert.assertTrue(true);
        }
        else {
            logger.error("Test failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }
}
