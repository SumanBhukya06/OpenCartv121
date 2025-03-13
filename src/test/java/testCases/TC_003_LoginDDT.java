package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
//import utilities.ExcelDataProvider;

public class TC_003_LoginDDT extends BaseClass {
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = ("DataDriven"))//added extra data providers , it is in separate class
    //@Test(dataProvider = "LoginData", dataProviderClass = utilities.ExcelDataProvider.class)
    public void verify_login_ddt(String email, String pwd, String exp) {
        logger.info("***TC_003_LoginDDT started***");
        try {
            //homepage
            HomePage hp = new HomePage(driver);
            logger.info("clicked on myaccount");
            hp.setLnkMyaccount();
            logger.info("clicked on login");
            hp.setLnkLogin();
            //Login page
            LoginPage lp = new LoginPage(driver);
            logger.info("email value entered");
            lp.setLoginEmail(email);
            logger.info("password value entered");
            lp.setLoginpassword(pwd);
            lp.setBtnLogin();
            //My account page
            MyAccountPage mac = new MyAccountPage(driver);
            boolean heading = mac.isMyAccountPageExits();

        /*
        Data is valid-- login success--test pass--log out
                        login failed-test fail
        Data is invalid-- login success--test fail--log out
                           login failed--test fail
         */

            if (exp.equalsIgnoreCase("Valid")) {
                if (heading == true) {
                    mac.setLnklogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }

            if (exp.equalsIgnoreCase("Invalid")) {
                if (heading == true) {
                    mac.setLnklogout();
                    Assert.assertTrue(false);

                } else {
                    Assert.assertTrue(true);
                }
            }
        }
        catch (Exception e){
            Assert.fail();
        }
        logger.info("The TC_003_LoginDDT ended");
    }
}
