package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addProductToTheCartFromProductsPageTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToTheCart("Sauce Labs Bolt T-Shirt");
        String expectedProductPrice = productsPage.getProductPrice("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), expectedProductPrice);
    }

    @Test
    public void addProductToTheCartFromProductSpecificationPageTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.goToProductSpecificationPage("Sauce Labs Onesie");
        String expectedPrice = productSpecificationPage.getProductPrice();
        productSpecificationPage.addProductToTheCart();
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Onesie"), expectedPrice);
    }

    @Test
    public void removeProductsFromTheCart() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToTheCart("Sauce Labs Onesie");
        productsPage.addProductToTheCart("Sauce Labs Backpack");
        cartPage.openPage();
        cartPage.removeAllProductsFromTheCart();
        Assert.assertEquals(cartPage.getNumberOfItems(), 0);

    }
}
