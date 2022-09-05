package OrangeHrm.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ClickAdminOnMenu extends BaseClass {
    @Test
    public void login() {
        pageFactory.getLoginPage().login();
        verification("//h6", "PIM");
    }

    @Test(dependsOnMethods = "login")
    public void clickAdminMenuOption() {
        pageFactory.getPimPage().clickAdminMenuOption();
        verification("//h6[1]", "Admin");
    }
}
