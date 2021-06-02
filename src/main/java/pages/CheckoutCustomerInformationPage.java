package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCustomerInformationPage extends GeneralPartPage {

    public CheckoutCustomerInformationPage(WebDriver driver) {
        super(driver);
    }

    private static final By FIRST_NAME_INPUT = By.xpath("//*[@id='first-name']");
    private static final By LAST_NAME_INPUT = By.xpath("//*[@id='last-name']");
    private static final By ZIP_OR_POSTAL_CODE_INPUT = By.xpath("//*[@id='postal-code']");
    private static final By CANCEL_BUTTON = By.xpath("//*[@id='cancel']");
    private static final By CONTINUE_BUTTON = By.xpath("//*[@id='continue']");
    private static final By ERROR_MESSAGE_TEXT = By.xpath("//*[@class='error-message-container error']");

    @Override
    public void openPage(String url) {
        driver.get(url);
    }

    public void fillInputsAndContinue(String firstName, String lastName, String postalCode) {
        waitForElementDisplayed(FIRST_NAME_INPUT, 7);
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        waitForElementDisplayed(LAST_NAME_INPUT, 7);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        waitForElementDisplayed(ZIP_OR_POSTAL_CODE_INPUT, 7);
        driver.findElement(ZIP_OR_POSTAL_CODE_INPUT).sendKeys(postalCode);
        waitForElementDisplayed(CONTINUE_BUTTON, 7);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void leaveInputsEmptyAndContinue() {
        waitForElementDisplayed(FIRST_NAME_INPUT, 7);
        driver.findElement(FIRST_NAME_INPUT).sendKeys("");
        waitForElementDisplayed(LAST_NAME_INPUT, 7);
        driver.findElement(LAST_NAME_INPUT).sendKeys("");
        waitForElementDisplayed(ZIP_OR_POSTAL_CODE_INPUT, 7);
        driver.findElement(ZIP_OR_POSTAL_CODE_INPUT).sendKeys("");
        waitForElementDisplayed(CONTINUE_BUTTON, 7);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void omitFirstNameAndContinue(String lastName, String postalCode) {
        waitForElementDisplayed(FIRST_NAME_INPUT, 7);
        driver.findElement(FIRST_NAME_INPUT).sendKeys("");
        waitForElementDisplayed(LAST_NAME_INPUT, 7);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        waitForElementDisplayed(ZIP_OR_POSTAL_CODE_INPUT, 7);
        driver.findElement(ZIP_OR_POSTAL_CODE_INPUT).sendKeys(postalCode);
        waitForElementDisplayed(CONTINUE_BUTTON, 7);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void omitLastNameAndContinue(String firstName, String postalCode) {
        waitForElementDisplayed(FIRST_NAME_INPUT, 7);
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        waitForElementDisplayed(LAST_NAME_INPUT, 7);
        driver.findElement(LAST_NAME_INPUT).sendKeys("");
        waitForElementDisplayed(ZIP_OR_POSTAL_CODE_INPUT, 7);
        driver.findElement(ZIP_OR_POSTAL_CODE_INPUT).sendKeys(postalCode);
        waitForElementDisplayed(CONTINUE_BUTTON, 7);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void omitPostalCodeAndContinue(String firstName, String lastName) {
        waitForElementDisplayed(FIRST_NAME_INPUT, 7);
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        waitForElementDisplayed(LAST_NAME_INPUT, 7);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        waitForElementDisplayed(ZIP_OR_POSTAL_CODE_INPUT, 7);
        driver.findElement(ZIP_OR_POSTAL_CODE_INPUT).sendKeys("");
        waitForElementDisplayed(CONTINUE_BUTTON, 7);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void cancelAndGoToThePreviousPage() {
        waitForElementDisplayed(CANCEL_BUTTON, 10);
        driver.findElement(CANCEL_BUTTON).click();
    }

    public String getErrorMessageText() {
        waitForElementDisplayed(ERROR_MESSAGE_TEXT, 10);
        return driver.findElement(ERROR_MESSAGE_TEXT).getText();
    }
}
