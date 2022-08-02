package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StorePage;

import static org.testng.Assert.assertEquals;

public class SearchTest extends BaseTest {

    @Test
    public void searchWithPartialMatch(){

        String searchFor = "Blue";

        StorePage storePage = new StorePage(getDriver()).
                load().
                search(searchFor);

        waitForPageToLoad();
        assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");

    }
}
