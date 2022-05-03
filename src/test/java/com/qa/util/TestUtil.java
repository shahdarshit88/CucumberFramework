package com.qa.util;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil extends TestBase {

	static int pageLoadTimeout = 40;
	static int implicitWait = 40;
	static int waitTime = 40;

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void refreshPage() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendKeys(WebElement locator, String value) {
		try {
			waitForVisibilityOfElement(locator);
			scrollToElement(locator);
			WebElement webelement = locator;
			clearValue(webelement);
			locator.sendKeys(Keys.chord(Keys.CONTROL, "a"), value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clearValue(WebElement locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value = '';", locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click(WebElement locator) {
		try {
			waitForVisibilityOfElement(locator);
			// scrollToElement(locator);
			locator.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForVisibilityOfElement(WebElement locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.visibilityOf(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollToElement(WebElement locator) {
		try {
			WebElement webElement = locator;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", webElement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getText(WebElement locator) {
		String value = null;
		try {
			waitForVisibilityOfElement(locator);
			scrollToElement(locator);
			value = locator.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public boolean isElementPresent(WebElement locator) {
		try {
			if (locator.isDisplayed())
				System.out.println("Element presend on screen ***********" + locator);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Element not present on screen **************" + locator);
			return false;
		}
	}

	public String getAttributeValue(WebElement locator, String attributeName) {
		String value = null;
		try {
			waitForVisibilityOfElement(locator);
			scrollToElement(locator);
			value = locator.getAttribute(attributeName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public void scrollIntoView(WebElement locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locator);
	}

	public void moveToElement(WebElement locator) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(locator).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String switchToLatestWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
			}
		}
		return parentWindow;
	}

	public String getCSSColor(WebElement locator, String cssValue) {
		String hexColorValue = null;
		try {
			String colorValue = locator.getCssValue(cssValue);
			hexColorValue = Color.fromString(colorValue).asHex();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hexColorValue;
	}

	public boolean validateImage(WebElement locator) {
		WebElement imageElement = locator;
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imageElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != 200) {
				System.out.println("Image is invalid " + response.getStatusLine().getStatusCode());
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
	}

	public void fixWait(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (Exception e) {
		}
	}

	public void waitUntilElementToDisappear(WebElement locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.invisibilityOf(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<WebElement> ValidateAllImages(List<WebElement> locator) {
		try {
			for (WebElement img : locator) {
				HttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(img.getAttribute("src"));
				HttpResponse response = client.execute(request);
				int statusCode = response.getStatusLine().getStatusCode();
				if (response.getStatusLine().getStatusCode() != 200) {
					System.out.println("Image is invalid: " + statusCode + " " + img.getAttribute("src"));
				} else {
					System.out.println("Image is Valid: " + statusCode + " " + img.getAttribute("src"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locator;
	}

	public List<WebElement> ValidateAllLinks(List<WebElement> locator) {
		try {
			for (WebElement url : locator) {
				HttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(url.getAttribute("href"));
				HttpResponse response = client.execute(request);
				int statusCode = response.getStatusLine().getStatusCode();
				if (response.getStatusLine().getStatusCode() >= 400) {
					System.out.println("URL is invalid: " + statusCode + " " + url.getAttribute("href"));
				} else {
					System.out.println("URL is Valid: " + statusCode + " " + url.getAttribute("href"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locator;
	}

//    public void selectCheckbox(By element) {
//        try {
//            List<WebElement> elementsList = driver.findElements(element);
//            for (WebElement webElement : elementsList) {
//                scrollToElement(element);
//                webElement.click();
//            }
//        } catch (Exception e) {
//            Logger.log(e.getStackTrace().toString());
//        }
//    }

//    public boolean isSelected(By element) {
//        try {
//            waitForVisibilityOfElement(element);
//            List<WebElement> elementsList = driver.findElements(element);
//            for (WebElement webElement : elementsList) {
//                return webElement.isSelected();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

//    public void deselectCheckbox(By element) {
//        try {
//            waitForVisibilityOfElement(element);
//            List<WebElement> elementsList = driver.findElements(element);
//            for (WebElement webElement : elementsList) {
//                scrollToElement(element);
//                webElement.click();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public List<String> getMultipleText(By element) {
//        List<String> values = new ArrayList<>();
//        try {
//            List<WebElement> webElements = driver.findElements(element);
//            for (WebElement webElement : webElements) {
//                values.add(webElement.getText());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return values;
//    }

//    public int getElementSize(By element) {
//        int size = 0;
//        try {
//            size = driver.findElements(element).size();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return size;
//    }

//    public WebElement getElement(By by) {
//        WebElement element = null;
//        try {
//            element = driver.findElement(by);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return element;
//    }

//    public List<WebElement> getElements(By by) {
//        List<WebElement> elements = null;
//        try {
//            elements = driver.findElements(by);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return elements;
//    }

}
