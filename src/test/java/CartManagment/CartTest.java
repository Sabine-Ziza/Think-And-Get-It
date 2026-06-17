package CartManagment;

import base.BaseTest;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test
    public void verifyAddProductToCartFlow() {
        loginFlow.loginAsAdmin();
        cartFlows.addProductToCartFlow();
    }
}
