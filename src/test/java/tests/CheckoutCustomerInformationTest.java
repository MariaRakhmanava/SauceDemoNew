package tests;

import objects.CustomerInformation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCustomerInformationTest extends BaseTest implements ITestConstants {
    @Test
    public void fillInputsWithValidDataTest() {
        loginPage.openPage()
                 .login(VALID_LOGIN, VALID_PASSWORD);
        checkoutCustomerInformationPage.openPage()
                                       .enter(FIRST_NAME_INPUT_VALUE, LAST_NAME_INPUT_VALUE, POSTAL_CODE_INPUT_VALUE);
        Assert.assertTrue(checkoutOverviewPage.getPageTitle().isDisplayed());
    }

    @Test
    public void checkNecessaryInputsTest() {
        loginPage.openPage()
                 .login(VALID_LOGIN, VALID_PASSWORD);
        checkoutCustomerInformationPage.openPage()
                                       .enter("", "", "");
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), FIRST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkFirstnameFillingNecessityTest() {
        loginPage.openPage()
                 .login(VALID_LOGIN, VALID_PASSWORD);
        checkoutCustomerInformationPage.openPage()
                                       .enter("", LAST_NAME_INPUT_VALUE, POSTAL_CODE_INPUT_VALUE);
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), FIRST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkLastnameFillingNecessityTest() {
        loginPage.openPage()
                 .login(VALID_LOGIN, VALID_PASSWORD);
        checkoutCustomerInformationPage.openPage()
                                       .enter(FIRST_NAME_INPUT_VALUE, "", POSTAL_CODE_INPUT_VALUE);
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), LAST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkPostalCodeFillingNecessityTest() {
        loginPage.openPage()
                 .login(VALID_LOGIN, VALID_PASSWORD);
        checkoutCustomerInformationPage.openPage()
                                       .enter(FIRST_NAME_INPUT_VALUE, LAST_NAME_INPUT_VALUE, "");
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), POSTAL_CODE_REQUIRED_ERROR_MESSAGE_TEXT);
    }
}
