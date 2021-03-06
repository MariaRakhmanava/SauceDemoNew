package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class ProductDetailsPage extends HeaderMenuPage {
    @FindBy(xpath = "//*[@class='inventory_details_price']")
    WebElement productPrice;

    @FindBy(css = ".inventory_details_desc")
    WebElement productDescription;

    @FindBy(xpath = "//*[contains(text(), 'Add to cart')]")
    WebElement addToCartButton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public static final String PRODUCT_ITEM_NAME = "//*[contains(text(), '%s')]";

    @Step("Get a {productName} name displayed on the {productName} details page")
    public String getProductItemName(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_ITEM_NAME, productName), 10);
        log.info(String.format("Get the item name of the product: '%s' displayed on the '%s' details page", productName, productName));
        return driver.findElement(By.xpath(String.format(PRODUCT_ITEM_NAME, productName))).getText();
    }

    @Step("Get a {productName} price displayed on the {productName} details page")
    public String getProductPrice(String productName) {
        waitForElementDisplayed(productPrice, 10);
        log.info(String.format("Get the price of the product: '%s' displayed on the '%s' details page", productName, productName));
        return productPrice.getText();
    }

    @Step("Get a {productName} description displayed on the {productName} details page")
    public String getProductDescription(String productName) {
        waitForElementDisplayed(productDescription, 10);
        log.info(String.format("Get the description of the product: '%s' \ndisplayed on the '%s' details page", productName, productName));
        return productDescription.getText();
    }

    @Step("Add a {productName} to the shopping cart from the {productName} details page")
    public ProductDetailsPage addProductToTheCart(String productName) {
        waitForElementDisplayed(addToCartButton, 10);
        log.info(String.format("Click the ADD TO CART button of the product: '%s' displayed on the '%s' details page", productName, productName));
        addToCartButton.click();
        return this;
    }
}