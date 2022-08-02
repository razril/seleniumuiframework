package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManagerAbstract {

    @Override
    protected void startDriver() {
        WebDriverManager.chromedriver().cachePath("drivers").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
