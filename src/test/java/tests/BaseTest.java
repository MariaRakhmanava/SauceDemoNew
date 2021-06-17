package tests;

import consts.ITestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Listeners;
import pages.*;

@Listeners(TestListener.class)
public class BaseTest implements ITestConstants {

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
    }

    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }

    public void initPages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutCustomerInformationPage = new CheckoutCustomerInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    @Step("A trial to open login page, log in with valid username and password, be moved to products page")
    public ProductsPage loginAndOpenProductsPageStep() {
        loginPage.openPage()
                .login(System.getProperty("username", VALID_LOGIN), System.getProperty("password", VALID_PASSWORD));
        return new ProductsPage(driver);
    }

    @Step("A trial to check a move from login page to products page")
    public void checkElementIsDisplayedStep(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
    }
}