package tests;

import objects.ListOfProductsOffered;
import objects.Product;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest implements ITestConstants {

    @BeforeClass
    public ListOfProductsOffered setListOfProductsOffered() {
        ListOfProductsOffered listOfProductsOffered = new ListOfProductsOffered();
        listOfProductsOffered.addProductToList(new Product("Sauce Labs Backpack", "$29.99"));
        listOfProductsOffered.addProductToList(new Product("Sauce Labs Bike Light", "$9.99"));
        listOfProductsOffered.addProductToList(new Product("Sauce Labs Bolt T-Shirt", "$15.99"));
        listOfProductsOffered.addProductToList(new Product("Sauce Labs Fleece Jacket", "$49.99"));
        listOfProductsOffered.addProductToList(new Product("Sauce Labs Onesie", "$7.99"));
        listOfProductsOffered.addProductToList(new Product("Test.allTheThings() T-Shirt (Red)", "$15.99"));
        return listOfProductsOffered;
    }

    @Test
    public void checkProductsRangeTest() {
        loginPage.openPage()
                 .login(createStandardUser());
        productsPage.waitForPageLoaded();
        productsPage.setProductsSorting(BY_PRICE_HIGH_TO_LOW_PRODUCTS_SORTING_PRINCIPLE);
        Assert.assertEquals(productsPage.getTheNumberOfProductsOffered(), 6);
    }

    @Test
    public void compareProductsNamesToThoseInDatabaseTest() {
        loginPage.openPage()
                .login(createStandardUser());
        productsPage.waitForPageLoaded();
        for (int i = 0; i < productsPage.getListOfProductsNames().size(); i++) {
            Assert.assertEquals(productsPage.getListOfProductsNames().get(i), setListOfProductsOffered().getListOfProductsNames().get(i));
        }
    }

    @Test
    public void compareProductsPricesToThoseInDatabaseTest() {
        loginPage.openPage()
                .login(createStandardUser());
        productsPage.waitForPageLoaded();
        for (int i = 0; i < productsPage.getListOfProductsNames().size(); i++) {
            Assert.assertEquals(productsPage.getListOfProductsPrices().get(i), setListOfProductsOffered().getListOfProductsPrices().get(i));
        }
    }
}
