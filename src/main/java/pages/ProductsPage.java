package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends HeaderPage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//*[text()='Add to cart']";
    public static final String REMOVE_PRODUCT_FROM_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item_description']//*[text()='Remove']";
    public static final String PRODUCT_PRICE = "//*[contains(text(),'%s')]/ancestor::*[@class='inventory_item_description']//*[@class='inventory_item_price']";
    public static final String PRODUCT_SPECIFICATION_LINK = "//*[text()='%s']";
    public static final String PRODUCT_DESCRIPTION = "//*[contains(text(),'%s')]/ancestor::*[@class='inventory_item_description']//*[@class='inventory_item_desc']";


    public void openPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    public void addProductToTheCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
    }

    public void addAllProductsToTheCart() {
        List<WebElement> allProducts = driver.findElements(By.xpath("//button[contains(text(), 'Add to cart')]"));
        for (WebElement x : allProducts) {
            x.click();
        }
    }

    public void removeProductFromTheCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).click();
    }

    public void removeAllProductsFromTheCart() {
        List<WebElement> allProducts = driver.findElements(By.xpath("//button[contains(text(), 'Remove')]"));
        for (WebElement x : allProducts) {
            x.click();
        }
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public String getProductDescription(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_DESCRIPTION, productName))).getText();
    }

    public void goToProductSpecificationPage(String productName) {
        driver.findElement(By.xpath(String.format(PRODUCT_SPECIFICATION_LINK, productName))).click();
    }

    public int getTheNumberOfProductsOffered() {
        List<WebElement> products = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
        return products.size();
    }
}
