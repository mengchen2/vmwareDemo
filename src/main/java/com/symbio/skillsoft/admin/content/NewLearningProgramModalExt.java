package com.symbio.skillsoft.admin.content;

public class NewLearningProgramModalExt extends NewLearningProgramModal {

    public NewLearningProgramModalExt(){
        this("english");
    }
    
    public NewLearningProgramModalExt(String siteLocale){
        super("siteLocale");
    }
    
    public NewLearningProgramModalExt fill(String name, String id, String language){
        
        super.getNameTextField().type(name);
        super.getIdTextField().type(id);
        super.selectContentLanguageSelectListByValue(language);

        return this;
    }
    
    public EditLearningProgramPage submit(){
        EditLearningProgramPage editLearningProgramPage = new EditLearningProgramPage();
        
        getSaveButton().click(editLearningProgramPage);
        return editLearningProgramPage;
    }
}
