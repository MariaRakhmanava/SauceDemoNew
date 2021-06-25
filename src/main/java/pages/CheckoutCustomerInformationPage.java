package pages;

import consts.IPagesUrls;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.CustomerInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Log4j2
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
        log.info("Open the Checkout page, YOUR INFORMATION stage");
        super.openPage(CHECKOUT_CUSTOMER_INFO_PAGE_URL);
        return this;
    }

    @Step("Fill the First Name, Last Name, Postal Code fields with {firstName}, {lastName}, {postalCode} correspondingly")
    public void enterUserInformation(CustomerInformation customerInformation) {
        waitForElementDisplayed(firstNameInput, 10);
        log.info(String.format("Enter a first name: '%s' into the First Name field", customerInformation.getFirstName()));
        firstNameInput.sendKeys(customerInformation.getFirstName());
        log.info(String.format("Enter a last name: '%s' into the Last Name field", customerInformation.getLastName()));
        lastNameInput.sendKeys(customerInformation.getLastName());
        log.info(String.format("Enter a postal code: '%s' into the Postal Code field", customerInformation.getPostalCode()));
        zipOrPostalCodeInput.sendKeys(customerInformation.getPostalCode());
        log.info("Click the CONTINUE button displayed on the Checkout Your Information page");
        continueButton.click();
    }

    public CartPage clickCancelButton() {
        waitForElementDisplayed(cancelButton, 10);
        log.info("Click the CANCEL button displayed on the Checkout Your Information page");
        cancelButton.click();
        return new CartPage(driver);
    }

    @Step("Get an error message having filled not all the fields on the checkout stage 1 [Customer Information] page")
    public String getErrorMessageText() {
        waitForElementDisplayed(errorMessage, 10);
        log.info("Get an error message text due to omitted field while entering customer information");
        return errorMessage.getText();
    }
}