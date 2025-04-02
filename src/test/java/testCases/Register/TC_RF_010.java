package testCases.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_RF_010 extends BaseClass {
    @Test(dataProvider = "InvalidEmailData", dataProviderClass = DataProviders.class,groups = ("DataDriven"))
    public void verify_invalid_email_addresses(String E_Mail){
            logger.info("**TC_RF_010 test case started..**");
            try {
                HomePage hp=new HomePage(driver);
                hp.setLnkMyaccount();
                hp.setLnkRegister();

                AccountRegistrationPage arp=new AccountRegistrationPage(driver);
                arp.setTxtFirstName(randomString());
                arp.setTxtLastName(randomString());

                arp.setTxtEmail(E_Mail);
                String validationMsg=arp.getEmailValidationMessage();
                System.out.println("Validation Message: " + validationMsg);

                Thread.sleep(1000);
                arp.setTxtTelephone(randomNumber());
                String password=randomAlphanumeric();
                arp.setTxtPassword(password);
                arp.setTxtConfirmPassword(password);
                arp.setClkSubscribe();
                arp.setClkAgree();
                arp.setBtnContinue();
                System.out.println(E_Mail);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            logger.info("**TC_RF_010 test case ended..**");
        }
    }
