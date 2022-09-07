package OrangeHrm.Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeavePage {
    WebDriver driver;
    String navMenuApply = "Apply";
    By leaveTypeDropdown = By.xpath("//div[contains(@class,'oxd-select-text--active')]");
    By fromDate = By.xpath("(//div[contains(@class,'oxd-date-input')]/input)[1]");
    By toDate = By.xpath("(//div[contains(@class,'oxd-date-input')]/input)[2]");
    By commentsInput = By.xpath("//textarea[contains(@class,'oxd-textarea')]");
    By applyLeaveButton = By.xpath("//button[contains(@class,'oxd-button--medium oxd-button--secondary orangehrm-left-space')]");
    String fromDateValue = "2022-09-01";
    String toDateValue = "2022-09-02";

    //Verify leave applied is added
    String navMenuMyLeave = "My Leave";

    public LeavePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickApplyNavMenuOption() {
        driver.findElement(By.xpath(String.format("//div[@class='oxd-topbar-body']//li[contains(text(),'')]/a[contains(text(),'%s')]", navMenuApply))).click();
        String actual = driver.findElement(By.xpath("//h6[contains(@class,'orangehrm-main-title')]")).getText();
        Assert.isTrue(actual.equals("Apply Leave"), "Expected result does not match with actual result");
    }

    public void fillDetailsForLeave() throws InterruptedException {
        driver.findElement(leaveTypeDropdown).click();
        driver.findElement(By.xpath("//*[contains(text(),'CAN - Bereavement')]")).click();
        driver.findElement(toDate).sendKeys(toDateValue);
        driver.findElement(fromDate).sendKeys(fromDateValue);
        driver.findElement(commentsInput).sendKeys("Ravinder wants to apply for leave");
        driver.findElement(toDate).clear();
        driver.findElement(applyLeaveButton).click();
    }

    public void verifyLeave() {
        driver.findElement(By.xpath(String.format("//div[@class='oxd-topbar-body']//li[contains(text(),'')]/a[contains(text(),'%s')]", navMenuMyLeave))).click();
        String actual = driver.findElement(By.xpath("//div[contains(text(),'Ravinder wants to apply for leave')]")).getText();
        Assert.isTrue(actual.equals("Ravinder wants to apply for leave"), "Expected result does not match with actual result");
    }
}
