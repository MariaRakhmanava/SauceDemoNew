package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");
    public static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    public static final By ERROR_MESSAGE_TEXT = By.xpath("//*[@class='error-message-container error']");
    public static final By CLOSE_ERROR_MESSAGE_BUTTON = By.xpath("//button[@class='error-button']");

    @Override
    public void openPage(String url) {
        driver.get(url);
    }

    public void login(String username, String password) {
        waitForElementDisplayed(USERNAME_INPUT, 7);
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        waitForElementDisplayed(PASSWORD_INPUT, 7);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        waitForElementDisplayed(LOGIN_BUTTON, 7);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void login() {
        waitForElementDisplayed(USERNAME_INPUT, 7);
        driver.findElement(USERNAME_INPUT).sendKeys("");
        waitForElementDisplayed(PASSWORD_INPUT, 7);
        driver.findElement(PASSWORD_INPUT).sendKeys("");
        waitForElementDisplayed(LOGIN_BUTTON, 7);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void loginWithUsernameOnly(String username) {
        waitForElementDisplayed(USERNAME_INPUT, 7);
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        waitForElementDisplayed(PASSWORD_INPUT, 7);
        driver.findElement(PASSWORD_INPUT).sendKeys("");
        waitForElementDisplayed(LOGIN_BUTTON, 7);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void loginWithPasswordOnly(String password) {
        waitForElementDisplayed(USERNAME_INPUT, 7);
        driver.findElement(USERNAME_INPUT).sendKeys("");
        waitForElementDisplayed(PASSWORD_INPUT, 7);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        waitForElementDisplayed(LOGIN_BUTTON, 7);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessageText() {
        waitForElementDisplayed(ERROR_MESSAGE_TEXT, 10);
        return driver.findElement(ERROR_MESSAGE_TEXT).getText();
    }

    public void closeErrorMessage() {
        waitForElementDisplayed(CLOSE_ERROR_MESSAGE_BUTTON, 10);
        driver.findElement(CLOSE_ERROR_MESSAGE_BUTTON).click();
    }
}
