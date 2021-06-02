package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTest extends BaseTest implements iTestConstants {
    @Test
    public void checkProductCharacteristicsTest() {
        loginPage.openPage()
                 .login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        driver.findElement(productsPage.getProductLink(SAUCE_LABS_BACKPACK_PRODUCT)).click();
        Assert.assertEquals(productDetailsPage.getProductItemName(SAUCE_LABS_BACKPACK_PRODUCT), SAUCE_LABS_BACKPACK_PRODUCT);
        Assert.assertEquals(productDetailsPage.getProductDescription(SAUCE_LABS_BACKPACK_PRODUCT), SAUCE_LABS_BACKPACK_PRODUCT_DESCRIPTION);
        Assert.assertEquals(productDetailsPage.getProductPrice(SAUCE_LABS_BACKPACK_PRODUCT), SAUCE_LABS_BACKPACK_PRODUCT_PRICE);
    }
}
