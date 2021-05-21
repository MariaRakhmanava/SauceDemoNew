package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest implements iTestConstants{

    @Test
    public void addProductToTheCartFromProductsPageTest() {
        loginPage.openPage();
        loginPage.login(STANDARD_USER_LOGIN, PASSWORD);
        productsPage.addProductToTheCart(SAUCE_LABS_BOLT_T_SHIRT_PRODUCT);
        String expectedProductPrice = productsPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT_PRODUCT);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT_PRODUCT), expectedProductPrice);
    }

    @Test
    public void addProductToTheCartFromProductSpecificationPageTest() {
        loginPage.openPage();
        loginPage.login(STANDARD_USER_LOGIN, PASSWORD);
        productsPage.goToProductSpecificationPage(SAUCE_LABS_ONESIE_PRODUCT);
        String expectedPrice = productSpecificationPage.getProductPrice();
        productSpecificationPage.addProductToTheCart();
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_ONESIE_PRODUCT), expectedPrice);
    }

    @Test
    public void removeProductsFromTheCart() {
        loginPage.openPage();
        loginPage.login(STANDARD_USER_LOGIN, PASSWORD);
        productsPage.addProductToTheCart(SAUCE_LABS_ONESIE_PRODUCT);
        productsPage.addProductToTheCart(SAUCE_LABS_BACKPACK_PRODUCT);
        cartPage.openPage();
        cartPage.removeAllProductsFromTheCart();
        Assert.assertEquals(cartPage.getNumberOfItems(), 0);

    }
}
