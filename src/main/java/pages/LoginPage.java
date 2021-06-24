package pages;

import consts.IPagesUrls;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends HeaderMenuPage implements IPagesUrls {

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

    @Step("Open the login page")
    public LoginPage openPage() {
        super.openPage(LOGIN_PAGE_URL);
        return this;
    }

    @Step("Log in with {login} username and {password} password")
    public void login(String login, String password) {
        waitForElementDisplayed(usernameInput, 10);
        usernameInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public WebElement getErrorMessage() {
        waitForElementDisplayed(errorMessage, 10);
        return errorMessage;
    }

    @Step("Get an error message due to omitted or invalid credential")
    public String getErrorMessageText() {
        waitForElementDisplayed(errorMessage, 10);
        return errorMessage.getText();
    }
}