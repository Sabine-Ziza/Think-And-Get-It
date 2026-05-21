package flows;

import pages.CheckCarts;

public class CartFlows {

    private final CheckCarts checkCarts;

    public CartFlows(CheckCarts checkCarts) {
        this.checkCarts = checkCarts;
    }

    public void addProductToCartFlow() {
        checkCarts.clickShopNowLink();
        checkCarts.selectFirstProduct();
        checkCarts.openCart();
        checkCarts.waitForOverlayToDisappear();
        checkCarts.clickViewCart();
    }
}

