package pages;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ElementState;
import constants.AppConstants;
import org.testng.Assert;




public class GroupsPage {
    private final Page page;
    private String createGroupBtn = "button.mantine-Button-filled";

    private String addAccessPopup = ".modal-content";

    private String messageToast = "[role='alertdialog']";
    private String message = "Name has already been taken";
    private String searchInput = "input[placeholder='Search...']";
    private String searchIcon = "div.mantine-TextInput-rightSection";


    public GroupsPage(Page page) {
        this.page = page;
    }

    public AddAccessDialog clickCreateGroupBtn()  {
        if (page.isVisible(messageToast)) {
            page.waitForSelector(messageToast).waitForElementState(ElementState.HIDDEN);
        }
        page.click(this.createGroupBtn);
        Assert.assertTrue(page.isVisible(addAccessPopup));
        return new AddAccessDialog(page);
    }

    public String printToastMessage() {
        String toastMessage = page.innerText(messageToast);
        System.out.println("toast message: " + toastMessage);
        if (toastMessage.equals(AppConstants.SUCCESSFUL_TOAST_MESSAGE)) {
            System.out.println("new Group Created Successfully : " + toastMessage);
        } else if (toastMessage.equals(AppConstants.ERROR_TOAST_MESSAGE)) {
            System.out.println("Group is already exists : " + toastMessage);

        }

        return toastMessage;
    }

//    public Locator getGroup(String groupName) {
//        return page.locator(groupName).isVisible();
//    }

    public void searchGroupAndAssertCreation(String groupName) {
        String groupText = "//*[contains(text()," + groupName + ")]";
        System.out.println(" searchGroupAndAssertCreation method called:");
        page.fill(searchInput, groupName);
        page.click(this.searchIcon);
        Assert.assertTrue(page.isVisible(groupText), "Group " + groupName + " found in Search");
    }
}
