package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCustomerInformationTest extends BaseTest implements iTestConstants{

    @Test
    public void fillInputsWithValidDataTest() {
        loginPage.openPage(CHECKOUT_CUSTOMER_INFORMATION_PAGE_URL);
        loginPage.login(STANDARD_USER_LOGIN, PASSWORD);
        checkoutCustomerInformationPage.openPage(CHECKOUT_CUSTOMER_INFORMATION_PAGE_URL);
        checkoutCustomerInformationPage.fillInputsAndContinue(FIRST_NAME_INPUT, LAST_NAME_INPUT, POSTAL_CODE_INPUT);
    }

    @Test
    public void checkNecessaryInputsTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, PASSWORD);
        checkoutCustomerInformationPage.openPage(CHECKOUT_CUSTOMER_INFORMATION_PAGE_URL);
        checkoutCustomerInformationPage.leaveInputsEmptyAndContinue();
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), FIRST_NAME_REQUIRED_ERROR_MESSAGE);
    }

    @Test
    public void checkFirstnameFillingNecessityTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, PASSWORD);
        checkoutCustomerInformationPage.openPage(CHECKOUT_CUSTOMER_INFORMATION_PAGE_URL);
        checkoutCustomerInformationPage.omitFirstNameAndContinue(LAST_NAME_INPUT, POSTAL_CODE_INPUT);
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), FIRST_NAME_REQUIRED_ERROR_MESSAGE);
    }

    @Test
    public void checkLastnameFillingNecessityTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, PASSWORD);
        checkoutCustomerInformationPage.openPage(CHECKOUT_CUSTOMER_INFORMATION_PAGE_URL);
        checkoutCustomerInformationPage.omitLastNameAndContinue(FIRST_NAME_INPUT, POSTAL_CODE_INPUT);
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), LAST_NAME_REQUIRED_ERROR_MESSAGE);
    }

    @Test
    public void checkPostalCodeFillingNecessityTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, PASSWORD);
        checkoutCustomerInformationPage.openPage(CHECKOUT_CUSTOMER_INFORMATION_PAGE_URL);
        checkoutCustomerInformationPage.omitPostalCodeAndContinue(FIRST_NAME_INPUT, LAST_NAME_INPUT);
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), POSTAL_CODE_REQUIRED_ERROR_MESSAGE);
    }
}
