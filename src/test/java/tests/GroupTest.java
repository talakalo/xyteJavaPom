package tests;

import base.BaseTest;
import constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupTest extends BaseTest {


    @Test(priority = 1)
    public void createNewGroupTest() throws InterruptedException {
        System.out.println("create New Group Test started");
        String groupName = prop.getProperty("groupName");
        String actMessage;
        System.out.println("navigating To Settings");
        settingsPage = homePage.navigateToSettings();

        System.out.println("navigating To Groups Tab");
        groupsPage = settingsPage.navigateToGroupsTab();

        addAccessPopup = groupsPage.clickCreateGroupBtn();
        addAccessPopup.setGroupName(groupName);

        addAccessPopup.clickCreateButton();
        actMessage = groupsPage.printToastMessage();
        Assert.assertEquals(actMessage, AppConstants.SUCCESSFUL_TOAST_MESSAGE);
        groupsPage.searchGroupAndAssertCreation(groupName);
        System.out.println("Create New Group Test Ended  \n\n\n\n");


    }

    @Test(priority = 2)
    public void createExistingGroupTest() throws InterruptedException {
        System.out.println("create Existing Group Test started");
        String groupName = prop.getProperty("groupName2");
        String actMessage;
        System.out.println("navigating To Settings");
        settingsPage = homePage.navigateToSettings();

        System.out.println("navigating To Groups Tab");
        groupsPage = settingsPage.navigateToGroupsTab();

        addAccessPopup = groupsPage.clickCreateGroupBtn();
        addAccessPopup.setGroupName(groupName);
        addAccessPopup.clickCreateButton();
        actMessage = groupsPage.printToastMessage();
        Assert.assertEquals(actMessage, AppConstants.ERROR_TOAST_MESSAGE);
        addAccessPopup.clickClosButton();
        groupsPage.searchGroupAndAssertCreation(groupName);
        System.out.println("Create Existing Group Test Ended");

    }


}
