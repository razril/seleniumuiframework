package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class OrangeHRMDashboardPage extends BasePage {
    // Page URL


    // Locators
    By headerTitle = By.xpath("//div[@class='head']/h1[text()='Dashboard']");


    // *********Constructor*********
    public OrangeHRMDashboardPage(WebDriver driver) {
        super(driver);
        assertEquals(readText(headerTitle), "Dashboard");
    }
}
