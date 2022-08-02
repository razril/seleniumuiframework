package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {
    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");

    /*public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    private ProductThumbnail productThumbnail;*/

    public StorePage(WebDriver driver) {
        super(driver);
        //productThumbnail = new ProductThumbnail(driver);
    }

    private StorePage enterTextInSearchFld(String txt){
        writeText(searchFld,txt);
        return this;
    }

    public StorePage load(){
        //load("/store");
        driver.get("https://askomdch.com/store/");
        return this;
    }

    public StorePage search(String txt){
        enterTextInSearchFld(txt).clickSearchBtn();
        return this;
    }

    private StorePage clickSearchBtn(){
        click(searchBtn);
        return this;
    }

    public String getTitle(){
        return readText(title);
    }
}

