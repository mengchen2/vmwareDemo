package com.symbio.skillsoft.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.symbio.skillsoft.admin.AdminHomePage;
import com.symbio.skillsoft.admin.usersandgroups.NewGroupModalExt;
import com.symbio.skillsoft.admin.usersandgroups.UserManagementPage;

public class GroupHelper {

    public static void create(String groupname, String parent){
        
        // Initialize web pages
        AdminHomePage adminHomePage = new AdminHomePage();
        UserManagementPage userManagementPage = new UserManagementPage();
        NewGroupModalExt newGroupModal = new NewGroupModalExt();
        
        // Navigate to 'User Management'
        adminHomePage.getUsersAndGroupsLink().click(ExpectedConditions.presenceOfElementLocated(By.xpath(adminHomePage.getUsersAndGroupsContainer().getLocator())));
        adminHomePage.getUsersAndGroupsContainer().getUserManagementLink().click(userManagementPage);
        
        // Create a new group
        userManagementPage.getNewGroupLink().click(newGroupModal);
        newGroupModal.fill(groupname, parent).submit();
    }
}
