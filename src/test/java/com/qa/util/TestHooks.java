package com.qa.util;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestHooks {

	WebDriver driver;
	Properties prop;

	@Before()
	public void launchBrowser() {
		prop = TestBase.init_prop();
		driver = TestBase.init_driver();
	}

	@After()
	public void quitBrowser() {
		driver.quit();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		// validate if scenario has failed
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}
	}

}
