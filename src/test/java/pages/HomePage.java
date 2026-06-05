package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By accountsOverviewLink = By.linkText("Accounts Overview");
    By updateInfoLink = By.linkText("Update Contact Info");
    // Correct locator for Transfer Funds
    By transferFundsLink = By.linkText("Transfer Funds");
    By logoutLink = By.linkText("Log Out");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAccounts() {
        driver.findElement(accountsOverviewLink).click();
    }

    public void goToCustomerDetails() {
        driver.findElement(updateInfoLink).click();
    }

    public void goToTransferFunds() {
        driver.findElement(transferFundsLink).click();
    }

    public void logout() {
        driver.findElement(logoutLink).click();
    }
}
