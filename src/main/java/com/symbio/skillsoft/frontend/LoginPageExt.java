package com.symbio.skillsoft.frontend;

import com.paypal.selion.platform.html.WebPage;

public class LoginPageExt extends LoginPage {

    public LoginPageExt(){
        this("english");
    }
    
    public LoginPageExt(String siteLocale){
        super("siteLocale");
    }
    
    public WebPage login(String userName, String password){
        
        HomePage homePage = new HomePage();
        
        getUserNameTextField().type(userName);
        getPasswordTextField().type(password);
        clickSignInLink(homePage);
        
        return homePage;
    }
}
