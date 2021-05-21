package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest{

    @Test
    public void checkProductsRangeTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.setProductsSorting("Price (high to low)");
        Assert.assertEquals(productsPage.getTheNumberOfProductsOffered(), 6);
    }
}
