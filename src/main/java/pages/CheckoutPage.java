package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import utils.ConfigLoader;

public class CheckoutPage {

    private Page page;


    private Locator checkoutBtn;
    private Locator addAddressBtn;
    private Locator saveAddressBtn;
    private Locator continueCheckoutBtn;

    private Locator firstNameField;
    private Locator lastNameField;
    private Locator phoneNumber;
    private Locator streetAddress;
    private Locator city;
    private Locator state;
    private Locator country;
    private Locator postalCode;


    private Locator cashOption;
    private Locator bankTransferOption;
    private Locator mobileMoneyOption;


    public CheckoutPage(Page page) {
        this.page = page;

        checkoutBtn = page.locator(".btn-primary:has-text('Checkout')");
        addAddressBtn = page.locator(".card.p-4.w-full");
        saveAddressBtn = page.locator("button[type='submit']");
        continueCheckoutBtn = page.locator(".btn-primary.w-full.py-4.flex.items-center.justify-center.gap-2.mt-2");

        firstNameField = page.locator("input[placeholder='First name']");
        lastNameField = page.locator("input[placeholder='Last name']");
        phoneNumber = page.locator("input[placeholder='Phone number']");
        streetAddress = page.locator("input[placeholder='Street address']");
        city = page.locator("input[placeholder='City']");
        state = page.locator("input[placeholder='State / Region']");
        country = page.locator("input[placeholder='Country']");
        postalCode = page.locator("input[placeholder='Postal code (optional)']");


        cashOption = page.locator("text=Cash on Delivery");
        bankTransferOption = page.locator("//div[contains(.,'Bank')]");
        mobileMoneyOption = page.locator("//div[contains(.,'Mobile')]");

    }

    public void openCheckout() {
        checkoutBtn.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));

        checkoutBtn.click();


    }

    public void addAddress() {
        addAddressBtn.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        addAddressBtn.click();
        firstNameField.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(15000));
    }

    public void fillForm() {
        firstNameField.fill(ConfigLoader.get("firstName"));
        lastNameField.fill(ConfigLoader.get("lastName"));
        phoneNumber.fill(ConfigLoader.get("phone"));
        streetAddress.fill(ConfigLoader.get("streetAddress"));
        city.fill(ConfigLoader.get("city"));
        state.fill(ConfigLoader.get("state"));
        country.fill(ConfigLoader.get("country"));
        postalCode.fill(ConfigLoader.get("postalCode"));


    }

    public void saveAddress() {
        saveAddressBtn.waitFor();
        saveAddressBtn.click();
    }

    public void continueCheckout() {
        continueCheckoutBtn.waitFor();
        continueCheckoutBtn.click();
    }

    public void selectPayment(String method) {

        switch (method.toLowerCase()) {

            case "cash":
                cashOption.click();
                break;

            case "bank":
                bankTransferOption.click();
                break;

            case "mobile":
                mobileMoneyOption.click();
                break;

            default:
                throw new RuntimeException("Invalid payment method: " + method);

        }

    }

    public void setCheckout(String paymentMethod) {
        fillForm();
        saveAddress();
        continueCheckout();
        selectPayment(paymentMethod);
    }
}