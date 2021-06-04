package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static consts.IPagesUrls.LOGIN_PAGE_URL;

public class LoginPage extends HeaderMenuPage {

    @FindBy(xpath = "//*[@data-test='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@class='error-message-container error']")
    WebElement errorMessage;

    @FindBy(xpath = "//button[@class='error-button']")
    WebElement closeErrorMessageButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        super.openPage(LOGIN_PAGE_URL);
        return this;
    }
    public void login(String username, String password) {
        waitForElementDisplayed(usernameInput, 10);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
    public LoginPage loginWith(String username) {
        waitForElementDisplayed(usernameInput, 10);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys("");
        loginButton.click();
        return this;
    }

    public LoginPage login(String password) {
        waitForElementDisplayed(usernameInput, 10);
        usernameInput.sendKeys("");
        passwordInput.sendKeys(password);
        loginButton.click();
        return this;
    }

    public WebElement getErrorMessage() {
        waitForElementDisplayed(errorMessage, 10);
        return errorMessage;
    }

    public String getErrorMessageText() {
        waitForElementDisplayed(errorMessage, 10);
        return errorMessage.getText();
    }

    public LoginPage closeErrorMessage() {
        waitForElementDisplayed(closeErrorMessageButton, 10);
        closeErrorMessageButton.click();
        return this;
    }
}
