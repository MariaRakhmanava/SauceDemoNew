package tests;

import consts.ITestConstants;
import objects.CustomerInformation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutCustomerInformationTest extends BaseTest implements ITestConstants {
    @BeforeClass
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
                .enterUserInformation(new CustomerInformation("", "", ""));
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), FIRST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkFirstnameFillingNecessityTest() {
        loginSteps
                .loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD);
        checkoutCustomerInformationPage
                .openPage()
                .enterUserInformation(CustomerInformation.builder()
                        .firstName("")
                        .lastName(LAST_NAME_INPUT_VALUE)
                        .postalCode(POSTAL_CODE_INPUT_VALUE)
                        .build());
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), FIRST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkLastnameFillingNecessityTest() {
        loginSteps
                .loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD);
        checkoutCustomerInformationPage
                .openPage()
                .enterUserInformation(CustomerInformation.builder()
    .firstName(FIRST_NAME_INPUT_VALUE)
                        .lastName("")
                        .postalCode(POSTAL_CODE_INPUT_VALUE)
                        .build());
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), LAST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkPostalCodeFillingNecessityTest() {
        loginSteps
                .loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD);
        checkoutCustomerInformationPage
                .openPage()
                .enterUserInformation(CustomerInformation.builder()
                        .firstName(FIRST_NAME_INPUT_VALUE)
                        .lastName(LAST_NAME_INPUT_VALUE)
                        .postalCode("")
                        .build());
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), POSTAL_CODE_REQUIRED_ERROR_MESSAGE_TEXT);
    }
}
