package com.qa.stepDefinitions;

import org.junit.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();

	@Given("user is on home page")
	public void user_is_on_home_page() {
		String actualPageURL = homePage.validatePageURL();
		String expectedPageURL = "https://practice.automationtesting.in/";
		Assert.assertEquals(expectedPageURL, actualPageURL);
	}

	@Then("home page title should be valid")
	public void home_page_title_should_be_valid() {
		String actualPageTitle = homePage.validatePageTitle();
		String expectedPageTitle = "Automation Practice Site";
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
	}

	@When("user clicks on my account link")
	public void user_clicks_on_my_account_link() {
		homePage.clickMyAccount();
	}

	@Then("login page should be displayed")
	public void login_page_should_be_displayed() {
		String title = loginPage.validatePageTitle();
		String actual = "My Account – Automation Practice Site";
		Assert.assertEquals(actual, title);
	}

}
