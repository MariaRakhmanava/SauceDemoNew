package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCustomerInformationPage extends HeaderPage {

    public CheckoutCustomerInformationPage(WebDriver driver) {
        super(driver);
    }

    private static final By FIRST_NAME_INPUT = By.xpath("//*[@id='first-name']");
    private static final By LAST_NAME_INPUT = By.xpath("//*[@id='last-name']");
    private static final By ZIP_OR_POSTAL_CODE_INPUT = By.xpath("//*[@id='postal-code']");
    private static final By CANCEL_BUTTON = By.xpath("//*[@id='cancel']");
    private static final By CONTINUE_BUTTON = By.xpath("//*[@id='continue']");
    private static final By ERROR_MESSAGE_TEXT = By.xpath("//*[@class='error-message-container error']");

    public void openPage() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

    public void fillInputsAndContinue(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_OR_POSTAL_CODE_INPUT).sendKeys(postalCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void leaveInputsEmptyAndContinue() {
        driver.findElement(FIRST_NAME_INPUT).sendKeys("");
        driver.findElement(LAST_NAME_INPUT).sendKeys("");
        driver.findElement(ZIP_OR_POSTAL_CODE_INPUT).sendKeys("");
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void omitFirstNameAndContinue(String lastName, String postalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys("");
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_OR_POSTAL_CODE_INPUT).sendKeys(postalCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void omitLastNameAndContinue(String firstName, String postalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys("");
        driver.findElement(ZIP_OR_POSTAL_CODE_INPUT).sendKeys(postalCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void omitPostalCodeAndContinue(String firstName, String lastName) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_OR_POSTAL_CODE_INPUT).sendKeys("");
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void cancelAndGoToThePreviousPage() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE_TEXT).getText();
    }

}
