package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    ProductSpecificationPage productSpecificationPage;
    CheckoutCustomerInformationPage checkoutCustomerInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        productSpecificationPage = new ProductSpecificationPage(driver);
        checkoutCustomerInformationPage = new CheckoutCustomerInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }

}
