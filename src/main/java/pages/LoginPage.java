package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");
    public static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    public static final By ERROR_MESSAGE_TEXT = By.xpath("//*[@class='error-message-container error']");

    public void openPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void login() {
        driver.findElement(USERNAME_INPUT).sendKeys("");
        driver.findElement(PASSWORD_INPUT).sendKeys("");
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void loginWithUsernameOnly(String username) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys("");
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void loginWithPasswordOnly(String password) {
        driver.findElement(USERNAME_INPUT).sendKeys("");
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE_TEXT).getText();
    }
}
