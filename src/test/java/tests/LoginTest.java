package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginWithValidDataTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void loginLeavingAllInputFieldsEmptyTest() {
        loginPage.openPage();
        loginPage.login();
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required");
    }

    @Test
    public void checkUsernameFillingNecessityTest() {
        loginPage.openPage();
        loginPage.loginWithPasswordOnly("secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessageText(),"Epic sadface: Username is required");

    }

    @Test
    public void checkPasswordFillingNecessityTest() {
        loginPage.openPage();
        loginPage.loginWithUsernameOnly("standard_user");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Password is required");
    }

    @Test
    public void loginWithInvalidUsernameTest() {
        loginPage.openPage();
        loginPage.login("prohibited_user", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "invalid_password");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service");
    }

}
