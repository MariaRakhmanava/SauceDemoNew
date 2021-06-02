package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCustomerInformationTest extends BaseTest implements iTestConstants{

    @Test
    public void fillInputsWithValidDataTest() {
        loginPage.openPage()
                 .login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        checkoutCustomerInformationPage.openPage()
                                       .fillInputsAndContinue(FIRST_NAME_INPUT_VALUE, LAST_NAME_INPUT_VALUE, POSTAL_CODE_INPUT_VALUE);
    }

    @Test
    public void checkNecessaryInputsTest() {
        loginPage.openPage()
                 .login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        checkoutCustomerInformationPage.openPage()
                                       .leaveInputsEmptyAndContinue();
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), FIRST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkFirstnameFillingNecessityTest() {
        loginPage.openPage()
                 .login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        checkoutCustomerInformationPage.openPage()
                                       .omitFirstNameAndContinue(LAST_NAME_INPUT_VALUE, POSTAL_CODE_INPUT_VALUE);
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), FIRST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkLastnameFillingNecessityTest() {
        loginPage.openPage()
                 .login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        checkoutCustomerInformationPage.openPage()
                                       .omitLastNameAndContinue(FIRST_NAME_INPUT_VALUE, POSTAL_CODE_INPUT_VALUE);
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), LAST_NAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkPostalCodeFillingNecessityTest() {
        loginPage.openPage()
                 .login(STANDARD_USER_LOGIN, VALID_PASSWORD);
        checkoutCustomerInformationPage.openPage()
                                       .omitPostalCodeAndContinue(FIRST_NAME_INPUT_VALUE, LAST_NAME_INPUT_VALUE);
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), POSTAL_CODE_REQUIRED_ERROR_MESSAGE_TEXT);
    }
}
