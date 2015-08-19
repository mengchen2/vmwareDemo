package extension;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.html.WebPage;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.symbio.skillsoft.VMware.ConfirmPage;
import com.symbio.skillsoft.VMware.ProductDetailsPage;
import com.symbio.skillsoft.VMware.QuickBuyCardPage;

public class QuickBuyCardPageExt extends QuickBuyCardPage {

    public QuickBuyCardPageExt(){
        this("english");
    }
    
    public QuickBuyCardPageExt(String siteLocale){
        super("siteLocale");
    }
    
    public QuickBuyCardPageExt fill(String state){
    	getStateLargeList().selectByLabel(state);
    	SeLionReporter.log("state selecte", true, true);
        return this;
    }
    
    public WebPage submit(){
    	ConfirmPage confirmPage = new ConfirmPage(getSiteLocale());

    	WebPage page = (WebPage) getCheckoutButton().clickAndExpectOneOf(confirmPage);
        return page;
    }
    

}
