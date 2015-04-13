package com.symbio.skillsoft.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.reports.runtime.WebReporter;
import com.symbio.skillsoft.admin.AdminHomePage;
import com.symbio.skillsoft.frontend.HomePage;
import com.symbio.skillsoft.frontend.LoginPageExt;

public class LoginHelper {

    public static void login(String username, String password){
        
        // Initialize web pages
        LoginPageExt loginPage = new LoginPageExt();
        
        // Open skillsoft website
        Grid.open("http://qatest1vsp80eb.qa.skillport.com");
        Grid.driver().manage().window().maximize();
        
        
        WebReporter.log(Grid.driver().getTitle(), true, true);
        
        // Login
        loginPage.login(username, password);
    }
    
    public static void navigateToAdmin(){
        
        // Initialize web pages
        HomePage homePage = new HomePage();
        AdminHomePage adminHomePage = new AdminHomePage();
        
        // Login with admin account
        LoginHelper.login("admin", "lmsadmin");
        
        // Navigate to 'Admin home'
        homePage.getMenuContainer().getQuickLinksLink().click(ExpectedConditions.presenceOfElementLocated(By.cssSelector(homePage.getQuickLinksContainer().getLocator())));
        homePage.getQuickLinksContainer().getAdminLink().click(adminHomePage);
    }
    
    

}
