package extension;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.html.WebPage;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.symbio.skillsoft.VMware.ProductDetailsPage;
import com.symbio.skillsoft.VMware.QuickBuyCardPage;

public class ProductDetailsPageExt extends ProductDetailsPage {

    public ProductDetailsPageExt(){
        this("english");
    }
    
    public ProductDetailsPageExt(String siteLocale){
        super("siteLocale");
    }
    
    public ProductDetailsPageExt fill(){
        
    	setQuantityTextFieldValue("2");
    	SeLionReporter.log("quantity updated", true, true);
        
        return this;
    }
    
    public WebPage submit(){
        final QuickBuyCardPage quickBuyCardPage = new QuickBuyCardPage(getSiteLocale());

    	return (QuickBuyCardPage) getBuyNowButton().clickAndExpectOneOf(quickBuyCardPage);
    }
    

}
