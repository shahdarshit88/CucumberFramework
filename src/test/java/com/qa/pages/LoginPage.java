package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestUtil;

public class LoginPage extends TestUtil {

	// Page factory
	@FindBy(xpath = "//*[@id=\"site-logo\"]/a/img")
	WebElement siteLogo;

	@FindBy(id = "username")
	WebElement txtEmail;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(name = "login")
	WebElement btnLogin;

	@FindBy(xpath = "//img")
	List<WebElement> allImages;

	@FindBy(xpath = "//a")
	List<WebElement> allHREFLinks;

	@FindBy(xpath = "//div[@id='body']//li[1]")
	WebElement errorMsg;

	// Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validatePageURL() {
		String currentURL = getCurrentUrl();
		String loginURL = currentURL + "my-account/";
		driver.navigate().to(loginURL);
		return loginURL;
	}

	public String validatePageTitle() {
		String loginTitle = driver.getTitle();
		return loginTitle;
	}

	public void enterLoginInfo(String email, String password) {
		sendKeys(txtEmail, email);
		sendKeys(txtPassword, password);
	}

	public void clickLogin() {
		click(btnLogin);
	}

	public String validateErrorMsg() {
		String errorMessage = getText(errorMsg);
		return errorMessage;
	}

//		public void validateLoginPageLogo() {
//			validateImage(siteLogo);
//		}
	//
//		public void validateAllImages() {
//			ValidateAllImages(allImages);
//		}
	//
//		public void validateAllLinks() {
//			ValidateAllLinks(allHREFLinks);
//		}

}
