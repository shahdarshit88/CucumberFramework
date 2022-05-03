package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestUtil;

public class HomePage extends TestUtil {

	// Page factory
	@FindBy(id = "menu-item-50")
	WebElement lnkMyAccount;

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

	public void clickMyAccount() {
		click(lnkMyAccount);
	}

}
