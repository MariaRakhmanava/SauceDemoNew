package pages;

import consts.IPagesUrls;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


@Log4j2
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

    @Step("Open the cart page")
    public CartPage openPage() {
        log.info("Open the cart page");
        super.openPage(CART_PAGE_URL);
        return this;
    }

    @Step("Get the {productName} price displayed on the cart page")
    public String getProductPrice(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_PRICE, productName), 10);
        log.info(String.format("Get the price of: '%s' displayed on the cart page", productName));
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    @Step("Get the number of {productName} displayed on the cart page")
    public String getProductQuantity(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_QUANTITY, productName), 10);
        log.info(String.format("Get the quantity of: '%s' displayed on the cart page", productName));
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY, productName))).getText();
    }

    @Step("Remove {productName} from the shopping cart on the cart page")
    public CartPage removeProductFromTheCart(String productName) {
        waitForElementDisplayed(String.format(REMOVE_BUTTON, productName), 10);
        log.info(String.format("Click the REMOVE button of: '%s' from the cart", productName));
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
        return this;
    }

    @Step("Remove all products from the shopping cart on the cart page")
    public CartPage removeAllProductsFromTheCart() {
        waitForElementsDisplayed(productsInTheCart, 10);
        log.info("Click the REMOVE button of all products displayed on the cart page");
        for (WebElement removeButtonOfProductInTheCart : removeButtonsOfProductsInTheCart) {
            removeButtonOfProductInTheCart.click();
        }
        return this;
    }

    public ProductsPage clickContinueShoppingButton() {
        waitForElementDisplayed(continueShoppingButton, 10);
        log.info("Click the CONTINUE button on the cart page");
        continueShoppingButton.click();
        return new ProductsPage(driver);
    }

    public CheckoutCustomerInformationPage clickCheckoutButton() {
        waitForElementDisplayed(checkoutButton, 10);
        log.info("Click the CHECKOUT button displayed on the cart page");
        checkoutButton.click();
        return new CheckoutCustomerInformationPage(driver);
    }

    @Step("Get the number of products that have been added to the shopping cart from the cart page")
    public int getNumberOfItems() {
        log.info("Get the products' array list size on the cart page");
        try {
            waitForElementsDisplayed(productsInTheCart, 10);
            return productsInTheCart.size();
        } catch (TimeoutException e){
            return 0;
        }
    }

    @Step("Get the list of products' names that have been added to the shopping cart from the cart page")
    public List<String> getListOfProductsAddedToCart() {
        By locatorToChooseAllProducts = By.xpath(PRODUCT_ITEM);
        try {
            waitForElementsDisplayed(locatorToChooseAllProducts, 10);
            log.info("Find web elements: products on the cart page by locator: " + PRODUCT_ITEM + "and collect them into the array list: products");
            List<WebElement> products = driver.findElements(locatorToChooseAllProducts);
            log.info("Create an array list: products names");
            List<String> productsNames = new ArrayList<>();
            log.info("Extract products' names from the array list of web elements: products to the array list: products names");
            for (WebElement product : products) {
                productsNames.add(product.getText());
            }
            return productsNames;
        } catch (TimeoutException e){
            log.warn("Time is out, no products have been found so an empty array list for products has been created");
            List<String> emptyList = new ArrayList<>();
            return emptyList;
        }
    }
}