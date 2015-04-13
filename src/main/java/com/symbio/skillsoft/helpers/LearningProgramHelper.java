package com.symbio.skillsoft.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.symbio.skillsoft.admin.AdminHomePage;
import com.symbio.skillsoft.admin.content.EditLearningProgramPageExt;
import com.symbio.skillsoft.admin.content.ManageLearningProgramsPage;
import com.symbio.skillsoft.admin.content.NewLearningProgramModalExt;

public class LearningProgramHelper {

    public static void create(String name, String course){
        
        // Initialize web pages
        AdminHomePage adminHomePage = new AdminHomePage();
        ManageLearningProgramsPage learningProgramsPage = new ManageLearningProgramsPage();
        NewLearningProgramModalExt newLearningProgramModal = new NewLearningProgramModalExt();
        EditLearningProgramPageExt editLearningProgramPage = new EditLearningProgramPageExt();
        
        // Navigate to 'Manage Learning Programs'
        adminHomePage.getContentLink().click(ExpectedConditions.presenceOfElementLocated(By.xpath(adminHomePage.getContentContainer().getLocator())));
        adminHomePage.getContentContainer().getLearningProgramsLink().click(learningProgramsPage);

        // Create a new Learning Program
        learningProgramsPage.getNewLearningProgramButton().click(newLearningProgramModal);
        newLearningProgramModal.fill(name, name, "en-us").submit();
        
        // Add a course to the learning program
        editLearningProgramPage.add(course).exit();
        
    }

}
