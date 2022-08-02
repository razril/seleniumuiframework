package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class OrangeHRMLoginPage extends BasePage {
    // Page URL
    private static String pageURL = "https://opensource-demo.orangehrmlive.com/";

    // Locators
    By usernameField = By.xpath("//input[@id='txtUsername']");
    By passwordField = By.xpath("//input[@id='txtPassword']");
    By loginBtn = By.xpath("//input[@id='btnLogin']");
    By loginErrMsg = By.xpath("//span[@id='spanMessage']");

    // *********Constructor*********
    public OrangeHRMLoginPage(WebDriver driver) {
        super(driver);
        driver.get(pageURL);
    }

    // Page Methods

    public OrangeHRMDashboardPage doValidLogin(String username, String password) {
        // Enter Username
        writeText(usernameField, username);
        // Enter Password
        writeText(passwordField, password);
        // Click Login Button
        click(loginBtn);
        return new OrangeHRMDashboardPage(driver);
    }

    public OrangeHRMLoginPage doInvalidLogin(String username, String password) {
        // Enter Username
        writeText(usernameField, username);
        // Enter Password
        writeText(passwordField, password);
        // Click Login Button
        click(loginBtn);
        return this;
    }


    // Verify Login Error Message
    public OrangeHRMLoginPage verifyLoginErrMsg(String expectedText) {
        assertEquals(getErrMsg(), expectedText);
        return this;
    }

    public String getErrMsg() {
        return readText(loginErrMsg);

    }
}
