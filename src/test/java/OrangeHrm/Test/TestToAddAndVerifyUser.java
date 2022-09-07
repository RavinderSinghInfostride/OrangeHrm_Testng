package OrangeHrm.Test;

import org.testng.annotations.Test;

public class TestToAddAndVerifyUser extends BaseClass {
    @Test
    public void login() {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void clickAdminMenuOption() {
        pageFactory.getPimPage().clickAdminMenuOption();
    }

    @Test(dependsOnMethods = "clickAdminMenuOption")
    public void addUser() throws InterruptedException {
        pageFactory.getAdminPage().clickAddButton();
        pageFactory.getAdminPage().AddUser();
    }

    @Test(dependsOnMethods = "addUser")
    public void verifyAddedUser() throws InterruptedException {
        pageFactory.getAdminPage().verifyAddedUser();
    }
}
