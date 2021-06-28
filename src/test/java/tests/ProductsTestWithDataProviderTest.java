package tests;

import consts.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductsTestWithDataProviderTest extends BaseTest implements ITestConstants {

    @DataProvider(name = "Data about products")
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

    @Test(dataProvider = "Data about products")
    public void compareProductsNamesToThoseInDatabaseTest(String productName, String productPrice) {
        loginSteps
                .loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD)
                .waitForPageLoaded();
        for (int i = 0; i < productsPage.getListOfProductsNames().size(); i++) {
            Assert.assertEquals(productsPage.getListOfProductsNames().get(i), listOfProductsOffered()[i][0]);
        }
    }

    @Test(dataProvider = "Data about products")
    public void compareProductsPricesToThoseInDatabaseTest(String productName, String productPrice) {
        loginSteps
                .loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD)
                .waitForPageLoaded();
        for (int i = 0; i < productsPage.getListOfProductsNames().size(); i++) {
            Assert.assertEquals(productsPage.getListOfProductsPrices().get(i), listOfProductsOffered()[i][1]);
        }
    }
}
