package utils;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class Utils {

    static Page page;
    public enum pages{
        homePage,
        settingsPage
    }
    public static String takeScreenShot() {
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + "png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        return path;
    }
}
