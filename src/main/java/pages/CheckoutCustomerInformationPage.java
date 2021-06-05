package pages;

import objects.CustomerInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static consts.IPagesUrls.CHECKOUT_CUSTOMER_INFO_PAGE_URL;

public class CheckoutCustomerInformationPage extends HeaderMenuPage {

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

    public void enter(CustomerInformation customerInfo) {
        waitForElementDisplayed(firstNameInput, 10);
        firstNameInput.sendKeys(customerInfo.getFirstName());
        lastNameInput.sendKeys(customerInfo.getLastName());
        zipOrPostalCodeInput.sendKeys(customerInfo.getPostalCode());
        continueButton.click();
    }

    public CartPage clickCancelButton() {
        waitForElementDisplayed(cancelButton, 10);
        cancelButton.click();
        return new CartPage(driver);
    }

    public String getErrorMessageText() {
        waitForElementDisplayed(errorMessage, 10);
        return errorMessage.getText();
    }
}
