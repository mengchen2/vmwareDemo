package extension;

import com.paypal.selion.platform.html.WebPage;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.symbio.skillsoft.VMware.HomePage;
import com.symbio.vmware.utils.Utils;

public class HomePageExt extends HomePage {

    public HomePageExt(){
        this("english");
    }
    
    public HomePageExt(String siteLocale){
        super("siteLocale");
    }
    
    public WebPage buyProduct(){

    	ProductDetailsPageExt productPage = new ProductDetailsPageExt(getSiteLocale());
    	
    	//close an popup. 
    	if (getPopUpButton().isElementPresent()) { 
    	getPopUpButton().click(this);
    	}
    	
    	//click Buy Online link, and wait until the new window fully ;
    	getBuyOnlineLink().clickonly();
    	Utils.switchWindow();
    	WebDriverWaitUtils.waitUntilElementIsVisible(productPage.getQuantityTextField().getLocator());
		return productPage;
    	
    }
    
    

}
