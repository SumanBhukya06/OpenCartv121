package testCases.Register;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.util.List;

public class TC_RF_023 extends BaseClass {
    @Test
    public void verify_links_on_reg_page() throws InterruptedException {
        HomePage hp=new HomePage(driver);
        hp.setLnkMyaccount();
        hp.setLnkRegister();

        AccountRegistrationPage arp=new AccountRegistrationPage(driver);
        arp.setPrivacy_policy_link();
        arp.setPrivacy_policy_popup();

        List<WebElement> link_texts=arp.setRightColText();
        System.out.println("Number of links: "+link_texts.size());
        for (int i=0;i<link_texts.size();i++){
            WebElement link=link_texts.get(i);
            String link_text=link.getText();
            //skip the register link
            if(link_text.equalsIgnoreCase("Register")){
                System.out.println("skipping 'Register page' we're already on the page.");
                continue;
            }
            System.out.println("Clicking on link:"+link_text);
            link.click();
            Thread.sleep(2000);
            System.out.println("Current URL after clicking"+driver.getCurrentUrl());
            driver.navigate().back();
            link_texts=arp.setRightColText();//re-locate links after coming back
        }
    }
}
