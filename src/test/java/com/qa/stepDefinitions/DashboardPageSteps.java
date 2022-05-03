package com.qa.stepDefinitions;

import org.junit.Assert;

import com.qa.pages.DashboardPage;

import io.cucumber.java.en.Then;

public class DashboardPageSteps {
	DashboardPage dashboardPage = new DashboardPage();

	@Then("user is on dashboard page")
	public void user_is_on_dashboard_page() {
		String title = dashboardPage.validatePageTitle();
		Assert.assertEquals("My Account – Automation Practice Site", title);
	}

}
