package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends HeaderPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class='cart_quantity']";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "//button[contains(text(), 'Remove')]";
    private static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//*[@id='continue-shopping']");
    private static final By CHECKOUT_BUTTON = By.xpath("//*[@id='checkout']");

    public void openPage() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public String getProductQuantity(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY, productName))).getText();
    }

    public void removeProductFromTheCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
    }

    public void removeAllProductsFromTheCart() {
        List<WebElement> allProducts = driver.findElements(By.xpath("//button[contains(text(), 'Remove')]"));
        for (WebElement x : allProducts) {
            x.click();
        }
    }

    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void goToCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public int getNumberOfItems() {
        List<WebElement> items = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
        return items.size();
    }
}
