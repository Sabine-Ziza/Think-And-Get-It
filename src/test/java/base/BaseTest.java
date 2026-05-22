package base;

import com.microsoft.playwright.*;
import flows.CartFlows;
import flows.CheckoutFlow;
import flows.LoginFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.CheckCarts;
import pages.CheckoutPage;
import pages.LoginPage;
import utils.ConfigLoader;

public class BaseTest {

    protected Page page;
    protected Browser browser;
    protected Playwright playwright;

    protected LoginPage loginPage;
    protected  CheckoutPage checkoutPage;
    protected CheckCarts checkCarts;

    protected LoginFlow loginFlow;
    protected CartFlows cartFlows;
    protected CheckoutFlow checkoutFlow;


    @BeforeMethod
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
        checkCarts = new CheckCarts(page);
        checkoutPage = new CheckoutPage(page);

        loginFlow = new LoginFlow(loginPage);
        cartFlows = new CartFlows(checkCarts);
        checkoutFlow = new CheckoutFlow(checkoutPage);
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