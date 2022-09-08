package OrangeHrm.Test;

import OrangeHrm.Pages.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {
    protected static PageFactory pageFactory;
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        pageFactory = new PageFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-login-branding']")));
    }

    @AfterClass
    public static void close() throws InterruptedException {
        driver.close();
    }

    public static void logout() {
        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
    }

}
