package OrangeHrm.Test;

import OrangeHrm.Pages.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    protected static PageFactory pageFactory;
    static WebDriver driver;

    @Parameters("browserName")
    @BeforeClass
    public static void setup(String browserName) {
        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            pageFactory=new PageFactory(driver);
        }
        else if(browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            pageFactory=new PageFactory(driver);
        }

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
   //     driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
      //  pageFactory = new PageFactory(driver);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-login-branding']")));
    }

    @AfterClass
    public static void close() throws InterruptedException {
        driver.close();
    }

    public static void verification(String locator, String expected) {
        String actual = driver.findElement(By.xpath(locator)).getText();
        Assert.isTrue(actual.equals(expected), "Expected result does not match with actual result");
    }
}
