package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static consts.IPagesUrls.CHECKOUT_OVERVIEW_PAGE_URL;

public class CheckoutOverviewPage extends HeaderMenuPage {

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

    public CheckoutOverviewPage openPage() {
        super.openPage(CHECKOUT_OVERVIEW_PAGE_URL);
        return this;
    }

    public String getProductQuantity(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_QUANTITY, productName), 10);
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY, productName))).getText();
    }

    public String getProductPrice(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_PRICE, productName), 10);
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public String getPaymentInformation() {
        waitForElementDisplayed(paymentInformationField, 10);
        return paymentInformationField.getText();
    }

    public String getItemTotalWithoutTaxSum() {
        waitForElementDisplayed(itemTotalField, 10);
        return itemTotalField.getText();
    }

    public String getTaxSum() {
        waitForElementDisplayed(taxField, 10);
        return taxField.getText();
    }

    public String getTotalSum() {
        waitForElementDisplayed(totalField, 10);
        return totalField.getText();
    }

    public int getNumberOfItems() {
        waitForElementsDisplayed(productsInTheOrder, 10);
        return productsInTheOrder.size();
    }

    public CheckoutCustomerInformationPage clickCancelButton() {
        waitForElementDisplayed(cancelButton, 10);
        cancelButton.click();
        return new CheckoutCustomerInformationPage(driver);
    }

    public CheckoutCompletePage clickFinishButton() {
        waitForElementDisplayed(finishButton, 10);
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }

    public WebElement getPageTitle() {
        waitForElementDisplayed(pageTitle, 10);
        return pageTitle;
    }
}
