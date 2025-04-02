package pageObjects;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class newsLetterPage extends BasePage{
    public newsLetterPage(WebDriver driver){
        super(driver);
    }
    //locators
    @FindBy(xpath = "//input[@value='1']")
    WebElement radio_sub_unsub;

    @FindBy(xpath = "//input[@value='0']")
    WebElement radio_sub_unsub_no;

    @FindBy(xpath = "//input[@value='Continue']") WebElement btn_continue_nl;
    //yes
    public void setRadio_sub_unsub(){
        radio_sub_unsub.click();
    }
    //No
    public void setRadio_sub_unsub_no(){
        radio_sub_unsub_no.click();
    }

    public void setBtn_continue_nl(){
        btn_continue_nl.click();
    }
}
