package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Log in and appear on the products page")
    public ProductsPage loginAndAppearOnProductsPage(String username, String password) {
        loginPage
                .openPage()
                .login(System.getProperty("username", username), System.getProperty("password", password));
        return productsPage;
    }
}
