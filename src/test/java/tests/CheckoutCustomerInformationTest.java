package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCustomerInformationTest extends BaseTest{

    @Test
    public void fillInputsWithValidDataTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        checkoutCustomerInformationPage.openPage();
        checkoutCustomerInformationPage.fillInputsAndContinue("Jane", "Doe", "220018");
    }

    @Test
    public void checkNecessaryInputsTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        checkoutCustomerInformationPage.openPage();
        checkoutCustomerInformationPage.leaveInputsEmptyAndContinue();
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), "Error: First Name is required");
    }

    @Test
    public void checkFirstnameFillingNecessityTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        checkoutCustomerInformationPage.openPage();
        checkoutCustomerInformationPage.omitFirstNameAndContinue("Doe", "220018");
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), "Error: First Name is required");
    }

    @Test
    public void checkLastnameFillingNecessityTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        checkoutCustomerInformationPage.openPage();
        checkoutCustomerInformationPage.omitLastNameAndContinue("Jane", "220018");
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), "Error: Last Name is required");
    }

    @Test
    public void checkPostalCodeFillingNecessityTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        checkoutCustomerInformationPage.openPage();
        checkoutCustomerInformationPage.omitPostalCodeAndContinue("Jane", "Doe");
        Assert.assertEquals(checkoutCustomerInformationPage.getErrorMessageText(), "Error: Postal Code is required");
    }

}
