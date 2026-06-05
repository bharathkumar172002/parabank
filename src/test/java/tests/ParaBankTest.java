package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.LoginPage;
import pages.HomePage;
import pages.AccountsPage;

public class ParaBankTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    AccountsPage accountsPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);
    }

    @Test(priority = 1)
    public void loginTest() {
        loginPage.login("john", "demo");
        Assert.assertTrue(accountsPage.getHeading().contains("Accounts Overview"),
                "Login failed - Accounts Overview not found");
    }

    @Test(priority = 2)
    public void customerDetailsTest() {
        homePage.goToCustomerDetails();
        Assert.assertTrue(driver.getTitle().contains("Update Profile"));
        driver.navigate().back();
    }

    @Test(priority = 3)
    public void accountsOverviewTest() {
        homePage.goToAccounts();
        Assert.assertTrue(accountsPage.getHeading().contains("Accounts Overview"));
    }

    @Test(priority = 4)
    public void logoutTest() {
        homePage.logout();
        String title = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertTrue(title.contains("Customer Login"), "Logout failed!");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
