package base;

import com.microsoft.playwright.*;
import flows.CartFlows;
import flows.LoginFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import pages.CheckCarts;
import pages.LoginPage;
import utils.ConfigLoader;

public class BaseTest {

    protected Page page;
    protected Browser browser;
    protected Playwright playwright;

    protected LoginPage loginPage;
    protected LoginFlow loginFlow;
    protected CheckCarts checkCarts;
    protected CartFlows cartFlows;

    @BeforeTest
    public void setUp() {

        playwright = Playwright.create();

        boolean headless = Boolean.parseBoolean(ConfigLoader.get("headless"));

        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(headless));

        page = browser.newPage();

        page.navigate(ConfigLoader.get("baseUrl"));

        page.setDefaultTimeout(
                Integer.parseInt(ConfigLoader.get("timeout"))
        );

        loginPage = new LoginPage(page);
        loginFlow = new LoginFlow(loginPage);
        checkCarts = new CheckCarts(page);
        cartFlows = new CartFlows(checkCarts);
    }

    @AfterMethod
    public void tearDown() {
        if (page != null) {
            page.pause();
            page = null;
        }
        if (browser != null) {
            browser.close();
            browser = null;
        }
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }
}