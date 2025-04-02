package testCases.Register;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_004 extends BaseClass {

    @Test(groups = "Regression")
    public void  verify_proper_notification_messages_ra(){
        logger.info("**TC_RF_004 started...**");
        try {
            logger.info("**Home page**");
            HomePage hp=new HomePage(driver);
            hp.setLnkMyaccount();
            hp.setLnkRegister();

            logger.info("**Account Reg Page**");
            AccountRegistrationPage arp=new AccountRegistrationPage(driver);
            arp.setBtnContinue();

            //validation
            String actual_firstNameDes="First Name must be between 1 and 32 characters!";
            Assert.assertTrue(arp.getfirstNameDes(),actual_firstNameDes);

            String actual_lastNameDes="Last Name must be between 1 and 32 characters!";
            Assert.assertTrue(arp.getlastNameDes(),actual_lastNameDes);

            String actual_emailDes="E-Mail Address does not appear to be valid!";
            Assert.assertTrue(arp.getEmailDes(),actual_emailDes);

            String actual_telePhoneDes="Telephone must be between 3 and 32 characters!";
            Assert.assertTrue(arp.getTelephoneDes(),actual_telePhoneDes);

            String actual_passwordDes="Password must be between 4 and 20 characters!";
            Assert.assertTrue(arp.getPasswordDes(),actual_passwordDes);

            String actual_policyDes="Warning: You must agree to the Privacy Policy!";
            Assert.assertTrue(arp.getPolicyDes(),actual_policyDes);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
