package pages;

import consts.IPagesUrls;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends HeaderMenuPage implements IPagesUrls {

    @FindBy(xpath = "//*[@class='cart_item']")
    List<WebElement> productsInTheCart;

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    List<WebElement> removeButtonsOfProductsInTheCart;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM = "//*[text()='%s']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "/ancestor::*[@class='cart_item']//*[@class='inventory_item_price']";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "/ancestor::*[@class='cart_item']//*[@class='cart_quantity']";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "/ancestor::*[@class='cart_item']//button[contains(text(), 'Remove')]";

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
        waitForElementsDisplayed(productsInTheCart, 10);
        for (WebElement removeButtonOfProductInTheCart : removeButtonsOfProductsInTheCart) {
            removeButtonOfProductInTheCart.click();
        }
        return this;
    }

    public ProductsPage clickContinueShoppingButton() {
        waitForElementDisplayed(continueShoppingButton, 10);
        continueShoppingButton.click();
        return new ProductsPage(driver);
    }

    public CheckoutCustomerInformationPage clickCheckoutButton() {
        waitForElementDisplayed(checkoutButton, 10);
        checkoutButton.click();
        return new CheckoutCustomerInformationPage(driver);
    }

    public int getNumberOfItems() {
        try {
            waitForElementsDisplayed(productsInTheCart, 10);
            return productsInTheCart.size();
        } catch (TimeoutException e){
            return 0;
        }
    }

    public List<String> getListOfProductsAddedToCart() {
        By locatorToChooseAllItems = By.xpath(PRODUCT_ITEM);
        try {
            waitForElementsDisplayed(locatorToChooseAllItems, 10);
            List<WebElement> items = driver.findElements(locatorToChooseAllItems);
            List<String> productsNames = new ArrayList<>();
            for (WebElement product : items) {
                productsNames.add(product.getText());
            }
            return productsNames;
        } catch (TimeoutException e){
            List<String> emptyList = new ArrayList<>();
            return emptyList;
        }
    }
}