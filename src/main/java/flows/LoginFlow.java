package flows;

import com.microsoft.playwright.Page;
import pages.LoginPage;
import utils.ConfigLoader;

public class LoginFlow {
    private LoginPage loginPage;

    public LoginFlow(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void loginAsAdmin() {
        loginPage.loginSection(
                ConfigLoader.get("email"),
                ConfigLoader.get("password")
        );
    }
}