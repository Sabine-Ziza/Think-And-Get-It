package Authentication;

import base.BaseTest;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout(){
        LoginAsAdmin();
        logoutPage.logoutSection();
    }

}
