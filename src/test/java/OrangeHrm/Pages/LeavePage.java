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

    //TC-02
    String navMenuReports = "Reports";
    By generateLeaveReportBtn = By.xpath("//div[contains(@class,'oxd-form-actions')]//button[contains(@class,'oxd-button')]");

    public LeavePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickApplyNavMenuOption() {
        driver.findElement(By.xpath(String.format("//div[@class='oxd-topbar-body']//li[contains(text(),'')]/a[contains(text(),'%s')]", navMenuApply))).click();
        String actual = driver.findElement(By.xpath("//h6[contains(@class,'orangehrm-main-title')]")).getText();
        Assert.isTrue(actual.equals("Apply Leave"), "Expected result does not match with actual result");
    }

    public void fillDetailsForLeave() {
        driver.findElement(leaveTypeDropdown).click();
        driver.findElement(By.xpath("//*[contains(text(),'CAN - Bereavement')]")).click();
        driver.findElement(toDate).sendKeys(toDateValue);
        driver.findElement(fromDate).sendKeys(fromDateValue);
        driver.findElement(commentsInput).sendKeys("Ravinder wants to apply for leave");
        driver.findElement(toDate).clear();
        driver.findElement(applyLeaveButton).click();
    }

    public void verifyLeave() {
        driver.findElement(By.xpath(String.format("//div[@class='oxd-topbar-body']//li/a[contains(text(),'%s')]", navMenuMyLeave))).click();
        String actual = driver.findElement(By.xpath("//div[contains(text(),'Ravinder wants to apply for leave')]")).getText();
        Assert.isTrue(actual.equals("Ravinder wants to apply for leave"), "Expected result does not match with actual result");
    }

    //TC-02
    public void leaveEntitlementReportGenerate() throws InterruptedException {
        driver.findElement(By.xpath(String.format("//li//span[(@class='oxd-topbar-body-nav-tab-item') and (contains(text(),'%s'))]", navMenuReports))).click();
        driver.findElement(By.xpath("//header/div[2]/nav[1]/ul[1]/li[4]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Leave Entitlements and Usage Report')]")).click();
        String actual = driver.findElement(By.xpath("//div[@class='oxd-table-filter-header']//h5")).getText();
        Assert.isTrue(actual.equals("Leave Entitlements and Usage Report"), "Expected result does not match with actual result");
        Thread.sleep(2000);
        driver.findElement(generateLeaveReportBtn).click();
        String actual2 = driver.findElement(By.xpath("//div[contains(text(),'Leave Entitlements (Days)')]")).getText();
        Assert.isTrue(actual2.equals("Leave Entitlements (Days)"), "Expected result does not match with actual result");
    }
}
