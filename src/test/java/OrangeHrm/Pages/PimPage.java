package OrangeHrm.Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PimPage {
    WebDriver driver;
    WebDriverWait wait;

    By adminMenuOption = By.xpath("(//a[@class='oxd-main-menu-item'])[1]");
    By leaveMenuOption = By.xpath("(//a[@class='oxd-main-menu-item'])[2]");
    By empIdInput = By.xpath("(//input[contains(@class,'oxd-input')])[2]");
    By searchBtn = By.xpath("//button[@type='submit']");
    By deleteButton = By.xpath("(//div[@class='oxd-table-cell-actions']//button)[1]");
    By confirmDelete = By.xpath("(//div[@class='orangehrm-modal-footer']//button)[2]");

    String empID = "0243";

    public PimPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAdminMenuOption() {
        driver.findElement(adminMenuOption).click();
        String actual = driver.findElement(By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-level')]")).getText();
        Assert.isTrue(actual.equals("User Management"), "Expected result does not match with actual result");
    }

    public void deleteUser() {
        driver.findElement(empIdInput).sendKeys(empID);
        driver.findElement(searchBtn).click();
        driver.findElement(deleteButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDelete));
        driver.findElement(confirmDelete).click();
    }

    public void clickLeaveMenuOption() {
        driver.findElement(leaveMenuOption).click();
        String actual = driver.findElement(By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]")).getText();
        Assert.isTrue(actual.equals("Leave"), "Expected result does not match with actual result");
    }
}
