package com.symbio.vmware.utils;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.html.WebPage;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.symbio.skillsoft.VMware.HomePage;
import com.symbio.skillsoft.VMware.IndexPage;
import com.symbio.skillsoft.VMware.LoginPage;
import com.symbio.skillsoft.VMware.WorldWidePage;


public class Utils {

	public static String switchWindow(String windowHandler) {
		if (windowHandler !=null && !windowHandler.isEmpty()) {
			Grid.driver().switchTo().window(windowHandler);
			return null;
		}
		
		final String parentHandle = Grid.driver().getWindowHandle();
		for(String handle : Grid.driver().getWindowHandles()) {
			if (!handle.contains(parentHandle)) {
				Grid.driver().switchTo().window(handle);
			}
		}

		SeLionReporter.log(Grid.driver().getTitle(), true, true);
		return parentHandle;
	}
	
	public static String switchWindow() {
		return switchWindow(null);
	}
	
	public static void SelectLanguageHelper(String locale) {
       	Grid.driver().manage().deleteAllCookies(); 
        String url = "http://www.vmware.com";
    	Grid.open(url);
    	SeLionReporter.log(url, true, true);
    	Grid.driver().manage().window().maximize();

    	IndexPage indexPage = new IndexPage();
       	WorldWidePage worldwidePage = new WorldWidePage();

    	//language select method
    	indexPage.getCountryLink().click(worldwidePage);
    	if (locale.equals("en_us")) {
    		worldwidePage.getUsLink().click(indexPage);
    	} else {
    		worldwidePage.getCnLink().click(indexPage);
    	}
	}
	
	public static WebPage loginHelper(String user, String password) {
		IndexPage indexPage = new IndexPage();
    	LoginPage loginPage = new LoginPage();
    	HomePage homePage = new HomePage();
    	
		indexPage.getLoginPageLink().click(loginPage);
    	loginPage.setLoginUsernameTextFieldValue(user);
    	loginPage.setLoginPasswordTextFieldValue(password);
    	SeLionReporter.log("loging info", true, true);
    	WebPage page = (WebPage) loginPage.getLoginButton().clickAndExpectOneOf(homePage);
    	return page;
	}
}
