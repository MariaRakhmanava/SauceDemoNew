package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @Step("Getting a {productName} name on the {productName} Details Page")
    public String getProductItemName(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_ITEM_NAME, productName), 10);
        return driver.findElement(By.xpath(String.format(PRODUCT_ITEM_NAME, productName))).getText();
    }

    @Step("Getting a {productName} price on the {productName} Details Page")
    public String getProductPrice(String productName) {
        waitForElementDisplayed(productPrice, 10);
        return productPrice.getText();
    }

    @Step("Getting a {productName} description on the {productName} Details Page")
    public String getProductDescription(String productName) {
        waitForElementDisplayed(productDescription, 10);
        return productDescription.getText();
    }

    @Step("Adding a {productName} to the Shopping Cart from the {productName} Details Page")
    public ProductDetailsPage addProductToTheCart(String productName) {
        waitForElementDisplayed(addToCartButton, 10);
        addToCartButton.click();
        return this;
    }
}