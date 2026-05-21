package Authentication;

import base.BaseTest;
import flows.LoginFlow;
import org.testng.annotations.Test;
import pages.LoginPage;

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
        loginPage.loginSection("invalidEmail", "invalidPassword");
        assertThat(page).hasURL("https://think-and-get-it-frontend.onrender.com/login");


    }

}
