package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends CommonPartPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class='cart_quantity']";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "//button[contains(text(), 'Remove')]";
    private static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//*[@id='continue-shopping']");
    private static final By CHECKOUT_BUTTON = By.xpath("//*[@id='checkout']");

    public void openPage(String url) {
        driver.get(url);
    }

    public String getProductPrice(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_PRICE, productName), 10);
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public String getProductQuantity(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_QUANTITY, productName), 10);
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY, productName))).getText();
    }

    public void removeProductFromTheCart(String productName) {
        waitForElementDisplayed(String.format(REMOVE_BUTTON, productName), 10);
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
    }

    public void removeAllProductsFromTheCart() {
        String locator = REMOVE_BUTTON.substring(48);
        By locatorsToChooseAllRemoveButtons = By.xpath(locator);
        waitForElementsDisplayed(locatorsToChooseAllRemoveButtons, 10);
        List<WebElement> allProducts = driver.findElements(locatorsToChooseAllRemoveButtons);
        for (WebElement x : allProducts) {
            x.click();
        }
    }

    public void continueShopping() {
        waitForElementDisplayed(CONTINUE_SHOPPING_BUTTON, 10);
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void goToCheckout() {
        waitForElementDisplayed(CHECKOUT_BUTTON, 10);
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public int getNumberOfItems() {
        String locator = PRODUCT_PRICE.substring(48);
        By locatorToChooseAllItems = By.xpath(locator);
        try {
            waitForElementDisplayed(locatorToChooseAllItems, 10);
            List<WebElement> items = driver.findElements(locatorToChooseAllItems);
            return items.size();
        } catch (TimeoutException e){
            return 0;
        }
    }
}
