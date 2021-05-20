package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductSpecificationPage extends HeaderPage {

    public ProductSpecificationPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM_NAME = "//*[contains(text(), '%s')]";
    private static final By PRODUCT_PRICE = By.xpath("//*[@class='inventory_details_price']");
    private static final By PRODUCT_DESCRIPTION = By.cssSelector(".inventory_details_desc ");
    private static final By ADD_TO_CART_BUTTON = By.xpath("//*[contains(text(), 'Add to cart')]");

    public String getProductItemName(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_ITEM_NAME, productName))).getText();
    }

    public String getProductPrice() {
        return driver.findElement(PRODUCT_PRICE).getText();
    }

    public String getProductDescription() {
        return driver.findElement(PRODUCT_DESCRIPTION).getText();
    }

    public void addProductToTheCart() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

}
