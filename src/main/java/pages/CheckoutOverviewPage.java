package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutOverviewPage extends CommonPartPage {

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM_NAME = "//*[contains(text(),'%s')]";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM_NAME + "/ancestor::*[@class='cart_item']//*[@class='cart_quantity']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM_NAME + "/ancestor::*[@class='cart_item']//*[@class='inventory_item_price']";
    private static final By PAYMENT_INFORMATION_FIELD = By.xpath("//*[contains(text(), 'Payment Information')]/parent::*[@class='summary_info']/*[contains(text(), 'SauceCard')]");
    private static final By SHIPPING_INFORMATION_FIELD = By.xpath("//*[contains(text(),'Shipping Information')]/following-sibling::*[1]");
    private static final By ITEM_TOTAL_FIELD = By.xpath("//*[@class='summary_subtotal_label']");
    private static final By TAX_FIELD = By.xpath("//*[@class='summary_tax_label']");
    private static final By TOTAL_FIELD = By.xpath("//*[@class='summary_total_label']");
    private static final By CANCEL_BUTTON = By.xpath("//button[@id='cancel']");
    private static final By FINISH_BUTTON = By.xpath("//button[contains(text(), 'Finish')]");

    public void openPage(String url) {
        driver.get(url);
    }

    public String getProductQuantity(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_QUANTITY, productName), 7);
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY, productName))).getText();
    }

    public String getProductPrice(String productName) {
        waitForElementDisplayed(String.format(PRODUCT_PRICE, productName), 7);
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public String getPaymentInformation() {
        waitForElementDisplayed(PAYMENT_INFORMATION_FIELD, 7);
        return driver.findElement(PAYMENT_INFORMATION_FIELD).getText();
    }

    public String getItemTotalWithoutTaxSum() {
        waitForElementDisplayed(ITEM_TOTAL_FIELD, 7);
        return driver.findElement(ITEM_TOTAL_FIELD).getText();
    }

    public String getTaxSum() {
        waitForElementDisplayed(TAX_FIELD, 7);
        return driver.findElement(TAX_FIELD).getText();
    }

    public String getTotalSum() {
        waitForElementDisplayed(TOTAL_FIELD, 7);
        return driver.findElement(TOTAL_FIELD).getText();
    }

    public int getNumberOfItems() {
        String locator = PRODUCT_PRICE.substring(58);
        By locatorsToChooseAllItems = By.xpath(locator);
        waitForElementsDisplayed(locatorsToChooseAllItems, 10);
        List<WebElement> items = driver.findElements(locatorsToChooseAllItems);
        return items.size();
    }

    public void cancelAndGoToThePreviousPage() {
        waitForElementDisplayed(CANCEL_BUTTON, 10);
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void finishCheckout() {
        waitForElementDisplayed(FINISH_BUTTON, 10);
        driver.findElement(FINISH_BUTTON).click();
    }
}
