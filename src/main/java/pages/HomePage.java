package pages;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import utils.Utils;

public class HomePage<T> {

    private Page page;
    //1. String Locators
    private String settingsSideBtn = ".sidebar-link[href='/settings']";
    private String tabsBar = ".nav-tabs";

    //2. HomePage constructor
    public HomePage(Page page) {
        this.page = page;
    }


    //3. page  actions/methods
    public String getHomePageTitle() {
        String title = page.title();
        System.out.printf("page title is  :" + title);
        return title;
    }


    public SettingsPage navigateToSettings() {
        page.click(this.settingsSideBtn);
        return new SettingsPage(page);
    }
}
