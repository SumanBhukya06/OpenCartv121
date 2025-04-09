package testCases.Login;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

import java.util.HashMap;
import java.util.Map;

public class TC_LF_008 extends BaseClass{
    @Test
    public void verify_placeholder(){
        HomePage hp=new HomePage(driver);
        hp.setLnkMyaccount();
        hp.setLnkLogin();

        HashMap<WebElement, String> fieldPlaceHolders=new HashMap<WebElement,String>();
        LoginPage lp=new LoginPage(driver);
        fieldPlaceHolders.put(lp.LoginEmailKey(),"E-Mail Address");
        fieldPlaceHolders.put(lp.LoginPassWordKey(),"Password");
        for (Map.Entry<WebElement, String> entry : fieldPlaceHolders.entrySet()) {
            String actual_placeHolder=entry.getKey().getAttribute("placeholder");
            Assert.assertEquals(actual_placeHolder, entry.getValue(), "Placeholder mismatch");
            System.out.println("Verified placeHolder: "+actual_placeHolder);
        }
    }
}
