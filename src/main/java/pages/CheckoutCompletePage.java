package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends CommonPartPage {

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    private static final By BACK_HOME_BUTTON = By.xpath("//*[@id='back-to-products']");

    public void openPage(String url) {
        driver.get(url);
    }

    public void goToThePreviousPage() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
}
