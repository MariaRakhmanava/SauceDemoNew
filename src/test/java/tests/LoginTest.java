package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements ITestConstants {
    @Test
    public void loginWithValidDataTest() {
        loginAndOpenProductsPage();
        Assert.assertTrue(productsPage.getPageTitleElement().isDisplayed());
    }

    @Test
    public void loginLeavingAllInputFieldsEmptyTest() {
        loginPage.openPage()
                 .login("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), USERNAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkUsernameFillingNecessityTest() {
        loginPage.openPage()
                 .login("", VALID_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), USERNAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkPasswordFillingNecessityTest() {
        loginPage.openPage()
                 .login(VALID_LOGIN, "");
        Assert.assertEquals(loginPage.getErrorMessageText(), PASSWORD_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void loginWithInvalidUsernameTest() {
        loginPage.openPage()
                 .login("prohibited_user", VALID_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), NO_MATCHES_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        loginPage.openPage()
                 .login(VALID_LOGIN, "invalid_password");
        Assert.assertEquals(loginPage.getErrorMessageText(), NO_MATCHES_ERROR_MESSAGE_TEXT);
    }
}
