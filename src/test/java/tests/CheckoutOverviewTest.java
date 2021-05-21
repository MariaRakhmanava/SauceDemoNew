package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends BaseTest implements iTestConstants{

    @Test
    public void checkInformationAboutProduct() {
        loginPage.openPage();
        loginPage.login(STANDARD_USER_LOGIN, PASSWORD);
        productsPage.addProductToTheCart("Sauce Labs Bike Light");
        checkoutOverviewPage.openPage();
        Assert.assertEquals(checkoutOverviewPage.getNumberOfItems(), cartPage.getNumberOfItems());
        Assert.assertEquals(checkoutOverviewPage.getProductPrice(SAUCE_LABS_BIKE_LIGHT_PRODUCT), cartPage.getProductPrice(SAUCE_LABS_BIKE_LIGHT_PRODUCT));
        Assert.assertEquals(checkoutOverviewPage.getProductQuantity(SAUCE_LABS_BIKE_LIGHT_PRODUCT), cartPage.getProductQuantity(SAUCE_LABS_BIKE_LIGHT_PRODUCT));
    }
}
