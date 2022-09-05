package OrangeHrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PimPage {
    WebDriver driver;
    By adminMenuOption = By.xpath("(//a[@class='oxd-main-menu-item'])[1]");

    public PimPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAdminMenuOption() {
        driver.findElement(adminMenuOption).click();
    }
}
