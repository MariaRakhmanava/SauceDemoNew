package pages;

import consts.IPagesUrls;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Log4j2
public class CheckoutCompletePage extends HeaderMenuPage implements IPagesUrls {

    @FindBy(id = "back-to-products")
    WebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open the checkout stage 3 [complete] page")
    public CheckoutCompletePage openPage() {
        log.info("Open Checkout page, COMPLETE stage");
        super.openPage(CHECKOUT_COMPLETE_PAGE_URL);
        return this;
    }

    public CheckoutOverviewPage clickBackHomeButton() {
        waitForElementDisplayed(backHomeButton, 10);
        log.info("Click the BACK HOME button displayed on the Checkout Complete page");
        backHomeButton.click();
        return new CheckoutOverviewPage(driver);
    }
}