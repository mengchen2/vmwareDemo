package com.symbio.skillsoft.admin.content;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditLearningProgramPageExt extends EditLearningProgramPage {

    public EditLearningProgramPageExt(){
        this("english");
    }
    
    public EditLearningProgramPageExt(String siteLocale){
        super("siteLocale");
    }
    
    public EditLearningProgramPageExt search(){
        

        return this;
    }
    
    public EditLearningProgramPageExt add(String text){
        
        // Search for a course
        getSearchTextField().type(text);
        getSearchButton().click(ExpectedConditions.presenceOfElementLocated(By.cssSelector(getSearchResultViewLabel().getLocator())));

        // Add the first result
        SearchResultsView resultsView = new SearchResultsView();
        resultsView.getCoursesContainer().getCourseLabel().clickonly();
        getAddButton().click(this);

        // Save
        getSaveButton().click(ExpectedConditions.presenceOfElementLocated(By.xpath(getOkButton().getLocator())));
        getOkButton().click(this);
        
        return this;
    }
    
    public ManageLearningProgramsPage exit(){
        
        ManageLearningProgramsPage learningProgramsPage = new ManageLearningProgramsPage();
        getExitButton().click(learningProgramsPage);
        
        return learningProgramsPage;
    }
}
