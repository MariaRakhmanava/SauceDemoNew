package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFactoryLoginPage extends BasePage {

    public PageFactoryLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-test='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//*[@class='error-message-container error']")
    WebElement errorMessageText;


    public void openPage(String url) {
        driver.get(url);
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessageText() {
        return errorMessageText.getText();
    }

}
