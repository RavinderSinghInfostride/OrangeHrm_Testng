package OrangeHrm.Test;

import org.testng.annotations.Test;

public class LeaveEntitlementsAndUsageReport extends BaseClass {
    @Test
    public void login() {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void leaveMenuOptionClick() {
        pageFactory.getPimPage().clickLeaveMenuOption();
    }

    @Test(dependsOnMethods = "leaveMenuOptionClick")
    public void leaveEntitlementUsageReport() throws InterruptedException {
        pageFactory.getLeavePage().leaveEntitlementReportGenerate();
    }
}