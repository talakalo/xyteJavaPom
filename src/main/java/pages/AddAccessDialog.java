package pages;


import com.microsoft.playwright.Page;


public class AddAccessDialog {
    private String createBtnPopup = "button.mantine-Button-root[type='submit']";
    private String popupxBtn = "[aria-label='Close']";
    private String closePopupBtn = "//span[normalize-space()='Close']";
    private String groupNameInput = "input[placeholder='Group Name']";
    private String alertdialog = "[role='alertdialog']";
    private Page page;

    public AddAccessDialog(Page page) {
        this.page = page;
    }

    public void setGroupName(String groupName) {
        System.out.println("setGroupName method called with :" + groupName);
        page.fill(this.groupNameInput, groupName);
    }

    public void clickCreateButton() throws InterruptedException {
        page.click(this.createBtnPopup);
    }
    public GroupsPage clickClosButton() throws InterruptedException {
        page.click(this.closePopupBtn);
        return new GroupsPage(page);
    }
}
