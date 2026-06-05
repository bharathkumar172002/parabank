package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TransferPage {
    WebDriver driver;

    // Correct locator
    By amountField = By.name("amount");
    By fromAccount = By.id("fromAccountId");
    By toAccount = By.id("toAccountId");
    By transferBtn = By.xpath("//input[@value='Transfer']");
    By confirmationHeading = By.cssSelector("h1");

    public TransferPage(WebDriver driver) {
        this.driver = driver;
    }

    public void transferFunds(String amount, String fromAcc, String toAcc) {
        driver.findElement(amountField).clear();
        driver.findElement(amountField).sendKeys(amount);

        Select fromDropdown = new Select(driver.findElement(fromAccount));
        fromDropdown.selectByVisibleText(fromAcc);

        Select toDropdown = new Select(driver.findElement(toAccount));
        toDropdown.selectByVisibleText(toAcc);

        driver.findElement(transferBtn).click();
    }

    public String getConfirmation() {
        return driver.findElement(confirmationHeading).getText();
    }
}
