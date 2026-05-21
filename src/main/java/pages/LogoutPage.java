package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LogoutPage {
    private Page page;

    public LogoutPage(Page page) {
        this.page = page;

    }


    private String profileIcon =".lucide.lucide-user";

    public void logoutSection(){

        Locator profile = page.locator(profileIcon);
        profile.waitFor();
        profile.click();

        Locator logoutBtn = page.getByText("Sign out");
        logoutBtn.waitFor();
        logoutBtn.click();
    }
}


