package testCases.Register;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ExcelUtility;

import java.io.IOException;


public class TC_RF_003 extends BaseClass {

    @Test(groups = "Regression")
    public void verify_Registering_an_Account_by_providing_all_the_fields() throws IOException {
        logger.info("**TC_RF_003 test case started..**");
        ExcelUtility ul=new ExcelUtility("./testData/OpenCart-TestCases.xlsx");
        try {

            HomePage hp=new HomePage(driver);
            hp.setLnkMyaccount();
            hp.setLnkRegister();

            AccountRegistrationPage arp=new AccountRegistrationPage(driver);
            arp.setTxtFirstName(randomString());
            arp.setTxtLastName(randomString());
            arp.setTxtEmail(randomString()+"@gmail.com");
            arp.setTxtTelephone(randomNumber());
            String password=randomAlphanumeric();
            arp.setTxtPassword(password);
            arp.setTxtConfirmPassword(password);
            arp.setClkSubscribe();
            arp.setClkAgree();
            arp.setBtnContinue();
            String msz_confirm=arp.getConfirmationmsz();
            if (msz_confirm.equals("Your Account Has Been Created!")){
                Assert.assertTrue(true);
            }
            else {
                logger.error("Test failed");
                logger.debug("Debug logs");
                Assert.fail();
            }
            arp.setBtn_Continue_success();
            String expected_url="https://tutorialsninja.com/demo/index.php?route=account/account";
            Assert.assertTrue(driver.getCurrentUrl().equals(expected_url));
            ul.fillGreenColor("Register",4,9);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        logger.info("**TC_RF_003 test case ended..**");

    }
}
