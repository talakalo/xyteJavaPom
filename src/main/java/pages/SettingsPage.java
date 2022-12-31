package pages;

import com.microsoft.playwright.Page;

public class SettingsPage {

    private String groupsTab = "#groups-tab";
    private Page page;

    public SettingsPage(Page page) {
        this.page = page;
    }

    public GroupsPage navigateToGroupsTab() {

        page.click(this.groupsTab);
        return new GroupsPage(page);
    }


}
