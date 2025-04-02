package testCases.Register;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_RF_009 extends BaseClass {

    @Test(dataProvider = "EmailData", dataProviderClass = DataProviders.class,groups = ("DataDriven"))
    public void verify_existing_account_details(String FirstName, String LastName, String E_Mail, String Telephone, String Password, String PasswordConfirm){
        logger.info("**TC_RF_009 test case started..**");
        try {
            HomePage hp=new HomePage(driver);
            hp.setLnkMyaccount();
            hp.setLnkRegister();

            AccountRegistrationPage arp=new AccountRegistrationPage(driver);
            arp.setTxtFirstName(FirstName);
            arp.setTxtLastName(LastName);
            arp.setTxtEmail(E_Mail);
            arp.setTxtTelephone(Telephone);
            arp.setTxtPassword(Password);
            arp.setTxtConfirmPassword(PasswordConfirm);
            arp.setClkSubscribe();
            arp.setClkAgree();
            arp.setBtnContinue();
            Thread.sleep(1000);
            Assert.assertTrue(arp.isTextDangerEmailExistsIsDisplayed(),"The email exists text is not displayed");
            System.out.println(FirstName+" "+LastName+" "+E_Mail+" "+Telephone+" "+Password+" "+PasswordConfirm);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        logger.info("**TC_RF_009 test case ended..**");
    }
}
