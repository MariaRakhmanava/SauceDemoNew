package pages;

import consts.IPagesUrls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends HeaderMenuPage implements IPagesUrls {

    @FindBy(id = "back-to-products")
    WebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage openPage() {
        super.openPage(CHECKOUT_COMPLETE_PAGE_URL);
        return this;
    }

    public CheckoutOverviewPage clickBackHomeButton() {
        waitForElementDisplayed(backHomeButton, 10);
        backHomeButton.click();
        return new CheckoutOverviewPage(driver);
    }
}