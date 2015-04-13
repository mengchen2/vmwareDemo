package com.symbio.skillsoft.admin.usersandgroups;

public class NewGroupModalExt extends NewGroupModal {

    public NewGroupModalExt(){
        this("english");
    }
    
    public NewGroupModalExt(String siteLocale){
        super("siteLocale");
    }
    
    public NewGroupModalExt fill(String groupName, String parent){
        
        SelectGroupModalExt groupModal = new SelectGroupModalExt();
        
        getNameTextField().type(groupName);
        getEditParentGroupLink().click(groupModal);
        groupModal.add(parent, this);
        
        return this;
    }
    
    public UserManagementPage submit(){
        UserManagementPage userManagementPage = new UserManagementPage();
        GroupInfoView groupInfoView = new GroupInfoView();
        clickSaveButton(groupInfoView);
        
        return userManagementPage;
    }
}
