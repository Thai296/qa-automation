package com.bankguru.qaautomation.pageobject;

import org.openqa.selenium.WebDriver;

import com.bankguru.qaautomation.commons.AbstractPage;
import com.bankguru.qaautomation.pageui.HomePageUI;

public class HomePageObject extends AbstractPage{

	public HomePageObject(WebDriver driver) {
		super(driver);
	}
	
	public void switchToImageIframe() {
		waitForElementVisible(HomePageUI.IMAGE_IFRAME);
		switchToFrame(findElementByXpath(HomePageUI.IMAGE_IFRAME));
	}
	
	public void switchToAdverIframe() {
		waitForElementVisible(HomePageUI.CONTENT_IFRAME);
		switchToFrame(findElementByXpath(HomePageUI.CONTENT_IFRAME));
	}
	
	public void clickCloseButtonToHideAdver() {
		waitForElemenClickable(HomePageUI.DISMISS_BUTTON);
		clickToElement(HomePageUI.DISMISS_BUTTON);
	}
}
