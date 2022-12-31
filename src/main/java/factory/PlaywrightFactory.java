package factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class PlaywrightFactory {

    static Page page;
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Properties prop;

    public Page initBrowser(Properties prop) {
        String browserName = prop.getProperty("browser").trim();
        System.out.println(" browser Name  " + browserName + " initialized ");

        playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "edge":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
                break;

            default:
                System.out.println("Please pass the right browser name....");
                break;
        }

        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
        page = browserContext.newPage();
        page.navigate(prop.getProperty("url").trim());

        return page;
    }

    /**
     * use to initialize the properties from config file
     */
    public Properties initProp() {
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/properties");
            prop = new Properties();
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}
