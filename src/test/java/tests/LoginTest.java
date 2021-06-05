package tests;

import objects.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements ITestConstants {
    @BeforeClass
    public User setUpUserWithEmptyLoginAndPassword() {
        User user = new User("","");
        return user;
    }
    public User setUpUserWithValidLoginOnly() {
        User user = new User(VALID_LOGIN, "");
        return user;
    }
    public User setUpUserWithValidPasswordOnly() {
        User user = new User("", VALID_PASSWORD);
        return user;
    }
    public User setUpUserWithInvalidUsername() {
        User user = new User("prohibited_user", VALID_PASSWORD);
        return user;
    }
    public User setUpUserWithInvalidPassword() {
        User user = new User(VALID_LOGIN, "invalid_password");
        return user;
    }

    @Test
    public void loginWithValidDataTest() {
        loginPage.openPage()
                 .login(standardUser());
        Assert.assertTrue(productsPage.getPageTitleElement().isDisplayed());
    }

    @Test
    public void loginLeavingAllInputFieldsEmptyTest() {
        loginPage.openPage()
                 .login(setUpUserWithEmptyLoginAndPassword());
        Assert.assertEquals(loginPage.getErrorMessageText(), USERNAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkUsernameFillingNecessityTest() {
        loginPage.openPage()
                 .login(setUpUserWithValidPasswordOnly());
        Assert.assertEquals(loginPage.getErrorMessageText(), USERNAME_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void checkPasswordFillingNecessityTest() {
        loginPage.openPage()
                 .login(setUpUserWithValidLoginOnly());
        Assert.assertEquals(loginPage.getErrorMessageText(), PASSWORD_REQUIRED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void loginWithInvalidUsernameTest() {
        loginPage.openPage()
                 .login(setUpUserWithInvalidUsername());
        Assert.assertEquals(loginPage.getErrorMessageText(), NO_MATCHES_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        loginPage.openPage()
                 .login(setUpUserWithInvalidPassword());
        Assert.assertEquals(loginPage.getErrorMessageText(), NO_MATCHES_ERROR_MESSAGE_TEXT);
    }
}
