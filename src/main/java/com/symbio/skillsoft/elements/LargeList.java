package com.symbio.skillsoft.elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.html.ParentTraits;
import com.paypal.selion.platform.html.SelectList;

public class LargeList extends SelectList {

	public LargeList(ParentTraits parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}

	public LargeList(String locator, String controlName,
			ParentTraits parent) {
		super(locator, controlName, parent);
		// TODO Auto-generated constructor stub
	}

	public LargeList(String locator, String controlName) {
		super(locator, controlName);
		// TODO Auto-generated constructor stub
	}

	public LargeList(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Select a range of values
	 * 
	 * @param offset
	 * @param limit
	 */
	public void selectByRange(int limit){
		this.selectByRange(0, limit);
	}
	
	/**
	 * Select a range of values
	 * 
	 * @param offset
	 * @param limit
	 */
	public void selectByRange(int offset, int limit){
		
		CharSequence cs;
		StringBuilder sb = new StringBuilder();
		Actions actions = new Actions(Grid.driver());
		
		// Get the first element
		getElement().findElementByCssSelector("option:nth-child(" + (offset + 1) + ")").click();
		
		// Press the Key Down button many times
		for (int i=1; i<(limit); i++){
			sb.append(Keys.ARROW_DOWN);
		}
		cs = sb;
		
		// OK Rene
		actions.keyDown(Keys.SHIFT).sendKeys(cs).keyUp(Keys.SHIFT).perform();
	}

}
