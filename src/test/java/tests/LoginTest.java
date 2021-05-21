package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements iTestConstants{

    @Test
    public void loginWithValidDataTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, PASSWORD);
    }

    @Test
    public void loginLeavingAllInputFieldsEmptyTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login();
        Assert.assertEquals(loginPage.getErrorMessageText(), USERNAME_REQUIRED_ERROR_MESSAGE);
        loginPage.closeErrorMessage();
    }

    @Test
    public void checkUsernameFillingNecessityTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.loginWithPasswordOnly(PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(),USERNAME_REQUIRED_ERROR_MESSAGE);
        loginPage.closeErrorMessage();
    }

    @Test
    public void checkPasswordFillingNecessityTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.loginWithUsernameOnly(STANDARD_USER_LOGIN);
        Assert.assertEquals(loginPage.getErrorMessageText(), PASSWORD_REQUIRED_ERROR_MESSAGE);
        loginPage.closeErrorMessage();
    }

    @Test
    public void loginWithInvalidUsernameTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login("prohibited_user", PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), NO_MATCHES_ERROR_MESSAGE);
        loginPage.closeErrorMessage();
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        loginPage.openPage(ROOT_URL);
        loginPage.login(STANDARD_USER_LOGIN, "invalid_password");
        Assert.assertEquals(loginPage.getErrorMessageText(), NO_MATCHES_ERROR_MESSAGE);
        loginPage.closeErrorMessage();
    }
}
