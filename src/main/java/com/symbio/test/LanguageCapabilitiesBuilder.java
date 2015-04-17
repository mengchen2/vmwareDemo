package com.symbio.test;
import java.io.IOException;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.paypal.selion.platform.grid.browsercapabilities.DefaultCapabilitiesBuilder;


public class LanguageCapabilitiesBuilder extends DefaultCapabilitiesBuilder {

	@Override
	public DesiredCapabilities getCapabilities(DesiredCapabilities capabilities) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "it");
		
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		
		return capabilities;
	}

}
