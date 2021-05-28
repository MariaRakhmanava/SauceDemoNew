package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductSpecificationTest extends BaseTest implements iTestConstants {

    @Test
    public void checkProductCharacteristicsTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        productsPage.openPage(PRODUCTS_PAGE_URL);
        driver.findElement(productsPage.getProductLink(SAUCE_LABS_BACKPACK_PRODUCT)).click();
        Assert.assertEquals(productSpecificationPage.getProductItemName(SAUCE_LABS_BACKPACK_PRODUCT), SAUCE_LABS_BACKPACK_PRODUCT);
        Assert.assertEquals(productSpecificationPage.getProductDescription(SAUCE_LABS_BACKPACK_PRODUCT), SAUCE_LABS_BACKPACK_PRODUCT_DESCRIPTION);
        Assert.assertEquals(productSpecificationPage.getProductPrice(SAUCE_LABS_BACKPACK_PRODUCT), SAUCE_LABS_BACKPACK_PRODUCT_PRICE);
    }
}
