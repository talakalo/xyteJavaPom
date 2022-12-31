package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;
    private String emailId = "input[name='email']";
    private String passwordId = "input[name='password']";
    private String forgotPwdLink = "a.mantine-Group-child";
    private String loginBtn = "button[type='submit']";
    private String loginText = ".auth-page-title";

    public LoginPage(Page page) {
        this.page = page;
    }

    public String getLoginPageText() {
        return page.innerText(this.loginText);
    }

    public boolean isForgotPwdLinkExist() {
        return page.isVisible(forgotPwdLink);
    }

    public HomePage doLogin(String userName, String password) {
        if (page.isVisible(loginText)) {
            page.fill(emailId, userName);
            page.fill(passwordId, password);
            page.click(loginBtn);
            return new HomePage(page);
        }
        return null;
    }
}
