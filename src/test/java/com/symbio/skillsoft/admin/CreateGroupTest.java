package com.symbio.skillsoft.admin;

import com.paypal.selion.annotations.WebTest;
import com.symbio.skillsoft.helpers.GroupHelper;
import com.symbio.skillsoft.helpers.LoginHelper;

import org.testng.annotations.Test;

public class CreateGroupTest {

    @Test
    @WebTest
    public void createGrouptest() {
        
        // Randomize a group name to create
        String groupname = "group-" + (int)(Math.random()*1000000);
        String parent = "SkillSoft";
        
        // Login on skillsoft home page and go to Admin
        LoginHelper.navigateToAdmin();
        
        // Create a group
        GroupHelper.create(groupname, parent);
    }
}
