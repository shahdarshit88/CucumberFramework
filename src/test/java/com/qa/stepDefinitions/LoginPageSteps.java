package com.qa.stepDefinitions;

import org.junit.Assert;

import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	LoginPage loginPage = new LoginPage();
	DashboardPage dashboardPage = new DashboardPage();

	@Given("user is on login page")
	public void user_is_on_login_page() {
		String actualPageURL = loginPage.validatePageURL();
		String expectedPageURL = "http://practice.automationtesting.in/my-account/";
		Assert.assertEquals(expectedPageURL, actualPageURL);
	}

	@Then("login page title should be valid")
	public void login_page_title_should_be_valid() {
		String actualPageTitle = loginPage.validatePageTitle();
		String expectedPageTitle = "My Account – Automation Practice Site";
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
	}

	@When("user has provided valid {string} with {string}")
	public void user_has_provided_valid_email_with_password(String email, String password) {
		loginPage.enterLoginInfo(email, password);
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickLogin();
	}

	@Then("user should be able to login")
	public void user_should_be_able_to_login() {
		String actualEmail = dashboardPage.validateLoginEmail();
		String expectedEmail = "GTERZTBZJP";
		Assert.assertEquals(expectedEmail, actualEmail);
	}

	@When("user has provided invalid {string} with valid {string}")
	public void user_has_provided_invalid_email_with_valid_password(String email, String password) {
		loginPage.enterLoginInfo(email, password);
	}

	@Then("It should show the validation message for valid email")
	public void it_should_show_the_validation_message_for_valid_email() {
		String actualErrorMsg = loginPage.validateErrorMsg();
		String expectedErrorMsg = "Error: A user could not be found with this email address.";
		Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}

	@When("user has provided valid {string} with invalid {string}")
	public void user_has_provided_valid_email_with_invalid_password(String email, String password) {
		loginPage.enterLoginInfo(email, password);
	}

	@Then("It should show the validation message for valid password")
	public void it_should_show_the_validation_message_for_valid_password() {
		String actualErrorMsg = loginPage.validateErrorMsg();
		String expectedErrorMsg = "ERROR: The password you entered for the username GTERZTBZJP@gmail.com is incorrect. Lost your password?";
		Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}

	@When("user has provided invalid {string} with invalid {string}")
	public void user_has_provided_invalid_email_with_invalid_password(String email, String password) {
		loginPage.enterLoginInfo(email, password);
	}

	@Then("It should show the validation message for valid email with valid password")
	public void it_should_show_the_validation_message_for_valid_email_with_valid_password() {
		String actualErrorMsg = loginPage.validateErrorMsg();
		String expectedErrorMsg = "Error: A user could not be found with this email address.";
		Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}

	@Then("It should show the validation message for email is required")
	public void it_should_show_the_validation_message_for_email_is_required() {
		String actualErrorMsg = loginPage.validateErrorMsg();
		String expectedErrorMsg = "Error: Username is required.";
		Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}

//	@And("login page logo is displayed")
//	public void login_page_logo_is_displayed() {
//		loginPage.validateLoginPageLogo();
//	}
//
//	@And("check all the links are working")
//	public void check_all_the_links_are_working() {
//		loginPage.validateAllLinks();
//	}
//
//	@And("check all the images are present")
//	public void check_all_the_images_are_present() {
//		loginPage.validateAllImages();
//	}

//	@Then("dashboard page is displayed")
//	public void dashboard_page_is_displayed() {
//		String title = dashboardPage.validatePageTitle();
//		Assert.assertEquals("My Account - Automation Practice Site", title);
//	}

}
