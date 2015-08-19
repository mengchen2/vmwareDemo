package com.symbio.vmware.learner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paypal.selion.annotations.WebTest;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.symbio.skillsoft.VMware.HomePage;
import com.symbio.vmware.dataobjects.Myobject;
import com.symbio.vmware.utils.MultiDataProvider;
import com.symbio.vmware.utils.Utils;

import extension.HomePageExt;
import extension.ProductDetailsPageExt;
import extension.QuickBuyCardPageExt;

public class vmwareDemoTest {

	@DataProvider(name = "multiDataProvider")
	public Object[][] multiDataProvider() throws Exception {
	   return  MultiDataProvider.multiDataProvider(Myobject.class, "multiDataProvider");
	}
	
    @WebTest  
    @Test(dataProvider = "multiDataProvider",groups={"P0"})
    public void test(Myobject data) {

    	//initiates
    	HomePageExt homePage = new HomePageExt(data.getLocale());
    	ProductDetailsPageExt productPage = new ProductDetailsPageExt(data.getLocale());
    	QuickBuyCardPageExt quickBuyCardPage = new QuickBuyCardPageExt(data.getLocale());
       	
    	//Select Languages and get login
    	Utils.SelectLanguageHelper(data.getLocale());
    	Utils.loginHelper(data.getUser(), data.getPassword());
    	
    	//select product from user HomePage, fill values to next form and submit it. 
    	homePage.buyProduct();
    	productPage.fill().submit();
    	quickBuyCardPage.fill(data.getState()).submit();
    	}
}
