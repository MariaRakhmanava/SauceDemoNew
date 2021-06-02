package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static consts.iURLsOfPages.PRODUCTS_PAGE_URL;


public class ProductsPage extends GeneralPartPage {

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement sortingDropdownMenu;

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    List<WebElement> inventoryItemsNames;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//*[contains(text(),'Add to cart')]";
    private static final String REMOVE_PRODUCT_FROM_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item_description']//*[contains(text(),'Remove')]";
    private static final String PRODUCT_PRICE = "//*[contains(text(),'%s')]/ancestor::*[@class='inventory_item_description']//*[@class='inventory_item_price']";
    private static final String PRODUCT_DETAILS_LINK = "//*[text()='%s']";
    private static final String PRODUCT_DESCRIPTION = "//*[contains(text(),'%s')]/ancestor::*[@class='inventory_item_description']//*[@class='inventory_item_desc']";

    public ProductsPage openPage() {
       super.openPage(PRODUCTS_PAGE_URL);
       return this;
    }

    public ProductsPage addProductToTheCart(String productName) {
        waitForElementDisplayed(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName), 10);
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        return this;
    }

    public ProductsPage addAllProductsToTheCart() {
        String locator = ADD_PRODUCT_TO_CART_BUTTON.substring(53);
        By locatorToChooseAllAddToCartButtons = By.xpath(locator);
        waitForElementsDisplayed(locatorToChooseAllAddToCartButtons, 10);
        List<WebElement> allProducts = driver.findElements(locatorToChooseAllAddToCartButtons);
        for (WebElement x : allProducts) {
            x.click();
        }
        return this;
    }

    public ProductsPage removeProductFromTheCart(String productName) {
        waitForElementDisplayed(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName), 10);
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).click();
        return this;
    }

    public ProductsPage removeAllProductsFromTheCart() {
        String locator = REMOVE_PRODUCT_FROM_CART_BUTTON.substring(65);
        By locatorToAllRemoveButtons = By.xpath(locator);
        waitForElementsDisplayed(locatorToAllRemoveButtons, 10);
        List<WebElement> allProducts = driver.findElements(locatorToAllRemoveButtons);
        for (WebElement x : allProducts) {
            x.click();
        }
        return this;
    }

    public By getProductLink(String productName) {
        return By.xpath((String.format(PRODUCT_DETAILS_LINK, productName)));
    }

    public String getProductPrice(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_PRICE, productName), 10);
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public String getProductDescription(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_DESCRIPTION, productName), 10);
        return driver.findElement(By.xpath(String.format(PRODUCT_DESCRIPTION, productName))).getText();
    }

    public void goToProductDetailsPage(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_DETAILS_LINK, productName), 10);
        driver.findElement(By.xpath(String.format(PRODUCT_DETAILS_LINK, productName))).click();
    }

    public int getTheNumberOfProductsOffered() {
        String locator = PRODUCT_DESCRIPTION.substring(75);
        By locatorsToAllProducts = By.xpath(locator);
        waitForElementsDisplayed(locatorsToAllProducts, 10);
        List<WebElement> products = driver.findElements(locatorsToAllProducts);
        return products.size();
    }

    public ProductsPage setProductsSorting(String sortingPrinciple) {
        waitForElementDisplayed(sortingDropdownMenu, 10);
        Select sortingOptions = new Select(sortingDropdownMenu);
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
        return this;
    }

    public List<String> getListOfInventoryItems() {
        waitForElementsDisplayed(inventoryItemsNames, 10);
        List<String> listOfNames = new ArrayList<>(6);
        for (WebElement item : inventoryItemsNames) {
             listOfNames.add(item.getText());
        }
        return listOfNames;
    }

    public CartPage goToCartByCartIcon() {
        super.goToCart();
        return new CartPage(driver);
    }
}
