package pages;

import consts.IPagesUrls;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;


@Log4j2
public class CheckoutOverviewPage extends HeaderMenuPage implements IPagesUrls {

    @FindBy(xpath = "//*[@class='cart_item']")
    List<WebElement> productsInTheOrder;

    @FindBy(xpath = "//*[contains(text(), 'Payment Information')]/parent::*[@class='summary_info']/*[contains(text(), 'SauceCard')]")
    WebElement paymentInformationField;

    @FindBy(xpath = "//*[contains(text(),'Shipping Information')]/following-sibling::*[1]")
    WebElement shippingInformationField;

    @FindBy(xpath = "//*[@class='summary_subtotal_label']")
    WebElement itemTotalField;

    @FindBy(xpath = "//*[@class='summary_tax_label']")
    WebElement taxField;

    @FindBy(xpath = "//*[@class='summary_total_label']")
    WebElement totalField;

    @FindBy(xpath = "//button[@id='cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//button[contains(text(), 'Finish')]")
    WebElement finishButton;

    @FindBys({
            @FindBy(xpath = "//*[@class='title']"),
            @FindBy(xpath = "//*[contains(text(),'Overview')]")
    })
    WebElement pageTitle;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM_NAME = "//*[contains(text(),'%s')]";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM_NAME + "/ancestor::*[@class='cart_item']//*[@class='cart_quantity']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM_NAME + "/ancestor::*[@class='cart_item']//*[@class='inventory_item_price']";

    @Step("Open the checkout stage 2 [Overview] page")
    public CheckoutOverviewPage openPage() {
        log.info("Open the Checkout page, OVERVIEW stage");
        super.openPage(CHECKOUT_OVERVIEW_PAGE_URL);
        return this;
    }

    @Step("Get the quantity of {productName} displayed on the checkout [overview] page")
    public String getProductQuantity(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_QUANTITY, productName), 10);
        log.info(String.format("Get the quantity of: '%s' in the order displayed on the Checkout Overview page", productName));
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY, productName))).getText();
    }

    @Step("Get the price of {productName} displayed on the checkout overview page")
    public String getProductPrice(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_PRICE, productName), 10);
        log.info(String.format("Get the price of: '%s' in the order displayed on the Checkout Overview page", productName));
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    @Step("Get the payment information displayed on the checkout overview page")
    public String getPaymentInformation() {
        waitForElementDisplayed(paymentInformationField, 10);
        log.info("Get the order payment information displayed on the Checkout Overview page");
        return paymentInformationField.getText();
    }

    @Step("Get the order price before tax displayed on the checkout overview page")
    public String getItemTotalWithoutTaxSum() {
        waitForElementDisplayed(itemTotalField, 10);
        log.info("Get the order price before tax displayed on the Checkout Overview page");
        return itemTotalField.getText();
    }

    @Step("Get the tax sum displayed on the checkout overview page")
    public String getTaxSum() {
        waitForElementDisplayed(taxField, 10);
        log.info("Get the order tax sum displayed on the Checkout Overview page");
        return taxField.getText();
    }

    @Step("Get the total order price displayed on the checkout overview page")
    public String getTotalSum() {
        waitForElementDisplayed(totalField, 10);
        log.info("Get the total order price displayed on the checkout overview page");
        return totalField.getText();
    }

    @Step("Get the number of product items in the order displayed on the checkout overview page")
    public int getNumberOfItems() {
        waitForElementsDisplayed(productsInTheOrder, 10);
        log.info("Get the number of products in the order displayed on the Checkout Overview page");
        return productsInTheOrder.size();
    }

    public CheckoutCustomerInformationPage clickCancelButton() {
        waitForElementDisplayed(cancelButton, 10);
        log.info("Click the CANCEL button on the Checkout Overview page");
        cancelButton.click();
        return new CheckoutCustomerInformationPage(driver);
    }

    public CheckoutCompletePage clickFinishButton() {
        waitForElementDisplayed(finishButton, 10);
        log.info("Click the COMPLETE button displayed on the Checkout Overview page");
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }

    @Step("Check that the user is automatically moved to the checkout stage 2 [overview] page having filled in valid first name, last name, and postal/zip code")
    public WebElement getPageTitle() {
        waitForElementDisplayed(pageTitle, 10);
        log.info("Get the Checkout Overview page title");
        return pageTitle;
    }
}