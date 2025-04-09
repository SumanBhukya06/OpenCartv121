package testCases.Register;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

import java.util.HashMap;
import java.util.Map;

public class TC_RF_013 extends BaseClass {

    @Test
    public void verify_place_holders(){
            logger.info("**TC_RF_013 test case started..**");
            try {
                HomePage hp=new HomePage(driver);
                hp.setLnkMyaccount();
                hp.setLnkRegister();

                Map<WebElement, String> fieldPlaceHolders=new HashMap<>();
                AccountRegistrationPage arp=new AccountRegistrationPage(driver);
                fieldPlaceHolders.put(arp.setTxtFirstNameKey(),"First Name");
                fieldPlaceHolders.put(arp.setTxtLastNameKey(),"Last Name");
                fieldPlaceHolders.put(arp.setTxtEmail1(),"E-Mail");
                fieldPlaceHolders.put(arp.setTxtTelephone1(),"Telephone");
                fieldPlaceHolders.put(arp.setTxtPassword1(),"Password");
                fieldPlaceHolders.put(arp.setTxtConfirmPassword1(),"Password Confirm");
                for (Map.Entry<WebElement, String> entry : fieldPlaceHolders.entrySet()) {
                    String actualPlaceholder = entry.getKey().getAttribute("placeholder");
                    Assert.assertEquals(actualPlaceholder, entry.getValue(), "Placeholder mismatch");
                    System.out.println("Verified placeholder: " + actualPlaceholder);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            logger.info("**TC_RF_013 test case ended..**");
        }
    }
