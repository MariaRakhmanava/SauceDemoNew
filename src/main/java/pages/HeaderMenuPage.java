package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
abstract class HeaderMenuPage extends BasePage {

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

    HeaderMenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickOpenMenuButton() {
        waitForElementDisplayed(openMenuButton, 10);
        log.info("Click the open menu button");
        openMenuButton.click();
    }

    public void goToAllItemsSection() {
        clickOpenMenuButton();
        waitForElementDisplayed(allItemsLink, 5);
        log.info("Click the link All Items");
        allItemsLink.click();
    }

    public void goToAboutSection() {
        clickOpenMenuButton();
        waitForElementDisplayed(aboutSidebarLink, 5);
        log.info("Click the link About");
        aboutSidebarLink.click();
    }

    public void goLogoutSection() {
        clickOpenMenuButton();
        waitForElementDisplayed(logoutSidebarLink, 5);
        log.info("Click the link Logout");
        logoutSidebarLink.click();
    }

    public void goToResetAppStateSection() {
        clickOpenMenuButton();
        waitForElementDisplayed(resetAppStateLink, 5);
        log.info("Click the link Reset App State");
        resetAppStateLink.click();
    }

    public void goToCart() {
        waitForElementDisplayed(goToCartIcon, 10);
        log.info("Click the cart icon to move to the cart page");
        goToCartIcon.click();
    }

    public void goToSauceLabsTwitter() {
        waitForElementDisplayed(twitterLink, 10);
        log.info("Click the Sauce Labs Twitter link");
        twitterLink.click();
    }

    public void goToSauceLabsFacebook() {
        waitForElementDisplayed(facebookLink, 10);
        log.info("Click the Sauce Labs Facebook link");
        facebookLink.click();
    }

    public void goToSauceLabsLinkedIn() {
        waitForElementDisplayed(linkedInLink, 10);
        log.info("Click the Sauce Labs LinkedIn link");
        linkedInLink.click();
    }
}
