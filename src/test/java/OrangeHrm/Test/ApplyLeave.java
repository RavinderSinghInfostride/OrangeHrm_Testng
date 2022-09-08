package OrangeHrm.Test;

import org.testng.annotations.Test;

public class ApplyLeave extends BaseClass {
    @Test
    public void login() {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void leaveMenuOptionClick() {
        pageFactory.getPimPage().clickLeaveMenuOption();
    }

    @Test(dependsOnMethods = "leaveMenuOptionClick")
    public void applyLeave() throws InterruptedException {
        pageFactory.getLeavePage().clickApplyNavMenuOption();
        pageFactory.getLeavePage().fillDetailsForLeave();
    }

    @Test(dependsOnMethods = "applyLeave")
    public void verifyLeave() {
        pageFactory.getLeavePage().verifyLeave();
    }
}