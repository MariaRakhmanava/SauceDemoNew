package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class ProductDetailsPage extends GeneralPartPage {

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

    public String getProductItemName(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_ITEM_NAME, productName), 10);
        return driver.findElement(By.xpath(String.format(PRODUCT_ITEM_NAME, productName))).getText();
    }

    public String getProductPrice(String productName) {
        waitForElementDisplayed(productPrice, 10);
        return productPrice.getText();
    }

    public String getProductDescription(String productName) {
        waitForElementDisplayed(productDescription, 10);
        return productDescription.getText();
    }

    public ProductDetailsPage addProductToTheCart(String productName) {
        waitForElementDisplayed(addToCartButton, 10);
        addToCartButton.click();
        return this;
    }
}
