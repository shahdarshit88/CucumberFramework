package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	// Create a constructor and initialize the variables
//	public TestBase() {
//		try {
//			prop = new Properties();
//			FileInputStream configFile = new FileInputStream(
//					System.getProperty("user.dir") + "/src/main/java/com/qa/config/config.properties");
//			prop.load(configFile);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

//	public static void initialization() {
//		String browserName = prop.getProperty("browser");
//		if (browserName.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		} else if (browserName.equals("FF")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.pageLoadTimeout));
//		driver.get(prop.getProperty("url"));
//	}

	public static Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream configFile = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
			prop.load(configFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static WebDriver init_driver() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.pageLoadTimeout));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
