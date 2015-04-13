package com.symbio.skillsoft.learner;

import com.paypal.selion.annotations.WebTest;
import com.paypal.selion.platform.asserts.SeLionAsserts;
import com.symbio.skillsoft.frontend.HomePage;
import com.symbio.skillsoft.frontend.learningplan.LearningProgramDetailsPage;
import com.symbio.skillsoft.frontend.learningplan.SaveToMyLearningPlanModal;
import com.symbio.skillsoft.frontend.search.SearchResultsCoursesView;
import com.symbio.skillsoft.helpers.AccountHelper;
import com.symbio.skillsoft.helpers.LearningProgramHelper;
import com.symbio.skillsoft.helpers.LoginHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class EnrollLearningProgramTest {

    @Test
    @WebTest(browser = "*firefox")
    public void test() {
        
        // Define user parameters
        String username = "user" + (int)(Math.random()*1000000);
        String password = "$kill$0ft";
        String groupname = "SkillSoft";
        String role = "End User";
        
        // Define learning program
        String lpname = "program" + (int)(Math.random()*1000000);
        String course = "COMM0101";
        
        // Initialize page objects
        HomePage homePage = new HomePage();
        SearchResultsCoursesView courseView = new SearchResultsCoursesView();
        SaveToMyLearningPlanModal saveToMyLearningPlanModal = new SaveToMyLearningPlanModal();
        LearningProgramDetailsPage learningProgramDetailsPage = new LearningProgramDetailsPage();
        
        // Login on skillsoft home page and go to Admin
        LoginHelper.navigateToAdmin();
        
        // Create a user
        AccountHelper.create(username, password, groupname, role);
        
        // Create a learning program
        LearningProgramHelper.create(lpname, course);
        
        // Login with the learner
        LoginHelper.login(username, password);
          
        // Search for the freshly created learning program
        homePage.getHeaderContainer().getSearchTextField().type(lpname);
        homePage.getHeaderContainer().getSearchLink().click(courseView);
        
        // Choose to enroll the learning program
        courseView.getCoursesContainer().getMoreActionsLink().click(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(courseView.getEnrollLink().getLocator())));
        courseView.getEnrollLink().click(
                ExpectedConditions.presenceOfElementLocated(By.xpath(courseView.getYesLink().getLocator())));
        courseView.getYesLink().click(saveToMyLearningPlanModal);
        
        // Save the learning program to the learning plan
        saveToMyLearningPlanModal.getSaveLink().click(
                ExpectedConditions.presenceOfElementLocated(By.xpath(saveToMyLearningPlanModal.getOkLink().getLocator())));
        saveToMyLearningPlanModal.getOkLink().click(courseView);
        
        // Check the learning program details and enrollment status
        courseView.getCoursesContainer().getDetailsLink().click(learningProgramDetailsPage);
        SeLionAsserts.assertTrue(learningProgramDetailsPage.getEnrollmentStatusLabel().getText().contains("Enrolled"));
    }
}
