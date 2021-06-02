package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CartTest extends BaseTest implements iTestConstants{

    @Test
    public void addProductToTheCartFromProductsPageTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        productsPage.addProductToTheCart(SAUCE_LABS_BOLT_T_SHIRT_PRODUCT);
        String expectedProductPrice = productsPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT_PRODUCT);
        cartPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT_PRODUCT), expectedProductPrice);
    }

    @Test
    public void addProductToTheCartFromProductSpecificationPageTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        productsPage.goToProductSpecificationPage(SAUCE_LABS_ONESIE_PRODUCT);
        String expectedPrice = productSpecificationPage.getProductPrice(SAUCE_LABS_ONESIE_PRODUCT);
        productSpecificationPage.addProductToTheCart(SAUCE_LABS_ONESIE_PRODUCT);
        cartPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_ONESIE_PRODUCT), expectedPrice);
    }

    @Test
    public void removeProductsFromTheCart() {
        loginPage.openPage(CART_PAGE_URL);
        loginPage.login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        productsPage.addProductToTheCart(SAUCE_LABS_ONESIE_PRODUCT);
        productsPage.addProductToTheCart(SAUCE_LABS_BACKPACK_PRODUCT);
        cartPage.openPage(CART_PAGE_URL);
        cartPage.removeAllProductsFromTheCart();
        Assert.assertEquals(cartPage.getNumberOfItems(), 0);
    }

    @Test
    public void checkCartLinkTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        productsPage.addProductToTheCart(TEST_ALL_THE_THINGS_T_SHIRT_RED_PRODUCT);
        productsPage.goToCartByCartIcon();
        Assert.assertEquals(cartPage.getNumberOfItems(), 1);
        cartPage.continueShopping();
        productsPage.addProductToTheCart(SAUCE_LABS_FLEECE_JACKET_PRODUCT);
        productsPage.goToCartByCartIcon();
        Assert.assertEquals(cartPage.getNumberOfItems(), 2);
    }
}
