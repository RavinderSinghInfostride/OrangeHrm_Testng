package OrangeHrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AdminPage {
    WebDriver driver;
    WebDriverWait wait;
    By pageVerification = By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-level')]");
    //To add user
    By addButton = By.xpath("//div[@class='orangehrm-header-container']/button");

    //Add user required fields
    By userRoleDropdown = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    By employeeNameInput = By.xpath("(//div/input)[2]");
    By statusDropdown = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    By usernameInput = By.xpath("(//div/input[@class='oxd-input oxd-input--active'])[2]");
    By passwordInput = By.xpath("(//div/input[@type='password'])[1]");
    By confirmPasswordInput = By.xpath("(//div/input[@type='password'])[2]");
    By saveButton = By.xpath("//button[contains(@class,'orangehrm-left-space')]");
    String newUserName;

    //To search the added user
    By searchUserNameInput = By.xpath("(//input[contains(@class,'oxd-input')])[2]");
    By searchButton = By.xpath("//div[@class='oxd-form-actions']/button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
        String actual = driver.findElement(By.xpath("//h6[contains(@class,'orangehrm-main-title')]")).getText();
        net.jodah.failsafe.internal.util.Assert.isTrue(actual.equals("Add User"), "Expected result does not match with actual result");
    }

    public void AddUser() throws InterruptedException {
        String random = String.valueOf((int) (Math.random() * (100 - 1 + 1) + 1));
        newUserName = "AdminRavinder" + random;
        driver.findElement(userRoleDropdown).click();
        driver.findElement(By.xpath("//*[contains(text(),'Admin')]")).click();
        driver.findElement(employeeNameInput).sendKeys("Odis");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Odis')]")));
        driver.findElement(By.xpath("//*[contains(text(),'Odis')]")).click();
        driver.findElement(statusDropdown).click();
        driver.findElement(By.xpath("//*[contains(text(),'Enabled')]")).click();
        driver.findElement(usernameInput).sendKeys(newUserName);
        driver.findElement(passwordInput).sendKeys("Admin1234@");
        driver.findElement(confirmPasswordInput).sendKeys("Admin1234@");
        Thread.sleep(3000);
        driver.findElement(saveButton).click();
    }

    public void verifyAddedUser() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(pageVerification, "User Management"));
        driver.findElement(searchUserNameInput).sendKeys(newUserName);
        driver.findElement(userRoleDropdown).click();
        driver.findElement(By.xpath("//*[contains(text(),'Admin')]")).click();
        driver.findElement(searchButton).click();
        boolean isAdminDisplayed = driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]", newUserName))).isDisplayed();
        Assert.assertTrue(isAdminDisplayed, "User is not added");
    }
}
