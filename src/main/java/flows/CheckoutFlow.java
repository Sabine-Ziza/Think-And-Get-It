package flows;

import pages.CheckoutPage;

public class CheckoutFlow {

    private CheckoutPage checkoutPage;

    public CheckoutFlow(CheckoutPage checkoutPage) {
        this.checkoutPage = checkoutPage;
    }

    public void completeCheckout(String paymentMethod) {

        checkoutPage.openCheckout();
        checkoutPage.addAddress();
        checkoutPage.setCheckout(paymentMethod);
    }
}

