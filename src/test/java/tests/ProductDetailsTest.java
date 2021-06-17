package tests;

import consts.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTest extends BaseTest implements ITestConstants {
    @Test(retryAnalyzer = Retry.class)
    public void checkProductCharacteristicNameTest() {
        loginAndOpenProductsPageStep()
                .clickProductNameToGoToProductDetailsPage(SAUCE_LABS_BACKPACK_PRODUCT);
        Assert.assertEquals(productDetailsPage.getProductItemName(SAUCE_LABS_BACKPACK_PRODUCT), SAUCE_LABS_BACKPACK_PRODUCT);
    }

    @Test(retryAnalyzer = Retry.class)
    public void checkProductCharacteristicPriceTest() {
        loginAndOpenProductsPageStep()
                .clickProductNameToGoToProductDetailsPage(SAUCE_LABS_BACKPACK_PRODUCT);
        Assert.assertEquals(productDetailsPage.getProductPrice(SAUCE_LABS_BACKPACK_PRODUCT), SAUCE_LABS_BACKPACK_PRODUCT_PRICE);
    }

    @Test(retryAnalyzer = Retry.class)
    public void checkProductCharacteristicDescriptionTest() {
        loginAndOpenProductsPageStep()
                .clickProductNameToGoToProductDetailsPage(SAUCE_LABS_BACKPACK_PRODUCT);
        Assert.assertEquals(productDetailsPage.getProductDescription(SAUCE_LABS_BACKPACK_PRODUCT), SAUCE_LABS_BACKPACK_PRODUCT_DESCRIPTION);
    }
}