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
        waitForElementDisplayed(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName), 10);
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
    }

    public void addAllProductsToTheCart() {
        String locator = ADD_PRODUCT_TO_CART_BUTTON.substring(53);
        By locatorToChooseAllAddToCartButtons = By.xpath(locator);
        waitForElementsDisplayed(locatorToChooseAllAddToCartButtons, 10);
        List<WebElement> allProducts = driver.findElements(locatorToChooseAllAddToCartButtons);
        for (WebElement x : allProducts) {
            x.click();
        }
    }

    public void removeProductFromTheCart(String productName) {
        waitForElementDisplayed(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName), 10);
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).click();
    }

    public void removeAllProductsFromTheCart() {
        String locator = REMOVE_PRODUCT_FROM_CART_BUTTON.substring(65);
        By locatorToAllRemoveButtons = By.xpath(locator);
        waitForElementsDisplayed(locatorToAllRemoveButtons, 10);
        List<WebElement> allProducts = driver.findElements(locatorToAllRemoveButtons);
        for (WebElement x : allProducts) {
            x.click();
        }
    }

    public By getProductLink(String productName) {
        return By.xpath((String.format(PRODUCT_SPECIFICATION_LINK, productName)));
    }

    public String getProductPrice(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_PRICE, productName), 10);
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public String getProductDescription(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_DESCRIPTION, productName), 10);
        return driver.findElement(By.xpath(String.format(PRODUCT_DESCRIPTION, productName))).getText();
    }

    public void goToProductSpecificationPage(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_SPECIFICATION_LINK, productName), 10);
        driver.findElement(By.xpath(String.format(PRODUCT_SPECIFICATION_LINK, productName))).click();
    }

    public int getTheNumberOfProductsOffered() {
        String locator = PRODUCT_DESCRIPTION.substring(75);
        By locatorsToAllProducts = By.xpath(locator);
        waitForElementsDisplayed(locatorsToAllProducts, 10);
        List<WebElement> products = driver.findElements(locatorsToAllProducts);
        return products.size();
    }

    public void setProductsSorting(String sortingPrinciple) {
        waitForElementDisplayed(SORTING_PRINCIPLE_DROPDOWN_MENU, 10);
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
