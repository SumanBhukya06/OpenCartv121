package testCases.Register;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_RF_021 extends BaseClass {

    @Test
    public void verify_account_without_selecting_privacy_policy(){
            logger.info("**TC_RF_021 test case started..**");
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
                arp.setBtnContinue();
                String danger_text=arp.isPrivacyPolicyTextDangerVisible();
                System.out.println(danger_text);
                if (danger_text.equals("Warning: You must agree to the Privacy Policy!")){
                    Assert.assertTrue(true);
                }
                else {
                    Assert.fail();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            logger.info("**TC_RF_021 test case ended..**");
        }
    }
