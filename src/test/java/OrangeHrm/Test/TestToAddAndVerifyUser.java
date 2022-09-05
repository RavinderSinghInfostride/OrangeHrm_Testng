package OrangeHrm.Test;

import org.testng.annotations.Test;

public class TestToAddAndVerifyUser extends BaseClass {
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

    @Test(dependsOnMethods = "clickAdminMenuOption")
    public void addUser() throws InterruptedException {
        pageFactory.getAdminPage().clickAddButton();
        verification("(//h6)[2]", "Add User");
        pageFactory.getAdminPage().AddUser();
    }

    @Test(dependsOnMethods = "addUser")
    public void verifyAddedUser() throws InterruptedException {
        pageFactory.getAdminPage().verifyAddedUser();
    }
}
