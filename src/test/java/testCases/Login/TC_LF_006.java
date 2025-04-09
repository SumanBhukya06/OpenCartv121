package testCases.Login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_006 extends BaseClass {
    @Test
    public void verify_Forgotten_Pwd_link(){
        HomePage hp=new HomePage(driver);
        hp.setLnkMyaccount();
        hp.setLnkLogin();

        LoginPage lp=new LoginPage(driver);
        try {
            Assert.assertTrue(lp.isForgottenPwdDisplayed(),"Forgotten password link is not clickable");
            Thread.sleep(2000);
        }catch (Exception e){
            logger.error("Failed due to an exception: "+e.getMessage());
            Assert.fail("Failed due to an issue occur..");
        }
    }
}
