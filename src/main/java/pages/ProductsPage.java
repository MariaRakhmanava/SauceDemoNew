package pages;

import consts.IPagesUrls;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class ProductsPage extends HeaderMenuPage implements IPagesUrls {

    @FindBy(xpath = "//*[contains(text(),'Add to cart')]")
    List<WebElement> addToCartButtonsOfAllProducts;

    @FindBy(xpath = "//*[contains(text(),'Remove')]")
    List<WebElement> removeButtonsOfAllProducts;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement sortingDropdownMenu;

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    List<WebElement> inventoryItemsNames;

    @FindBy(xpath = "//*[@class='inventory_item_price']")
    List<WebElement> productsPrices;

    @FindBys({
            @FindBy(xpath = "//*[@class='title']"),
            @FindBy(xpath = "//*[contains(text(),'Products')]")
    })
    WebElement pageTitle;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//*[contains(text(),'Add to cart')]";
    private static final String REMOVE_PRODUCT_FROM_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item_description']//*[contains(text(),'Remove')]";
    private static final String PRODUCT_PRICE = "//*[contains(text(),'%s')]/ancestor::*[@class='inventory_item_description']//*[@class='inventory_item_price']";
    private static final String PRODUCT_DETAILS_LINK = "//*[text()='%s']";
    private static final String PRODUCT_DESCRIPTION = "//*[contains(text(),'%s')]/ancestor::*[@class='inventory_item_description']//*[@class='inventory_item_desc']";

    @Step("Open the products page")
    public ProductsPage openPage() {
        super.openPage(PRODUCTS_PAGE_URL);
        return this;
    }

    @Step("Adding a {productName} to the shopping cart from the products page")
    public ProductsPage addProductToTheCart(String productName) {
        List<WebElement> listOfProductsAddedToCart = new ArrayList<>();
        waitForElementDisplayed(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName), 10);
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        return this;
    }

    @Step("Add all products on the Products Page to the shopping cart")
    public ProductsPage addAllProductsToTheCart() {
        waitForElementsDisplayed(inventoryItemsNames, 10);
        for (WebElement addToCartButton : addToCartButtonsOfAllProducts) {
            addToCartButton.click();
        }
        return this;
    }

    @Step("Remove a {productName} from the shopping cart on the Products Page")
    public ProductsPage removeProductFromTheCart(String productName) {
        waitForElementDisplayed(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName), 10);
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).click();
        return this;
    }

    @Step("Remove all products from the shopping cart on the products page")
    public ProductsPage removeAllProductsFromTheCart() {
        waitForElementsDisplayed(inventoryItemsNames, 10);
        for (WebElement removeButton : removeButtonsOfAllProducts) {
            removeButton.click();
        }
        return this;
    }

    @Step("Get a {productName} price displayed on the products page")
    public String getProductPrice(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_PRICE, productName), 10);
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    @Step("Get a {productName} description displayed on the products page")
    public String getProductDescription(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_DESCRIPTION, productName), 10);
        return driver.findElement(By.xpath(String.format(PRODUCT_DESCRIPTION, productName))).getText();
    }

    @Step("Click on the {productName} name on the products page to move to the {productName} details page")
    public void clickAndGoToProductDetailsPage(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_DETAILS_LINK, productName), 10);
        driver.findElement(By.xpath(String.format(PRODUCT_DETAILS_LINK, productName))).click();
    }

    @Step("Get the product portfolio displayed on the products page")
    public int getTheNumberOfProductsOffered() {
        waitForElementsDisplayed(inventoryItemsNames, 10);
        return inventoryItemsNames.size();
    }

    @Step("Sort product items on the product page according to {sortingPrinciple}")
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

    @Step("Get the list of products' names which are displayed on the products page")
    public List<String> getListOfProductsNames() {
        waitForElementsDisplayed(inventoryItemsNames, 10);
        List<String> listOfNames = new ArrayList<>(6);
        for (WebElement item : inventoryItemsNames) {
            listOfNames.add(item.getText());
        }
        return listOfNames;
    }

    @Step("Get the list of products' prices which are displayed on the products page")
    public List<String> getListOfProductsPrices() {
        waitForElementsDisplayed(productsPrices, 10);
        List<String> listOfPrices = new ArrayList<>(6);
        for (WebElement item : productsPrices) {
            listOfPrices.add(item.getText());
        }
        return listOfPrices;
    }

    @Step("Click the cart icon on the products page to move to the cart page")
    public CartPage goToCartPageByCartIcon() {
        super.goToCart();
        return new CartPage(driver);
    }

    @Step("Check that the user is automatically moved to the products page after having logged in with valid credentials")
    public boolean isgPageTitleElementDisplayed() {
        waitForElementDisplayed(pageTitle, 10);
        return pageTitle.isDisplayed();
    }

    public ProductsPage waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return new ProductsPage(driver);
    }
}
