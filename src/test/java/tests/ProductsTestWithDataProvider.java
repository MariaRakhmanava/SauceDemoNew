package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductsTestWithDataProvider extends BaseTest implements ITestConstants {

    @DataProvider(name = "ListOfProductsOffered")
    public Object[][] listOfProductsOffered() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99"},
                {"Sauce Labs Bike Light", "$9.99"},
                {"Sauce Labs Bolt T-Shirt", "$15.99"},
                {"Sauce Labs Fleece Jacket", "$49.99"},
                {"Sauce Labs Onesie", "$7.99"},
                {"Test.allTheThings() T-Shirt (Red)", "$15.99"}
        };
    }

    @Test
    public void checkProductsRangeTest() {
        loginPage.openPage()
                .login(standardUser());
        productsPage.waitForPageLoaded();
        productsPage.setProductsSorting(BY_PRICE_HIGH_TO_LOW_PRODUCTS_SORTING_PRINCIPLE);
        Assert.assertEquals(productsPage.getTheNumberOfProductsOffered(), 6);
    }

    @Test(dataProvider = "ListOfProductsOffered")
    public void compareProductsNamesToThoseInDatabaseTest(String productName, String productPrice) {
        loginPage.openPage()
                .login(standardUser());
        productsPage.waitForPageLoaded();
        for (int i = 0; i < productsPage.getListOfProductsNames().size(); i++) {
            Assert.assertEquals(productsPage.getListOfProductsNames().get(i), listOfProductsOffered()[i][0]);
        }
    }

    @Test(dataProvider = "ListOfProductsOffered")
    public void compareProductsPricesToThoseInDatabaseTest(String productName, String productPrice) {
        loginPage.openPage()
                .login(standardUser());
        productsPage.waitForPageLoaded();
        for (int i = 0; i < productsPage.getListOfProductsNames().size(); i++) {
            Assert.assertEquals(productsPage.getListOfProductsPrices().get(i), listOfProductsOffered()[i][1]);
        }
    }
}
