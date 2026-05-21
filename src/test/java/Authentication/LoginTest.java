package Authentication;

import base.BaseTest;
import flows.LoginFlow;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigLoader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {

        loginFlow.loginAsAdmin();
        assertThat(page).hasURL("https://think-and-get-it-frontend.onrender.com/home");

    }

    @Test
    public void invalidLogin() {
        loginPage.loginSection(ConfigLoader.get("invalidEmail"), ConfigLoader.get("invalidPassword"));
        assertThat(page).hasURL("https://think-and-get-it-frontend.onrender.com/login");
        assertThat(page.locator(".go2072408551")).isVisible();


    }

}
