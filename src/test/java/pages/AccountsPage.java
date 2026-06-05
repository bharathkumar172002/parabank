package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage {
    WebDriver driver;

    // Updated locator
    By heading = By.xpath("//h1[contains(text(),'Accounts Overview')]");
    By firstAccount = By.xpath("//table[@id='accountTable']//tr[1]/td[1]/a");
    By secondAccount = By.xpath("//table[@id='accountTable']//tr[2]/td[1]/a");

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeading() {
        return driver.findElement(heading).getText();
    }

    public String getFirstAccountId() {
        return driver.findElement(firstAccount).getText();
    }

    public String getSecondAccountId() {
        return driver.findElement(secondAccount).getText();
    }
}
