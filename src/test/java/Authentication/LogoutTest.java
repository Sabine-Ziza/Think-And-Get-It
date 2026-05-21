package Authentication;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LogoutPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
        LogoutPage logoutPage = new LogoutPage(page);
        loginFlow.loginAsAdmin();
        logoutPage.logoutSection();
        assertThat(page).hasURL("https://think-and-get-it-frontend.onrender.com/");
    }

}
