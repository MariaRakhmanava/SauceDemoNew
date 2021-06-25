package pages;

import consts.IPagesUrls;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Log4j2
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
        log.info("Open Login page");
        super.openPage(LOGIN_PAGE_URL);
        return this;
    }

    @Step("Log in with {login} username and {password} password")
    public void login(String username, String password) {
        waitForElementDisplayed(usernameInput, 10);
        log.info(String.format("Enter username: '%s' in the Username field", username));
        usernameInput.sendKeys(username);
        log.info(String.format("Enter password: '%s' in the Password field", password));
        passwordInput.sendKeys(password);
        log.info("Click the LOGIN button");
        loginButton.click();
    }

    public WebElement getErrorMessage() {
        waitForElementDisplayed(errorMessage, 10);
        log.info("Get an error message due to omitted username or password while logging in");
        return errorMessage;
    }

    @Step("Get an error message due to omitted or invalid credential")
    public String getErrorMessageText() {
        waitForElementDisplayed(errorMessage, 10);
        log.info("Get an error message text due to omitted username or password while logging in");
        return errorMessage.getText();
    }
}