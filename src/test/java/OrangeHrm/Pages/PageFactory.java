package OrangeHrm.Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    private LoginPage loginPage;
    private PimPage pimPage;
    private AdminPage adminPage;
    private LeavePage leavePage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public PimPage getPimPage() {
        if (pimPage == null) {
            pimPage = new PimPage(driver);
        }
        return pimPage;
    }

    public AdminPage getAdminPage() {
        if (adminPage == null) {
            adminPage = new AdminPage(driver);
        }
        return adminPage;
    }

    public LeavePage getLeavePage() {
        if (leavePage == null) {
            leavePage = new LeavePage(driver);
        }
        return leavePage;
    }
}
