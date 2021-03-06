package tests;

import consts.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest implements ITestConstants {
    @Test
    public void addProductToTheCartFromProductsPageTest() {
        loginSteps
                .loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD)
                .addProductToTheCart(SAUCE_LABS_BOLT_T_SHIRT_PRODUCT);
        String expectedProductPrice = productsPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT_PRODUCT);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT_PRODUCT), expectedProductPrice);
    }

    @Test
    public void addProductToTheCartFromProductDetailsPageTest() {
        loginSteps
                .loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD)
                .clickAndGoToProductDetailsPage(SAUCE_LABS_ONESIE_PRODUCT);
        String expectedPrice = productDetailsPage.getProductPrice(SAUCE_LABS_ONESIE_PRODUCT);
        productDetailsPage.addProductToTheCart(SAUCE_LABS_ONESIE_PRODUCT);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_ONESIE_PRODUCT), expectedPrice);
    }

    @Test
    public void removeProductsFromTheCartTest() {
        loginSteps
                .loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD)
                .addProductToTheCart(SAUCE_LABS_ONESIE_PRODUCT)
                .addProductToTheCart(SAUCE_LABS_BACKPACK_PRODUCT);
        cartPage.openPage()
                .removeAllProductsFromTheCart();
        Assert.assertEquals(cartPage.getNumberOfItems(), 0);
    }

    @Test
    public void checkCartLinkTest() {
        loginSteps
                .loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD)
                .addProductToTheCart(TEST_ALL_THE_THINGS_T_SHIRT_RED_PRODUCT)
                .goToCartPageByCartIcon();
        Assert.assertEquals(cartPage.getNumberOfItems(), 1);
        cartPage.clickContinueShoppingButton()
                .addProductToTheCart(SAUCE_LABS_FLEECE_JACKET_PRODUCT)
                .goToCartPageByCartIcon();
        Assert.assertEquals(cartPage.getNumberOfItems(), 2);
    }
}