package OrangeHrm.Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeavePage {
    WebDriver driver;
    By applyNavMenuOption = By.xpath("//nav[@class='oxd-topbar-body-nav']//a[contains(text(),'Apply')]");
    By leaveTypeDropdown = By.xpath("//div[contains(@class,'oxd-select-text--active')]");
    By fromDate = By.xpath("(//div[contains(@class,'oxd-date-input')]/input)[1]");
    By commentsInput = By.xpath("//textarea[contains(@class,'oxd-textarea')]");
    By applyLeaveButton = By.xpath("//button[contains(@class,'oxd-button--medium oxd-button--secondary orangehrm-left-space')]");

    public LeavePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickApplyNavMenuOption() {
        driver.findElement(applyNavMenuOption).click();
        String actual = driver.findElement(By.xpath("//h6[contains(@class,'orangehrm-main-title')]")).getText();
        Assert.isTrue(actual.equals("Apply Leave"), "Expected result does not match with actual result");
    }

    public void fillDetailsForLeave() throws InterruptedException {
        driver.findElement(leaveTypeDropdown).click();
        driver.findElement(By.xpath("//*[contains(text(),'CAN - Bereavement')]")).click();
        driver.findElement(fromDate).sendKeys("2022-09-01");
        driver.findElement(commentsInput).sendKeys("Want to apply for leave");
        driver.findElement(applyLeaveButton).click();
    }
}
