package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements iTestConstants{

    @Test
    public void loginWithValidDataTest() {
        loginPage.openPage()
                 .login(STANDARD_USER_LOGIN, VALID_PASSWORD);
    }

    @Test
    public void loginLeavingAllInputFieldsEmptyTest() {
        loginPage.openPage()
                 .login();
        Assert.assertEquals(loginPage.getErrorMessage(), USERNAME_REQUIRED_ERROR_MESSAGE_TEXT);
        loginPage.closeErrorMessage();
    }

    @Test
    public void checkUsernameFillingNecessityTest() {
        loginPage.openPage()
                 .loginWithPasswordOnly(VALID_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(), USERNAME_REQUIRED_ERROR_MESSAGE_TEXT);
        loginPage.closeErrorMessage();
    }

    @Test
    public void checkPasswordFillingNecessityTest() {
        loginPage.openPage()
                 .loginWithUsernameOnly(STANDARD_USER_LOGIN);
        Assert.assertEquals(loginPage.getErrorMessage(), PASSWORD_REQUIRED_ERROR_MESSAGE_TEXT);
        loginPage.closeErrorMessage();
    }

    @Test
    public void loginWithInvalidUsernameTest() {
        loginPage.openPage()
                 .login("prohibited_user", VALID_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(), NO_MATCHES_ERROR_MESSAGE_TEXT);
        loginPage.closeErrorMessage();
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        loginPage.openPage()
                 .login(STANDARD_USER_LOGIN, "invalid_password");
        Assert.assertEquals(loginPage.getErrorMessage(), NO_MATCHES_ERROR_MESSAGE_TEXT);
        loginPage.closeErrorMessage();
    }
}
