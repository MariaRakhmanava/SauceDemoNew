package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


abstract class GeneralPartPage extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    WebElement openMenuButton;

    @FindBy(id = "inventory_sidebar_link")
    WebElement allItemsLink;

    @FindBy(id = "about_sidebar_link")
    WebElement aboutSidebarLink;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutSidebarLink;

    @FindBy(id = "reset_sidebar_link")
    WebElement resetAppStateLink;

    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    WebElement goToCartIcon;

    @FindBy(xpath = "//*[contains(text(),'Twitter')]")
    WebElement twitterLink;

    @FindBy(xpath = "//*[contains(text(),'Facebook')]")
    WebElement facebookLink;

    @FindBy(xpath = "//*[contains(text(),'Linked')]")
    WebElement linkedInLink;

    GeneralPartPage(WebDriver driver) {
        super(driver);
    }

    public void goToAllItemsSection() {
        waitForElementDisplayed(openMenuButton, 10);
        openMenuButton.click();
        waitForElementDisplayed(allItemsLink, 5);
        allItemsLink.click();
    }

    public void goToAboutSection() {
        waitForElementDisplayed(openMenuButton, 10);
        openMenuButton.click();
        waitForElementDisplayed(aboutSidebarLink, 5);
        aboutSidebarLink.click();
    }

    public void goLogoutSection() {
        waitForElementDisplayed(openMenuButton, 10);
        openMenuButton.click();
        waitForElementDisplayed(logoutSidebarLink, 5);
        logoutSidebarLink.click();
    }

    public void goToResetAppStateSection() {
        waitForElementDisplayed(openMenuButton, 10);
        openMenuButton.click();
        waitForElementDisplayed(resetAppStateLink, 5);
        resetAppStateLink.click();
    }

    public void goToCart() {
        waitForElementDisplayed(goToCartIcon, 10);
        goToCartIcon.click();
    }

    public void goToSauceLabsTwitter() {
        waitForElementDisplayed(twitterLink, 10);
        twitterLink.click();
    }

    public void goToSauceLabsFacebook() {
        waitForElementDisplayed(facebookLink, 10);
        facebookLink.click();
    }

    public void goToSauceLabsLinkedIn() {
        waitForElementDisplayed(linkedInLink, 10);
        linkedInLink.click();
    }
}
