package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest implements ITestConstants {
    @Test
    public void addProductToTheCartFromProductsPageTest() {
        loginAndOpenProductsPage()
                .addProductToTheCart(SAUCE_LABS_BOLT_T_SHIRT_PRODUCT);
        String expectedProductPrice = productsPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT_PRODUCT);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT_PRODUCT), expectedProductPrice);
    }

    @Test
    public void addProductToTheCartFromProductSpecificationPageTest() {
        loginAndOpenProductsPage()
                .clickAndGoToProductDetailsPage(SAUCE_LABS_ONESIE_PRODUCT);
        String expectedPrice = productDetailsPage.getProductPrice(SAUCE_LABS_ONESIE_PRODUCT);
        productDetailsPage.addProductToTheCart(SAUCE_LABS_ONESIE_PRODUCT);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_ONESIE_PRODUCT), expectedPrice);
    }

    @Test
    public void removeProductsFromTheCartTest() {
        loginAndOpenProductsPage()
                .addProductToTheCart(SAUCE_LABS_ONESIE_PRODUCT)
                .addProductToTheCart(SAUCE_LABS_BACKPACK_PRODUCT);
        cartPage.openPage()
                .removeAllProductsFromTheCart();
        Assert.assertEquals(cartPage.getNumberOfItems(), 0);
    }

    @Test
    public void checkCartLinkTest() {
        loginAndOpenProductsPage()
                .addProductToTheCart(TEST_ALL_THE_THINGS_T_SHIRT_RED_PRODUCT)
                .goToCartPageByCartIcon();
        Assert.assertEquals(cartPage.getNumberOfItems(), 1);
        cartPage.clickContinueShoppingButton()
                .addProductToTheCart(SAUCE_LABS_FLEECE_JACKET_PRODUCT)
                .goToCartPageByCartIcon();
        Assert.assertEquals(cartPage.getNumberOfItems(), 2);
    }
}