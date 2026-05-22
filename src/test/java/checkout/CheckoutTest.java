package checkout;

import base.BaseTest;
import com.microsoft.playwright.Page;
import flows.CheckoutFlow;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckoutTest extends BaseTest {
    @Test
    public void testCheckout() {
        loginFlow.loginAsAdmin();
        cartFlows.addProductToCartFlow();
        checkoutFlow.completeCheckout("cash");
        System.out.println("URL = " + page.url());
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("debug.png")));

    }
}
