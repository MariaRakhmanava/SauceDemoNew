package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends BaseTest{

    @Test
    public void checkInformationAboutProduct() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToTheCart("Sauce Labs Bike Light");
        checkoutOverviewPage.openPage();
        Assert.assertEquals(checkoutOverviewPage.getNumberOfItems(), cartPage.getNumberOfItems());
        Assert.assertEquals(checkoutOverviewPage.getProductPrice("Sauce Labs Bike Light"), cartPage.getProductPrice("Sauce Labs Bike Light"));
        Assert.assertEquals(checkoutOverviewPage.getProductQuantity("Sauce Labs Bike Light"), cartPage.getProductQuantity("Sauce Labs Bike Light"));
    }
}
