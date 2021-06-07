package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    ProductDetailsPage productDetailsPage;
    CheckoutCustomerInformationPage checkoutCustomerInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        initPages();
        PageFactory.initElements(driver, this);
        standardUser();
    }

    public void initPages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutCustomerInformationPage = new CheckoutCustomerInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    public User standardUser() {
        User user = new User("standard_user", "secret_sauce");
        return user;
    }

    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }
}
