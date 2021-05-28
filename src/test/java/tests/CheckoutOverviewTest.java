package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends BaseTest implements iTestConstants{

    @Test
    public void checkInformationAboutProduct() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        productsPage.addProductToTheCart(SAUCE_LABS_BIKE_LIGHT_PRODUCT);
        checkoutOverviewPage.openPage(CHECKOUT_OVERVIEW_PAGE_URL);
        Assert.assertEquals(checkoutOverviewPage.getNumberOfItems(), cartPage.getNumberOfItems());
        Assert.assertEquals(checkoutOverviewPage.getProductPrice(SAUCE_LABS_BIKE_LIGHT_PRODUCT), cartPage.getProductPrice(SAUCE_LABS_BIKE_LIGHT_PRODUCT));
        Assert.assertEquals(checkoutOverviewPage.getProductQuantity(SAUCE_LABS_BIKE_LIGHT_PRODUCT), cartPage.getProductQuantity(SAUCE_LABS_BIKE_LIGHT_PRODUCT));
    }
}
