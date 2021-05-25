package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest implements iTestConstants{

    @Test
    public void checkProductsRangeTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        productsPage.setProductsSorting(BY_PRICE_HIGH_TO_LOW_PRODUCTS_SORTING_PRINCIPLE);
        Assert.assertEquals(productsPage.getTheNumberOfProductsOffered(), 6);
    }
}
