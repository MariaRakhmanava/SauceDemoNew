package pages;

import consts.IPagesUrls;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutCustomerInformationPage extends HeaderMenuPage implements IPagesUrls {

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

    @Step("Opening Checkout Stage 1 [Your Information] Page")
    public CheckoutCustomerInformationPage openPage() {
        super.openPage(CHECKOUT_CUSTOMER_INFO_PAGE_URL);
        return this;
    }

    @Step("Filling the First Name, Last Name, Postal Code fields with {firstName}, {lastName}, {postalCode} correspondingly")
    public void enterUserInformation(String firstName, String lastName, String postalCode) {
        waitForElementDisplayed(firstNameInput, 10);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        zipOrPostalCodeInput.sendKeys(postalCode);
        continueButton.click();
    }

    public CartPage clickCancelButton() {
        waitForElementDisplayed(cancelButton, 10);
        cancelButton.click();
        return new CartPage(driver);
    }

    @Step("Getting an error message having filled not all the fields")
    public String getErrorMessageText() {
        waitForElementDisplayed(errorMessage, 10);
        return errorMessage.getText();
    }
}