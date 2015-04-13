package com.symbio.skillsoft.admin;

import com.paypal.selion.annotations.WebTest;
import com.symbio.skillsoft.helpers.AccountHelper;
import com.symbio.skillsoft.helpers.LoginHelper;

import org.testng.annotations.Test;

public class CreateUserTest {

    @Test
    @WebTest(browser = "*firefox")
    public void test() {
        
        // Define user parameters
        String username = "auto-" + (int)(Math.random()*1000000);
        String password = "$kill$0ft";
        String groupname = "SkillSoft";
        String role = "End User";
        
        // Login on skillsoft home page and go to Admin
        LoginHelper.navigateToAdmin();
        
        // Create a user
        AccountHelper.create(username, password, groupname, role);
    }
}
