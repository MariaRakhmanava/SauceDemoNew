package tests;

import objects.User;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements ITestConstants {
    @Test
    public void loginWithValidDataTest() {
        loginPage.openPage()
                 .login(standardUser());
        Assert.assertTrue(productsPage.getPageTitleElement().isDisplayed());
    }

    @Test
    public void loginLeavingAllInputFieldsEmptyTest() {
        loginPage.openPage()
                 .login(new User("", ""));
        Assert.assertEquals(loginPage.getErrorMessageText(), USERNAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkUsernameFillingNecessityTest() {
        loginPage.openPage()
                 .login(new User("", VALID_PASSWORD));
        Assert.assertEquals(loginPage.getErrorMessageText(), USERNAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkPasswordFillingNecessityTest() {
        loginPage.openPage()
                 .login(new User(VALID_LOGIN, ""));
        Assert.assertEquals(loginPage.getErrorMessageText(), PASSWORD_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void loginWithInvalidUsernameTest() {
        loginPage.openPage()
                 .login(new User("prohibited_user", VALID_PASSWORD));
        Assert.assertEquals(loginPage.getErrorMessageText(), NO_MATCHES_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        loginPage.openPage()
                 .login(new User(VALID_LOGIN, "invalid_password"));
        Assert.assertEquals(loginPage.getErrorMessageText(), NO_MATCHES_ERROR_MESSAGE_TEXT);
    }
}
