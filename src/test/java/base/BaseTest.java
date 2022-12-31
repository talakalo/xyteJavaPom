package base;

import com.microsoft.playwright.Page;
import constants.AppConstants;
import factory.PlaywrightFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;

import java.util.Properties;

public class BaseTest extends Exception{

    PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    protected HomePage homePage;
    protected LoginPage loginPage;

    protected SettingsPage settingsPage;
    protected AddAccessDialog addAccessPopup;

    protected GroupsPage groupsPage;

    @BeforeTest
    public void setup() {
        pf = new PlaywrightFactory();
        prop = pf.initProp();
        page = pf.initBrowser(prop);
        loginPage = new LoginPage(page);
        String actLoginPageText = loginPage.getLoginPageText();
        System.out.println("Login Page act text : " + actLoginPageText);
        Assert.assertEquals(actLoginPageText, AppConstants.LOGIN_PAGE_TEXT);

        String userName = prop.getProperty("username").trim();
        String password = prop.getProperty("password").trim();
        System.out.println("doLogin method called");
        homePage = loginPage.doLogin(userName, password);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }
}
