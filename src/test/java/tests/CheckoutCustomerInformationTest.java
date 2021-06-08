package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCustomerInformationTest extends BaseTest implements ITestConstants {
    @Test
    public void fillInputsWithValidDataTest() {
        loginAndOpenProductsPage();
        checkoutCustomerInformationPage.openPage()
                .enterUserInformation(FIRST_NAME_INPUT_VALUE, LAST_NAME_INPUT_VALUE, POSTAL_CODE_INPUT_VALUE);
        Assert.assertTrue(checkoutOverviewPage.getPageTitle().isDisplayed());
    }

    @Test
    public void checkNecessaryInputsTest() {
        loginAndOpenProductsPage();
        checkoutCustomerInformationPage.openPage()
                .enterUserInformation("", "", "");
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), FIRST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkFirstnameFillingNecessityTest() {
        loginAndOpenProductsPage();
        checkoutCustomerInformationPage.openPage()
                .enterUserInformation("", LAST_NAME_INPUT_VALUE, POSTAL_CODE_INPUT_VALUE);
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), FIRST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkLastnameFillingNecessityTest() {
        loginAndOpenProductsPage();
        checkoutCustomerInformationPage.openPage()
                .enterUserInformation(FIRST_NAME_INPUT_VALUE, "", POSTAL_CODE_INPUT_VALUE);
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), LAST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkPostalCodeFillingNecessityTest() {
        loginAndOpenProductsPage();
        checkoutCustomerInformationPage.openPage()
                .enterUserInformation(FIRST_NAME_INPUT_VALUE, LAST_NAME_INPUT_VALUE, "");
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), POSTAL_CODE_REQUIRED_ERROR_MESSAGE_TEXT);
    }
}
