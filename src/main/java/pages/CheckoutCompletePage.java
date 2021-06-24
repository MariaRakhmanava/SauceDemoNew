package pages;

import consts.IPagesUrls;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutCompletePage extends HeaderMenuPage implements IPagesUrls {

    @FindBy(id = "back-to-products")
    WebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open the checkout stage 3 [complete] page")
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