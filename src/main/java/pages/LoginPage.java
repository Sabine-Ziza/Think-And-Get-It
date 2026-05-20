package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;


    public LoginPage(Page page){
        this.page = page;
    }
    private String signInBtn = ".btn-ghost";
    private String emailInput = "input[placeholder='you@example.com']";
    private String passwordInput =".pr-12";
    private String button = ".btn-primary";

    public void loginSection(String email, String password){
        page.click(signInBtn);
        page.fill(emailInput, email);
        page.fill(passwordInput, password);
        page.click(button);



    }



}
