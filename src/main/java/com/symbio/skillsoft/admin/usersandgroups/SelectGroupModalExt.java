package com.symbio.skillsoft.admin.usersandgroups;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.paypal.selion.platform.html.WebPage;

public class SelectGroupModalExt extends SelectGroupModal {

    public SelectGroupModalExt(){
        this("english");
    }
    
    public SelectGroupModalExt(String siteLocale){
        super("siteLocale");
    }
    
    public WebPage add(String groupName, WebPage expected) throws NoSuchElementException{
        
        // Search for a group based on name
        getSearchGroupNameTextField().type(groupName);
        getSearchButton().click(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(getGroupContainer().getLocator())));
        
        // Select the first result and submit
        getGroupContainer().getGroupNameLabel().clickonly();
        getOkButton().click(expected);
        
        return expected;
    }
}
