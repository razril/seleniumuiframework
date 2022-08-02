package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //Wait Element Visibility Wrapper
    public WebElement waitVisibility(By elementBy) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    //Wait Element Clickable Wrapper
    public WebElement waitClickable(By elementBy) {
        return wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }
    //Click Method
    public void click(By elementBy) {
        waitClickable(elementBy).click();
    }
    //Write Text
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy).sendKeys(text);
    }
    //Read Text
    public String readText(By elementBy) {
        return waitVisibility(elementBy).getText();
    }

    /*
    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }

    public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAY SIZE" + overlays.size());
        if(overlays.size() > 0){
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAYS INVISIBLE");
        } else{
            System.out.println("OVERLAY NOT FOUND");
        }
    }
    */
}