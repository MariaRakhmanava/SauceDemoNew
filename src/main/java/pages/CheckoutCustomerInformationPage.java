package pages;

import consts.IPagesUrls;
import io.qameta.allure.Step;
import objects.CustomerInformation;
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

    @Step("Open the checkout stage 1 [Your Information] page")
    public CheckoutCustomerInformationPage openPage() {
        super.openPage(CHECKOUT_CUSTOMER_INFO_PAGE_URL);
        return this;
    }

    @Step("Fill the First Name, Last Name, Postal Code fields with {firstName}, {lastName}, {postalCode} correspondingly")
    public void enterUserInformation(CustomerInformation customerInformation) {
        waitForElementDisplayed(firstNameInput, 10);
        firstNameInput.sendKeys(customerInformation.getFirstName());
        lastNameInput.sendKeys(customerInformation.getLastName());
        zipOrPostalCodeInput.sendKeys(customerInformation.getPostalCode());
        continueButton.click();
    }

    public CartPage clickCancelButton() {
        waitForElementDisplayed(cancelButton, 10);
        cancelButton.click();
        return new CartPage(driver);
    }

    @Step("Get an error message having filled not all the fields on the checkout stage 1 [Customer Information] page")
    public String getErrorMessageText() {
        waitForElementDisplayed(errorMessage, 10);
        return errorMessage.getText();
    }
}