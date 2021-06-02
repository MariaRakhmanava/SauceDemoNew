package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class CheckoutOverviewTest extends BaseTest implements iTestConstants{

    @Test
    public void checkTheNumberOfProductItemsInTheOrderTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        productsPage.addProductToTheCart(SAUCE_LABS_BIKE_LIGHT_PRODUCT);
        productsPage.addProductToTheCart(SAUCE_LABS_BACKPACK_PRODUCT);
        checkoutOverviewPage.openPage(CHECKOUT_OVERVIEW_PAGE_URL);
        Assert.assertEquals(checkoutOverviewPage.getNumberOfItems(), cartPage.getNumberOfItems());
    }

    @Test
    public void checkThePriceOfProductsInTheOrderTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        List<String> listOfProducts = Arrays.asList(SAUCE_LABS_BACKPACK_PRODUCT, SAUCE_LABS_BIKE_LIGHT_PRODUCT, SAUCE_LABS_BOLT_T_SHIRT_PRODUCT);
        for (String product : listOfProducts) {
        productsPage.addProductToTheCart(product);
        }
        checkoutOverviewPage.openPage(CHECKOUT_OVERVIEW_PAGE_URL);
        for (String product : listOfProducts) {
        Assert.assertEquals(checkoutOverviewPage.getProductPrice(product), cartPage.getProductPrice(product));
        }
    }

    @Test
    public void checkTheNumberOfProductsInTheOrderTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        productsPage.waitForPageLoaded();
        productsPage.addAllProductsToTheCart();
        checkoutOverviewPage.openPage(CHECKOUT_OVERVIEW_PAGE_URL);
        checkoutOverviewPage.waitForPageLoaded();
        for (String productItem : productsPage.getListOfInventoryItemsNames()) {
        Assert.assertEquals(checkoutOverviewPage.getProductQuantity(productItem), cartPage.getProductQuantity(productItem));
        }
    }
}
