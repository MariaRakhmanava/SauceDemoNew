package tests;

import consts.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements ITestConstants {
    @Test(description = "Login validation check")
    public void loginWithValidDataTest() {
        loginSteps.loginAndAppearOnProductsPage(VALID_USERNAME, VALID_PASSWORD);
        Assert.assertTrue(productsPage.isgPageTitleElementDisplayed());
    }

    @Test
    public void loginLeavingAllInputFieldsEmptyTest() {
        loginSteps.loginAndAppearOnProductsPage("","");
        Assert.assertEquals(loginPage.getErrorMessageText(), USERNAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkUsernameFillingNecessityTest() {
        loginSteps.loginAndAppearOnProductsPage("", VALID_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), USERNAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkPasswordFillingNecessityTest() {
        loginSteps.loginAndAppearOnProductsPage(VALID_USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessageText(), PASSWORD_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void loginWithInvalidUsernameTest() {
        loginSteps.loginAndAppearOnProductsPage("prohibited_user", VALID_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), NO_MATCHES_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        loginSteps.loginAndAppearOnProductsPage(VALID_USERNAME, "invalid_password");
        Assert.assertEquals(loginPage.getErrorMessageText(), NO_MATCHES_ERROR_MESSAGE_TEXT);
    }
}