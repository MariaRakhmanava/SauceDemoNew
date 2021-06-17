package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends BaseTest implements ITestConstants {
    @Test
    public void checkTheNumberOfProductItemsInTheOrderTest() {
        loginAndOpenProductsPageStep()
                .addProductToTheCart(SAUCE_LABS_BIKE_LIGHT_PRODUCT)
                .addProductToTheCart(SAUCE_LABS_BACKPACK_PRODUCT);
        checkoutOverviewPage.openPage();
        Assert.assertEquals(checkoutOverviewPage.getNumberOfItems(), cartPage.getNumberOfItems());
    }

    @Test
    public void checkThePriceOfProductsInTheOrderTest() {
        loginAndOpenProductsPageStep()
                .addProductToTheCart(SAUCE_LABS_BACKPACK_PRODUCT)
                .addProductToTheCart(SAUCE_LABS_BIKE_LIGHT_PRODUCT)
                .addProductToTheCart(SAUCE_LABS_BOLT_T_SHIRT_PRODUCT);
        checkoutOverviewPage.openPage();
        for (String product : cartPage.getListOfProductsAddedToCart()) {
            Assert.assertEquals(checkoutOverviewPage.getProductPrice(product), cartPage.getProductPrice(product));
        }
    }

    @Test
    public void checkTheNumberOfProductsInTheOrderTest() {
        loginAndOpenProductsPageStep()
                .waitForPageLoaded()
                .addAllProductsToTheCart();
        checkoutOverviewPage.openPage();
        for (String productItem : productsPage.getListOfProductsNames()) {
            Assert.assertEquals(checkoutOverviewPage.getProductQuantity(productItem), cartPage.getProductQuantity(productItem));
        }
    }
}