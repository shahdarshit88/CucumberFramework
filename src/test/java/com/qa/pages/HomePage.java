package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestUtil;

public class HomePage extends TestUtil {

	// Page factory
	@FindBy(id = "menu-item-50")
	WebElement lnkMyAccount;

	@FindBy(id = "aswift_7")
	List<WebElement> iframeAD;

	@FindBy(tagName = "aswift_8")
	WebElement ifrm8;

	@FindBy(id = "dismiss-button")
	WebElement btnClose;

	// Initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validatePageURL() {
		String currentURL = getCurrentUrl();
		return currentURL;
	}

	public String validatePageTitle() {
		String homeTitle = driver.getTitle();
		return homeTitle;
	}

	public void clickMyAccount() throws InterruptedException {
		click(lnkMyAccount);
		int size = iframeAD.size();
		if (size > 0) {
			driver.switchTo().frame("aswift_7");
			driver.switchTo().frame("ad_iframe");
			Thread.sleep(2000);
			click(btnClose);
		}
	}

}