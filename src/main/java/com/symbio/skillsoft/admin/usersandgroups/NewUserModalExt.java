package com.symbio.skillsoft.admin.usersandgroups;

public class NewUserModalExt extends NewUserModal {

    public NewUserModalExt(){
        this("english");
    }
    
    public NewUserModalExt(String siteLocale){
        super("siteLocale");
    }
    
    public NewUserModalExt fill(String username, String password, String groupname, String role){
        
        SelectGroupsModalExt groupModal = new SelectGroupsModalExt();
        
        getUsernameTextField().type(username);
        getPasswordTextField().type(password);
        getVerifyPasswordTextField().type(password);
        
        getEditGroupMembershipLink().click(groupModal);
        groupModal.add(groupname, this);
        
        selectRoleSelectListByLabel(role);
        
        return this;
    }
    
    public UserManagementPage submit(){
        UserManagementPage userManagementPage = new UserManagementPage();
        UserInfoView userInfoView = new UserInfoView();
        clickSaveButton(userInfoView);
        
        return userManagementPage;
    }
}
