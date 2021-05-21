package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest implements iTestConstants{

    @Test
    public void checkProductsRangeTest() {
        loginPage.openPage();
        loginPage.login(STANDARD_USER_LOGIN, PASSWORD);
        productsPage.setProductsSorting("Price (high to low)");
        Assert.assertEquals(productsPage.getTheNumberOfProductsOffered(), 6);
    }
}
