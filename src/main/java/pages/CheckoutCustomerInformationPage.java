package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static consts.iURLsOfPages.CHECKOUT_CUSTOMER_INFO_PAGE_URL;

public class CheckoutCustomerInformationPage extends GeneralPartPage {

    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement zipOrPostalCodeInput;

    @FindBy(id = "cancel")
    WebElement cancelButton;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(xpath = "//*[@class='error-message-container error']")
    WebElement errorMessage;

    public CheckoutCustomerInformationPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCustomerInformationPage openPage() {
        super.openPage(CHECKOUT_CUSTOMER_INFO_PAGE_URL);
        return this;
    }

    public CheckoutOverviewPage fillInputsAndContinue(String firstName, String lastName, String postalCode) {
        waitForElementDisplayed(firstNameInput, 10);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        zipOrPostalCodeInput.sendKeys(postalCode);
        continueButton.click();
        return new CheckoutOverviewPage(driver);
    }

    public CheckoutCustomerInformationPage leaveInputsEmptyAndContinue() {
        waitForElementDisplayed(firstNameInput, 10);
        firstNameInput.sendKeys("");
        lastNameInput.sendKeys("");
        zipOrPostalCodeInput.sendKeys("");
        continueButton.click();
        return this;
    }

    public CheckoutCustomerInformationPage omitFirstNameAndContinue(String lastName, String postalCode) {
        waitForElementDisplayed(firstNameInput, 10);
        firstNameInput.sendKeys("");
        lastNameInput.sendKeys(lastName);
        zipOrPostalCodeInput.sendKeys(postalCode);
        continueButton.click();
        return this;
    }

    public CheckoutCustomerInformationPage omitLastNameAndContinue(String firstName, String postalCode) {
        waitForElementDisplayed(firstNameInput, 10);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys("");
        zipOrPostalCodeInput.sendKeys(postalCode);
        continueButton.click();
        return this;
    }

    public CheckoutCustomerInformationPage omitPostalCodeAndContinue(String firstName, String lastName) {
        waitForElementDisplayed(firstNameInput, 10);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        zipOrPostalCodeInput.sendKeys("");
        continueButton.click();
        return this;
    }

    public CartPage cancelAndGoToThePreviousPage() {
        waitForElementDisplayed(cancelButton, 10);
        cancelButton.click();
        return new CartPage(driver);
    }

    public String getErrorMessageText() {
        waitForElementDisplayed(errorMessage, 10);
        return errorMessage.getText();
    }
}
