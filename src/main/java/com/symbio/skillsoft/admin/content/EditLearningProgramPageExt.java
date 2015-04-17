package com.symbio.skillsoft.admin.content;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;

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
        
    	SearchResultsView resultsView = new SearchResultsView();
    	
        // Search for a course
        getSearchTextField().type(text);
        getSearchButton().click(ExpectedConditions.presenceOfElementLocated(By.cssSelector(resultsView.getCoursesContainer().getLocator())));

        // Add the first result
        WebDriverWaitUtils.waitUntilElementIsPresent(resultsView.getCoursesContainer().getCourseLabel().getLocator());
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
