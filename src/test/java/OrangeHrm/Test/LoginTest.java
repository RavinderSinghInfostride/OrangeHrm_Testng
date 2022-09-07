package OrangeHrm.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
    @Test
    public void login() {
        pageFactory.getLoginPage().login();
    }
}
