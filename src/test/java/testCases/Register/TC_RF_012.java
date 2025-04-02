package testCases.Register;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_012 extends BaseClass {
    @Test
    public void verify_ra_using_KeyBoard_actions(){
     logger.info("**TC_RF_010 test case started..**");
            try {
        HomePage hp=new HomePage(driver);
        hp.setLnkMyaccount();
        hp.setLnkRegister();

        AccountRegistrationPage arp=new AccountRegistrationPage(driver);
        Actions actions=new Actions(driver);

        actions.sendKeys(arp.setTxtFirstNameKey()).sendKeys(randomString()).sendKeys(Keys.TAB).perform();
        actions.sendKeys(arp.setTxtLastNameKey()).sendKeys(randomString()).sendKeys(Keys.TAB).perform();
        actions.sendKeys(arp.setTxtEmail1()).sendKeys(randomString()+"@gmail.com").sendKeys(Keys.TAB).perform();
        actions.sendKeys(arp.setTxtTelephone1()).sendKeys(randomNumber()).sendKeys(Keys.TAB).perform();
        String password=randomAlphanumeric();
        actions.sendKeys(arp.setTxtPassword1()).sendKeys(password).sendKeys(Keys.TAB);
        actions.sendKeys(arp.setTxtConfirmPassword1()).sendKeys(password).sendKeys(Keys.TAB);
        actions.sendKeys(Keys.SPACE).sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.SPACE).sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.SPACE).sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();
        String account_confirm_msz=arp.getConfirmationmsz();
        Assert.assertEquals(account_confirm_msz,"Your Account Has Been Created!");
    }
            catch (Exception e){
                logger.error("Test case failed due to issue occur: "+e.getMessage());
                Assert.fail("Test case failed due to issue occur");

    }
            logger.info("**TC_RF_010 test case ended..**");
}
}
