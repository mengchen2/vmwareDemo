package com.symbio.skillsoft.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.symbio.skillsoft.admin.AdminHomePage;
import com.symbio.skillsoft.admin.usersandgroups.NewUserModalExt;
import com.symbio.skillsoft.admin.usersandgroups.UserManagementPage;

public class AccountHelper {

    public static void create(String username, String password, String groupname, String role){
        
        // Initialize web pages
        AdminHomePage adminHomePage = new AdminHomePage();
        UserManagementPage userManagementPage = new UserManagementPage();
        NewUserModalExt newUserModal = new NewUserModalExt();
        
        // Navigate to 'User Management'
        adminHomePage.getUsersAndGroupsLink().click(ExpectedConditions.presenceOfElementLocated(By.xpath(adminHomePage.getUsersAndGroupsContainer().getLocator())));
        adminHomePage.getUsersAndGroupsContainer().getUserManagementLink().click(userManagementPage);
        
        // Create a new user
        userManagementPage.getNewUserLink().click(newUserModal);
        newUserModal.fill(username, password, groupname, role).submit();
        
    }
}
