package Authentication;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin(){
     LoginAsAdmin();
     assertThat(page).hasURL("https://think-and-get-it-frontend.onrender.com/home");


    }
    @Test
    public void invalidLogin(){
        loginPage = new LoginPage(page);
        loginPage.loginSection("sabine@gmail.com", "12345");
        assertThat(page).hasURL("https://think-and-get-it-frontend.onrender.com/login");



    }

}
