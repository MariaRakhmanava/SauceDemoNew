package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static consts.iURLsOfPages.CART_PAGE_URL;

public class CartPage extends GeneralPartPage {

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class='cart_quantity']";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "//button[contains(text(), 'Remove')]";

    public CartPage openPage() {
        super.openPage(CART_PAGE_URL);
        return this;
    }

    public String getProductPrice(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_PRICE, productName), 10);
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public String getProductQuantity(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_QUANTITY, productName), 10);
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY, productName))).getText();
    }

    public CartPage removeProductFromTheCart(String productName) {
        waitForElementDisplayed(String.format(REMOVE_BUTTON, productName), 10);
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
        return this;
    }

    public CartPage removeAllProductsFromTheCart() {
        String locator = REMOVE_BUTTON.substring(48);
        By locatorsToChooseAllRemoveButtons = By.xpath(locator);
        waitForElementsDisplayed(locatorsToChooseAllRemoveButtons, 10);
        List<WebElement> allProducts = driver.findElements(locatorsToChooseAllRemoveButtons);
        for (WebElement x : allProducts) {
            x.click();
        }
        return this;
    }

    public ProductsPage continueShopping() {
        waitForElementDisplayed(continueShoppingButton, 10);
        continueShoppingButton.click();
        return new ProductsPage(driver);
    }

    public CheckoutCustomerInformationPage goToCheckout() {
        waitForElementDisplayed(checkoutButton, 10);
        checkoutButton.click();
        return new CheckoutCustomerInformationPage(driver);
    }

    public int getNumberOfItems() {
        String locator = PRODUCT_PRICE.substring(48);
        By locatorToChooseAllItems = By.xpath(locator);
        try {
            waitForElementsDisplayed(locatorToChooseAllItems, 10);
            List<WebElement> items = driver.findElements(locatorToChooseAllItems);
            return items.size();
        } catch (TimeoutException e){
            return 0;
        }
    }
}
