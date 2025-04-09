package testCases.Register;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.util.List;

public class TC_RF_025 extends BaseClass {

    @Test
    public void verify_page_text(){
        HomePage hp=new HomePage(driver);
        hp.setLnkMyaccount();
        hp.setLnkRegister();

        String current_url="https://tutorialsninja.com/demo/index.php?route=account/register";
        String current_page_title="Register Account";
        Assert.assertEquals(current_url,driver.getCurrentUrl());
        Assert.assertEquals(current_page_title,driver.getTitle());

        AccountRegistrationPage arp=new AccountRegistrationPage(driver);
        //Assert.assertTrue(arp.isAccountCrumbDisplayed(),"Not displayed");
        //Assert.assertTrue(arp.isRegisterCrumbDisplayed(),"Not displayed");

        List<WebElement> b_list=arp.isBreadCrumbVisible();
        System.out.println(b_list.size());
        boolean registerFound=false;
        boolean accountFound=false;
        for (WebElement ls:b_list){
            String text=ls.getText().trim();
            System.out.println("BreadCrumbText: "+text);
            if (text.equalsIgnoreCase("Register")){
                registerFound=true;
            }
            if (text.equalsIgnoreCase("Account")){
                accountFound=true;
            }
        }
        if (accountFound && registerFound){
            System.out.println("Both the crumbs found");
        }
        else {
            Assert.fail("Both the crumbs not found");
            logger.error("crumbs were not found");
        }
    }
}
