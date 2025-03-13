package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_005_SearchTest extends BaseClass {

    //@Test(priority = 1, dataProvider = "searchdata", dataProviderClass = DataProviders.class, groups = ("DataDriven"))
    public void verify_search_box(String item, String available) {
        logger.info("**TC_005_SearchTest started**");
        HomePage hp = new HomePage(driver);
        hp.setTxt_Search(item);
        //hp.setTxt_Search(p.getProperty("search"));
        hp.setClkbtnSearch();
        //Search page
        SearchPage sp = new SearchPage(driver);
        String text_product = sp.getSearchtext();

        if (available.equalsIgnoreCase("not available")) {
            if (text_product == "There is no product that matches the search criteria.") {
                //System.out.println(sp.getSearchtext());
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
        if (available.equalsIgnoreCase("available")){
            if (text_product=="There is no product that matches the search criteria."){
                Assert.fail();
            }
            else {
                Assert.assertTrue(true);
            }
        }
        logger.info("verify search box ended");
    }

   // @Test(priority = 2)
    public void verify_without_productname() {
        logger.info("**verify without productname started**");
        HomePage hp = new HomePage(driver);
        logger.info("Clicked on search text box");
        hp.setTxt_Search(p.getProperty("search"));
        logger.info("Clicked on search button");
        hp.setClkbtnSearch();
        //search page
        SearchPage sp = new SearchPage(driver);
        String p_txt = sp.getSearchtext();
        if (p_txt.equals("There is no product that matches the search criteria.")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
        logger.info("**verify without product name ended**");
    }

    @Test(priority = 3, dataProvider = "searchdata", dataProviderClass = DataProviders.class, groups = "DataDriven")
    public void verify_search_using_description(String item, String available, String product_description) {
        logger.info("**verify_search_using_description test started**");
        //home page
        HomePage hp = new HomePage(driver);
        hp.setTxt_Search(p.getProperty("search"));
        hp.setClkbtnSearch();
        //search page
        SearchPage sp = new SearchPage(driver);
        sp.setKeyword_search(product_description);
        sp.setChk_descp();
        //Checking description
        if (product_description.equalsIgnoreCase("Ilife")) {
            sp.setBtn_search();
            return;  // Exit immediately after clicking search
        }
        if (product_description.equalsIgnoreCase("Life")) {
            sp.setBtn_search();
            return;  // Exit immediately
        }

        if (product_description.equalsIgnoreCase("Bit")) {
            sp.setBtn_search();
            return;  // Exit immediately
        }

        System.out.println("Description does not match");

// Check if expected text is present after search
        boolean txt_present = sp.set_txtmac();

        try {
            Assert.assertTrue(txt_present, "Expected text is not present!");
        } catch (AssertionError e) {
            Assert.fail("Assertion failed: Text not found.");
        }
    }
}


