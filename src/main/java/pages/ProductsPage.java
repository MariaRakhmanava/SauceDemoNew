package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends CommonPartPage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//*[contains(text(),'Add to cart')]";
    private static final String REMOVE_PRODUCT_FROM_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item_description']//*[contains(text(),'Remove')]";
    private static final String PRODUCT_PRICE = "//*[contains(text(),'%s')]/ancestor::*[@class='inventory_item_description']//*[@class='inventory_item_price']";
    private static final String PRODUCT_SPECIFICATION_LINK = "//*[text()='%s']";
    private static final String PRODUCT_DESCRIPTION = "//*[contains(text(),'%s')]/ancestor::*[@class='inventory_item_description']//*[@class='inventory_item_desc']";
    private static final By SORTING_PRINCIPLE_DROPDOWN_MENU = By.xpath("//select[@class='product_sort_container']");


    public void openPage(String url) {
        driver.get(url);
    }

    public void addProductToTheCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
    }

    public void addAllProductsToTheCart() {
        String locatorToChooseAllAddToCartButtons = ADD_PRODUCT_TO_CART_BUTTON.substring(53);
        List<WebElement> allProducts = driver.findElements(By.xpath(locatorToChooseAllAddToCartButtons));
        for (WebElement x : allProducts) {
            x.click();
        }
    }

    public void removeProductFromTheCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).click();
    }

    public void removeAllProductsFromTheCart() {
        String locatorToAllRemoveButtons = REMOVE_PRODUCT_FROM_CART_BUTTON.substring(65);
        List<WebElement> allProducts = driver.findElements(By.xpath(locatorToAllRemoveButtons));
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
        final String locatorToAllProducts = PRODUCT_DESCRIPTION.substring(75);
        List<WebElement> products = driver.findElements(By.xpath(locatorToAllProducts));
        return products.size();
    }

    public void setProductsSorting(String sortingPrinciple) {
        Select sortingOptions = new Select(driver.findElement(SORTING_PRINCIPLE_DROPDOWN_MENU));
        switch(sortingPrinciple){
            case "Name (Z to A)":
                sortingOptions.selectByVisibleText("Name (Z to A)");
                break;
            case "Price (low to high)":
                sortingOptions.selectByVisibleText("Price (low to high)");
                break;
            case "Price (high to low)":
                sortingOptions.selectByVisibleText("Price (high to low)");
                break;
            default:
                sortingOptions.selectByVisibleText("Name (A to Z)");
        }
    }
}
