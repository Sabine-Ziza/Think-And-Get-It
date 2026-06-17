package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class CheckCarts {

    private final Page page;

    public CheckCarts(Page page) {
        this.page = page;
    }

    private String shopNowLink = ".btn-primary";
    private String firstProduct = "(//div[contains(@class,'grid')]//a)[1]";
    private String viewcart = ".btn-ghost";
    private String cartIcon = "button[class='btn-icon relative']";

    public void clickShopNowLink() {
        page.click(shopNowLink);
    }

    public void selectFirstProduct() {
        page.click(firstProduct);
    }

    public void waitForOverlayToDisappear() {
        page.locator(".btn-ghost").first().waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
    }

    public void openCart() {
        page.click(cartIcon);
    }

    public void clickViewCart() {
        page.locator(".btn-ghost").first()
                .click(new Locator.ClickOptions().setForce(true));
        page.click(viewcart);


    }
}