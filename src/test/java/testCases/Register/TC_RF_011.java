package testCases.Register;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_RF_011 extends BaseClass {
    @Test(dataProvider = "InvalidPhoneData", dataProviderClass = DataProviders.class,groups = ("DataDriven"))
    public void verify_invalid_phone_numbers(String Phone){
        logger.info("**TC_RF_011 test case started..**");
        try {
            HomePage hp=new HomePage(driver);
            hp.setLnkMyaccount();
            hp.setLnkRegister();

            AccountRegistrationPage arp=new AccountRegistrationPage(driver);
            arp.setTxtFirstName(randomString());
            arp.setTxtLastName(randomString());

            arp.setTxtEmail(randomString());

            Thread.sleep(1000);
            arp.setTxtTelephone(Phone);
            String validation_phone=arp.getPhoneNumberValidationMessage();
            System.out.println("Validation message: "+validation_phone);

            String password=randomAlphanumeric();
            arp.setTxtPassword(password);
            arp.setTxtConfirmPassword(password);
            arp.setClkSubscribe();
            arp.setClkAgree();
            arp.setBtnContinue();
            System.out.println(Phone);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        logger.info("**TC_RF_011 test case ended..**");
    }
}
