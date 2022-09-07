package OrangeHrm.Test;

import org.testng.annotations.Test;

public class ClickAdminOnMenu extends BaseClass {
    @Test
    public void login() {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void clickAdminMenuOption() {
        pageFactory.getPimPage().clickAdminMenuOption();
    }
}
