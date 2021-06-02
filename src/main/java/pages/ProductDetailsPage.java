package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends GeneralPartPage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public static final String PRODUCT_ITEM_NAME = "//*[contains(text(), '%s')]";
    public static final By PRODUCT_PRICE = By.xpath("//*[@class='inventory_details_price']");
    public static final By PRODUCT_DESCRIPTION = By.cssSelector(".inventory_details_desc");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//*[contains(text(), 'Add to cart')]");

    @Override
    public void openPage(String url) {
        driver.get(url);
    }

    public String getProductItemName(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_ITEM_NAME, productName), 7);
        return driver.findElement(By.xpath(String.format(PRODUCT_ITEM_NAME, productName))).getText();
    }

    public String getProductPrice(String productName) {
        waitForElementDisplayed(PRODUCT_PRICE, 7);
        return driver.findElement(PRODUCT_PRICE).getText();
    }

    public String getProductDescription(String productName) {
        waitForElementDisplayed(PRODUCT_DESCRIPTION, 7);
        return driver.findElement(PRODUCT_DESCRIPTION).getText();
    }

    public void addProductToTheCart(String productName) {
        waitForElementDisplayed(ADD_TO_CART_BUTTON, 7);
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }
}
