package OrangeHrm.Test;

import org.testng.annotations.Test;

public class DeleteUser extends BaseClass {
    @Test
    public void login() {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void SearchUser() throws InterruptedException {
        pageFactory.getPimPage().deleteUser();
    }
}
