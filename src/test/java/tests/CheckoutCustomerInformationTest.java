package tests;

import consts.ITestConstants;
import objects.CustomerInformation;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckoutCustomerInformationTest extends BaseTest implements ITestConstants {
    @BeforeTest
    public CustomerInformation fullCustomerInformation() {
        CustomerInformation fullCustomerInformation = new CustomerInformation(FIRST_NAME_INPUT_VALUE, LAST_NAME_INPUT_VALUE, POSTAL_CODE_INPUT_VALUE);
        return fullCustomerInformation;
    }
    @Test
    public void fillInputsWithValidDataTest() {
        loginSteps
                .loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD);
        checkoutCustomerInformationPage
                .openPage()
                .enterUserInformation(fullCustomerInformation());
        Assert.assertTrue(checkoutOverviewPage.getPageTitle().isDisplayed());
    }

    @Test
    public void checkNecessaryInputsTest() {
        loginSteps
                .loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD);
        checkoutCustomerInformationPage
                .openPage()
                .enterUserInformation(new CustomerInformation("","",""));
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), FIRST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkFirstnameFillingNecessityTest() {
        loginSteps
                .loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD);
        checkoutCustomerInformationPage
                .openPage()
                .enterUserInformation(new CustomerInformation("", LAST_NAME_INPUT_VALUE, POSTAL_CODE_INPUT_VALUE));
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), FIRST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkLastnameFillingNecessityTest() {
        loginSteps
                .loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD);
        checkoutCustomerInformationPage
                .openPage()
                .enterUserInformation(new CustomerInformation(FIRST_NAME_INPUT_VALUE, "", POSTAL_CODE_INPUT_VALUE));
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), LAST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkPostalCodeFillingNecessityTest() {
        loginSteps
                .loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD);
        checkoutCustomerInformationPage
                .openPage()
                .enterUserInformation(new CustomerInformation(FIRST_NAME_INPUT_VALUE, LAST_NAME_INPUT_VALUE, ""));
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), POSTAL_CODE_REQUIRED_ERROR_MESSAGE_TEXT);
    }
}
