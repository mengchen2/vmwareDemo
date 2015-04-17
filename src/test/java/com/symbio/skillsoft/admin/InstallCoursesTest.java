package com.symbio.skillsoft.admin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.paypal.selion.annotations.WebTest;
import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.WebReporter;
import com.symbio.skillsoft.admin.content.ContentInstallerPage;
import com.symbio.skillsoft.helpers.AccountHelper;
import com.symbio.skillsoft.helpers.LoginHelper;
import com.thoughtworks.selenium.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class InstallCoursesTest {

    @Test
    @WebTest(browser = "*firefox")
    public void test() throws Exception {
        
        // Define user parameters
        String username = "auto-" + (int)(Math.random()*1000000);
        String password = "$kill$0ft";
        String groupname = "SkillSoft";
        String role = "End User";
        
        // Login on skillsoft home page and go to Admin
        LoginHelper.navigateToAdmin();
        
        // Initialize web pages
        AdminHomePage adminHomePage = new AdminHomePage();
        ContentInstallerPage contentInstallerPage = new ContentInstallerPage();
        
        // Navigate to 'Content Installer' from menu
        adminHomePage.getContentLink().click(ExpectedConditions.presenceOfElementLocated(By.xpath(adminHomePage.getContentContainer().getLocator())));
        adminHomePage.getContentContainer(1).getContentInstallerLink().clickonly(); // a new window will open
        
        // Wait for the new window to be fully loaded
        final String parentHandle = Grid.driver().getWindowHandle();
        new Wait() {
            @Override
            public boolean until() {
                for(String handle : Grid.driver().getWindowHandles()) {
                    if (!handle.contains(parentHandle)) {
                        Grid.driver().switchTo().window(handle);
                        return true;
                    }
                }
                return false;
            }
        }.wait("Waiting for a new window appear.", 120000, 5000);
        
        Grid.driver().switchTo().frame("mainframe");
        Grid.driver().switchTo().frame("c");
        WebDriverWaitUtils.waitUntilElementIsPresent(contentInstallerPage.getUninstalledCoursesSelectList().getLocator());
        WebReporter.log(Grid.driver().getTitle(), true, true);
        
        
        String input = Grid.driver().getPageSource();
        Pattern pattern = Pattern.compile("(?<=Uninstalled Courses \\()([0-9]+)(?=\\))"); //Uninstalled Courses (30632)
        Matcher matcher = pattern.matcher(input);
        
        int nb = 9999;
        
        if (matcher.find())
        {
            nb = Integer.valueOf(matcher.group());
            System.out.println(nb);
        }
        else{
        	throw new Exception("No courses found");
        }
        
        // Select one course to install
        //String[] indexes = {"0","1","2","3","4","5","6","7","8","9"};
        //System.out.println("lenght : " + contentInstallerPage.getUninstalledCoursesSelectList().getContentValue().length);
        //contentInstallerPage.getUninstalledCoursesSelectList().selectByIndex(indexes);
        while (nb > 0){
        
        	if (nb > 50){
		        for (int i=0; i<50; i++){
		        	contentInstallerPage.getUninstalledCoursesContainer(i).clickonly();
		        }
        	}else{
		        for (int i=0; i<(nb-1); i++){
		        	contentInstallerPage.getUninstalledCoursesContainer(i).clickonly();
		        }
        	}
	        contentInstallerPage.getInstallCourseButton().clickonly();
        
	        // Confirm the javascript alert
	        Grid.driver().switchTo().alert().accept();
	        WebDriverWaitUtils.waitUntilElementIsPresent(contentInstallerPage.getUninstalledCoursesSelectList().getLocator());
	        
	        input = Grid.driver().getPageSource();
	        matcher = pattern.matcher(input);
	        
	        if (matcher.find())
	        {
	            nb = Integer.valueOf(matcher.group());
	            System.out.println(nb);
	        }
	        else{
	        	throw new Exception("No courses found");
	        }
        }
        
        WebReporter.log(Grid.driver().getTitle(), true, true);
        
        //System.out.println("lenght : " + contentInstallerPage.getUninstalledCoursesSelectList().getContentValue().length);
    }
}
