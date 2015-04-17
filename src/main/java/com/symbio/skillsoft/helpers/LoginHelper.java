package com.symbio.skillsoft.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.html.Link;
import com.paypal.selion.reports.runtime.WebReporter;
import com.symbio.skillsoft.admin.AdminHomePage;
import com.symbio.skillsoft.frontend.HomePage;
import com.symbio.skillsoft.frontend.LoginPageExt;
import com.symbio.skillsoft.frontend.profile.ChooseSiteLanguageModal;
import com.symbio.skillsoft.frontend.profile.LanguagesPage;
import com.symbio.skillsoft.frontend.profile.PersonalInfoPage;

public class LoginHelper {

    public static void login(String username, String password){
        
        // Initialize web pages
        LoginPageExt loginPage = new LoginPageExt();
        
        // Open skillsoft website
        Grid.open("http://qatest1vsp80bd.qa.skillport.com");
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
    
    public static void changeLanguage(String username, String password, String language){
        
    	if (!language.equalsIgnoreCase("english")){
    		
    		String localizedLanguage = "english";
    		
    		switch (language){
	    		case "italian":
	    			localizedLanguage = "Italiano";
	    			break;
    		}
    		
	        // Initialize web pages
	        HomePage homePage = new HomePage();
	        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
	        LanguagesPage languagePage = new LanguagesPage();
	        ChooseSiteLanguageModal chooseLanguageModal = new ChooseSiteLanguageModal();
	        
	        // Login with the learner
	        LoginHelper.login(username, password);
	        
	        // Navigate to profile and language preferences
	        homePage.getHeaderContainer().getProfileLink().click(personalInfoPage);
	        personalInfoPage.getLanguagesLink().click(languagePage);
	        
	        // Open the site language selection modal
	        languagePage.getSiteLanguageEditLink().click(chooseLanguageModal);
	        
	        // Choose the language
	        for (int i=0;i<chooseLanguageModal.getLanguageContainer().size();i++){
	        	Link currentLink = chooseLanguageModal.getLanguageContainer(i).getLanguageLink();
	        	
	        	if (currentLink.getText().equalsIgnoreCase(localizedLanguage)){
	        		currentLink.hover();
	        		currentLink.clickonly();
	        	}
	        }
	        
	        chooseLanguageModal.getDoneLink().click(languagePage);
	        
	        // Update the settings
	        languagePage.getUpdateLink().click(languagePage);
	        
	        // Logout
	        languagePage.getMenuContainer().getWhatsNewLink().click(homePage);
	        homePage.getHeaderContainer().getLogOutLink().click();
    	}
    }

}
