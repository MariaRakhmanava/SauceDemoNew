package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


abstract class CommonPartPage extends BasePage {

    public CommonPartPage(WebDriver driver) {
        super(driver);
    }

    private static final By OPEN_MENU_BUTTON = By.xpath("//*[@id='react-burger-menu-btn']");
    private static final By ALL_ITEMS_LINK = By.xpath("//*[@id='inventory_sidebar_link']");
    private static final By ABOUT_LINK = By.xpath("//*[@id='about_sidebar_link']");
    private static final By LOGOUT_LINK = By.xpath("//*[@id='logout_sidebar_link']");
    private static final By RESET_APP_STATE_LINK = By.xpath("//*[@id='reset_sidebar_link']");
    private static final By CLOSE_MENU_CROSS_BUTTON = By.xpath("//*[@id='react-burger-cross-btn']");
    private static final By GO_TO_CART_ICON = By.xpath("//*[@class='shopping_cart_link']");
    private static final By TWITTER_LINK = By.xpath("//*[contains(text(),'Twitter')]");
    private static final By FACEBOOK_LINK = By.xpath("//*[contains(text(),'Facebook')]");
    private static final By LINKEDIN_LINK = By.xpath("//*[contains(text(),'LinkedIn')]");

    public void goToAllItemsSection() {
        waitForElementDisplayed(OPEN_MENU_BUTTON, 10);
        driver.findElement(OPEN_MENU_BUTTON).click();
        waitForElementDisplayed(ALL_ITEMS_LINK, 5);
        driver.findElement(ALL_ITEMS_LINK).click();
    }

    public void goToAboutSection() {
        waitForElementDisplayed(OPEN_MENU_BUTTON, 7);
        driver.findElement(OPEN_MENU_BUTTON).click();
        waitForElementDisplayed(ABOUT_LINK, 5);
        driver.findElement(ABOUT_LINK).click();
    }

    public void goLogoutSection() {
        waitForElementDisplayed(OPEN_MENU_BUTTON, 7);
        driver.findElement(OPEN_MENU_BUTTON).click();
        waitForElementDisplayed(LOGOUT_LINK, 8);
        driver.findElement(LOGOUT_LINK).click();
    }

    public void goToResetAppStateSection() {
        waitForElementDisplayed(OPEN_MENU_BUTTON, 7);
        driver.findElement(OPEN_MENU_BUTTON).click();
        waitForElementDisplayed(RESET_APP_STATE_LINK, 5);
        driver.findElement(RESET_APP_STATE_LINK).click();
    }

    public void goToCart() {
        waitForElementDisplayed(GO_TO_CART_ICON, 7);
        driver.findElement(GO_TO_CART_ICON).click();
    }

    public void goToSauceLabsTwitter() {
        waitForElementDisplayed(TWITTER_LINK, 7);
        driver.findElement(TWITTER_LINK).click();
    }

    public void goToSauceLabsFacebook() {
        waitForElementDisplayed(FACEBOOK_LINK, 7);
        driver.findElement(FACEBOOK_LINK).click();
    }

    public void goToSauceLabsLinkedIn() {
        waitForElementDisplayed(LINKEDIN_LINK, 7);
        driver.findElement(LINKEDIN_LINK).click();
    }
}
