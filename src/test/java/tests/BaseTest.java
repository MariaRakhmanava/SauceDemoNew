package tests;

import consts.ITestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Listeners;
import pages.*;
import steps.LoginSteps;

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
    LoginSteps loginSteps;

    @BeforeMethod
    public void initTest(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        initPages();
        PageFactory.initElements(driver, this);
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
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
        loginSteps = new LoginSteps(driver);
    }

    /* using until LoginSteps creating
    public ProductsPage loginAndOpenProductsPage() {
        loginPage.openPage()
                .login(System.getProperty("username", VALID_USERNAME), System.getProperty("password", VALID_PASSWORD));
        return new ProductsPage(driver);
    }
    */
}
