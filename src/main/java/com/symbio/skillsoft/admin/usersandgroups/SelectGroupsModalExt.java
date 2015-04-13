package com.symbio.skillsoft.admin.usersandgroups;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.paypal.selion.platform.html.Link;
import com.paypal.selion.platform.html.WebPage;

public class SelectGroupsModalExt extends SelectGroupsModal {

    public SelectGroupsModalExt(){
        this("english");
    }
    
    public SelectGroupsModalExt(String siteLocale){
        super("siteLocale");
    }
    
    public WebPage add(String groupName, WebPage expected) throws NoSuchElementException{
        
        String groupLocator = "//div[@id='user_group_tree'] //span[contains(text(),'" + groupName + "')]";
        Link groupLink = new Link(groupLocator);
        
        if (!groupLink.isElementPresent()){
            throw new NoSuchElementException("Group with following locator not found: " + groupLocator);
        }
        
        groupLink.clickonly(); // Highlight the group in the tree
        getAddLink().click(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(this.getGroupMembershipContainer().getLocator())));
        getOkButton().click(expected);
        
        return expected;
    }
}
