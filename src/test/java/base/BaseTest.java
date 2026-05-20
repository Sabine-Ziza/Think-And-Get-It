package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.LogoutPage;


import javax.security.auth.login.LoginContext;

public class BaseTest {


    protected Page page;
    private Browser browser;
    private Playwright playwright;

    protected LoginPage loginPage;
    protected LogoutPage logoutPage;

    @BeforeMethod
    public void setUp(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://think-and-get-it-frontend.onrender.com/");
        page.setDefaultTimeout(10000);

        logoutPage = new LogoutPage(page);

    }


    private final String email ="admin@thinkandgetit.com";
    private final String password ="Admin@123456";

    public void LoginAsAdmin(){
         loginPage = new LoginPage(page);
         loginPage.loginSection(email, password);
    }
    @AfterMethod
    public void tearDown(){
        page.close();
        browser.close();
        playwright.close();
    }


    }
