package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends BaseTest implements ITestConstants {
    @Test
    public void checkTheNumberOfProductItemsInTheOrderTest() {
        loginPage.openPage()
                 .login(VALID_LOGIN, VALID_PASSWORD);
        productsPage.addProductToTheCart(SAUCE_LABS_BIKE_LIGHT_PRODUCT)
                 .addProductToTheCart(SAUCE_LABS_BACKPACK_PRODUCT);
        checkoutOverviewPage.openPage();
        Assert.assertEquals(checkoutOverviewPage.getNumberOfItems(), cartPage.getNumberOfItems());
    }

    @Test
    public void checkThePriceOfProductsInTheOrderTest() {
        loginPage.openPage()
                 .login(VALID_LOGIN, VALID_PASSWORD);
        productsPage.addProductToTheCart(SAUCE_LABS_BACKPACK_PRODUCT)
                 .addProductToTheCart(SAUCE_LABS_BIKE_LIGHT_PRODUCT)
                 .addProductToTheCart(SAUCE_LABS_BOLT_T_SHIRT_PRODUCT);
        checkoutOverviewPage.openPage();
        for (String product : cartPage.getListOfProductsAddedToCart()) {
        Assert.assertEquals(checkoutOverviewPage.getProductPrice(product), cartPage.getProductPrice(product));
        }
    }

    @Test
    public void checkTheNumberOfProductsInTheOrderTest() {
        loginPage.openPage()
                 .login(VALID_LOGIN, VALID_PASSWORD);
        productsPage.waitForPageLoaded();
        productsPage.addAllProductsToTheCart();
        checkoutOverviewPage.openPage()
                            .waitForPageLoaded();
        for (String productItem : productsPage.getListOfProductsNames()) {
        Assert.assertEquals(checkoutOverviewPage.getProductQuantity(productItem), cartPage.getProductQuantity(productItem));
        }
    }
}
