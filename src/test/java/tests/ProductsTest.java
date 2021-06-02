package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductsTest extends BaseTest implements iTestConstants {
    @Test
    public void checkProductsRangeTest() {
        loginPage.openPage()
                 .login(STANDARD_USER_LOGIN, VALID_PASSWORD)
                 .waitForPageLoaded();
        productsPage.setProductsSorting(BY_PRICE_HIGH_TO_LOW_PRODUCTS_SORTING_PRINCIPLE);
        Assert.assertEquals(productsPage.getTheNumberOfProductsOffered(), 6);
    }

    @Test
    public void compareProductsPricesToThoseInDatabaseTest() {
        loginPage.openPage()
                 .login(STANDARD_USER_LOGIN, VALID_PASSWORD)
                 .waitForPageLoaded();
        for (String item : productsPage.getListOfInventoryItems()) {
            switch (item) {
                case SAUCE_LABS_BACKPACK_PRODUCT:
                    Assert.assertEquals(productsPage.getProductPrice(item), "$29.99");
                    break;
                case SAUCE_LABS_BIKE_LIGHT_PRODUCT:
                    Assert.assertEquals(productsPage.getProductPrice(item), "$9.99");
                    break;
                case SAUCE_LABS_BOLT_T_SHIRT_PRODUCT:
                    Assert.assertEquals(productsPage.getProductPrice(item), "$15.99");
                    break;
                case SAUCE_LABS_FLEECE_JACKET_PRODUCT:
                    Assert.assertEquals(productsPage.getProductPrice(item), "$49.99");
                    break;
                case SAUCE_LABS_ONESIE_PRODUCT:
                    Assert.assertEquals(productsPage.getProductPrice(item), "$7.99");
                    break;
                case TEST_ALL_THE_THINGS_T_SHIRT_RED_PRODUCT:
                    Assert.assertEquals(productsPage.getProductPrice(item), "$15.99");
                    break;
            }
        }
    }
}
