package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LG_002 extends BaseClass {
    @Test(priority = 1)
    public void verify_logout_2() {
        HomePage hp = new HomePage(driver);
        hp.setLnkMyaccount();
        hp.setLnkLogin();

        LoginPage lp = new LoginPage(driver);
        lp.setLoginEmail(p.getProperty("email"));
        lp.setLoginpassword(p.getProperty("password"));
        lp.setBtnLogin();

    }
    @Test(priority = 2)
    public void verify_persistance() throws InterruptedException {
        driver.quit();
        //Thread.sleep(2000);
        WebDriver driver;
        driver=new ChromeDriver();
        //Thread.sleep(3000);
        driver.get(p.getProperty("appURL"));
        driver.quit();
    }
}