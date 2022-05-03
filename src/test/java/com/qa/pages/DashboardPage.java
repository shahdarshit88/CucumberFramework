package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestUtil;

public class DashboardPage extends TestUtil {

	// Page factory
	@FindBy(xpath = "//strong[normalize-space()='GTERZTBZJP']")
	WebElement loginEmail;

	// Initializing the page objects
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginEmail() {
		String email = getText(loginEmail);
		return email;
	}

	public String validatePageTitle() {
		String dashboardTitle = driver.getTitle();
		return dashboardTitle;
	}

}
