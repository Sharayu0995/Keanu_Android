package keanu.Library;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import keanu.PageObject.AppHeaders;

public class AppLibrary {

	public static final long GLOBALTIMEOUT = 10;
	private AppiumDriver<MobileElement> driver;

	public Configuration config;
	public String currentTestName;

	public String getCurrentTestName() {
		return currentTestName;
	}

	public void setCurrentTestName(String currentTestName) {
		this.currentTestName = currentTestName;
	}

	private String currentSessionID;

	// This is used for parameterized tests
	public AppLibrary(String testName) {
		this.currentTestName = testName;
		this.config = new Configuration();
	}

	/**
	 * Creates an Appium Driver Instance @throws Exception
	 */
	public AppiumDriver<MobileElement> getDriverInstance(String mobiledevice, String port) throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		if (config.isBrowserStackExecution()) {

			try {
				if (config.getOsName().equalsIgnoreCase("android")) {

					if (mobiledevice.equals("device1")) {
						caps.setCapability("device", config.getDeviceName1());
						caps.setCapability("os_version", config.getOSVersion1());
					
					} else {
						caps.setCapability("device", config.getDeviceName2());
						caps.setCapability("os_version", config.getOSVersion2());
					}

					caps.setCapability("browserstack.idleTimeout", "180");
					caps.setCapability("browserstack.debug", true);
					caps.setCapability("browserstack.networkLogs", true);
				
					caps.setCapability("app", config.getBrowserStackAppURL());
					caps.setCapability("newCommandTimeout", 900000);
					caps.setCapability("automationName","UiAutomator2");
					caps.setCapability("deviceOrientation","portrait");
					caps.setCapability("real_mobile", "true");
					caps.setCapability("browserstack.local", "false");
					driver = new AppiumDriver<MobileElement>(new URL("http://" + config.getBrowserStackUserName() + ":"
							+ config.getBrowserStackAuthKey() + "@hub.browserstack.com/wd/hub"), caps);
				}

			} catch (Exception e) {
				Reporter.log("Issue creating new driver instance due to following error: " + e.getMessage() + "\n"
						+ e.getStackTrace(), true);
				throw e;
			}
			currentSessionID = (driver).getSessionId().toString();
		}

		else if (config.getOsName().equalsIgnoreCase("android")) {
			File appDir = new File(config.getappDir());
			File app = new File(appDir, config.getappName());
			caps.setCapability("device", config.getOsName());

			if (mobiledevice.equals("device1")) {
				caps.setCapability("deviceName", config.getDeviceName1());
				caps.setCapability("udid", config.getDeviceId1());
			} else {
				caps.setCapability("deviceName", config.getDeviceName2());
				caps.setCapability("udid", config.getDeviceId2());
			}
			caps.setCapability("appPackage", config.getAppPackage());
			caps.setCapability("appActivity", config.getAppActivity());
			caps.setCapability("unicodeKeyboard", true);
			caps.setCapability("resetKeyboard", true);
			caps.setCapability("noResetValue", false);
			caps.setCapability("browserstack.appium_version", "1.14.0");
			caps.setCapability("app", app.getAbsolutePath());
			caps.setCapability("autoGrantPermissions", true);
			caps.setCapability("deviceOrientation","portrait");
			caps.setCapability("automationName","UiAutomator2");
			caps.setCapability("deviceOrientation","portrait");
			caps.setCapability("newCommandTimeout", 900000);
			
			
			String url = "http://0.0.0.0:" + port + "/wd/hub";
			driver = new AppiumDriver<MobileElement>(new URL(url), caps);
		}
		driver.manage().timeouts().implicitlyWait(GLOBALTIMEOUT, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * Creates an Appium Driver Instance @throws Exception
	 */
	public AppiumDriver<MobileElement> getDriverInstance() throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		String os = config.getOsName();

		if (config.isBrowserStackExecution()) {

			try {
				if (os.equalsIgnoreCase("android")) {
					caps.setCapability("browserstack.idleTimeout", "180");
					caps.setCapability("device", config.getDeviceName1());
					caps.setCapability("os_version", config.getOSVersion1());
					caps.setCapability("browserstack.debug", true);
					caps.setCapability("browserstack.networkLogs", true);
					caps.setCapability("browserstack.appium_version", "1.14.0");
					caps.setCapability("app", config.getBrowserStackAppURL());
					caps.setCapability("newCommandTimeout", 900000);
					caps.setCapability("build", System.getProperty("Build"));
					caps.setCapability("project", System.getProperty("Suite"));
					caps.setCapability("name", currentTestName);
					caps.setCapability("automationName","UiAutomator2");
					
					caps.setCapability("real_mobile", "true");
					caps.setCapability("browserstack.local", "false");
					driver = new AppiumDriver<MobileElement>(new URL("http://" + config.getBrowserStackUserName() + ":"
							+ config.getBrowserStackAuthKey() + "@hub.browserstack.com/wd/hub"), caps);
				}
			} catch (Exception e) {
				Reporter.log("Issue creating new driver instance due to following error: " + e.getMessage() + "\n"
						+ e.getStackTrace(), true);
				throw e;
			}
			currentSessionID = (driver).getSessionId().toString();
		}

		else if (os.equalsIgnoreCase("android")) {
			File appDir = new File(config.getappDir());
			File app = new File(appDir, config.getappName());
			caps.setCapability("platformName", config.getOsName());
			caps.setCapability("device", config.getDeviceName1());
			caps.setCapability("udid", config.getDeviceId1());
			caps.setCapability("appPackage", config.getAppPackage());
			caps.setCapability("appActivity", config.getAppActivity());
			caps.setCapability("unicodeKeyboard", true);
			caps.setCapability("resetKeyboard", true);
			caps.setCapability("noResetValue", false);
			caps.setCapability("app", app.getAbsolutePath());
			caps.setCapability("autoGrantPermissions", true);
			caps.setCapability("automationName","UiAutomator2");
			
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 90000);
			String url = "http://0.0.0.0:4723/wd/hub";
			driver = new AppiumDriver<MobileElement>(new URL(url), caps);

		}
		driver.manage().timeouts().implicitlyWait(GLOBALTIMEOUT, TimeUnit.SECONDS);
		return driver;
	}

	public void reopenApp() throws Exception {
		try {
			try {
				sleep(10000);
				findElementForMobile("id:android:id/aerr_close").click();
				sleep(3000);
				if (config.isBrowserStackExecution())
					driver.launchApp();
				else
					driver.activateApp(config.getAppPackage());
			} catch (Exception e) {
				findElementForMobile(AppHeaders.myProfileScreen).click();
				sleep(10000);
				findElementForMobile("id:android:id/aerr_close").click();
				sleep(3000);
				if (config.isBrowserStackExecution())
					driver.launchApp();
				else
					driver.activateApp(config.getAppPackage());
			}
			sleep(3000);
		} catch (Exception e) {
			sleep(3000);
			if (config.isBrowserStackExecution())
				driver.launchApp();
			else
				driver.activateApp(config.getAppPackage());
			sleep(3000);
			try {
				findElementForMobile(AppHeaders.myProfileScreen).click();
				sleep(10000);
				findElementForMobile("id:android:id/aerr_close").click();
				sleep(3000);
				if (config.isBrowserStackExecution())
					driver.launchApp();
				else
					driver.activateApp(config.getAppPackage());
				findElementForMobile(AppHeaders.myProfileScreen);
			} catch (Exception e1) {
				sleep(10000);
				findElementForMobile("id:android:id/aerr_close").click();
				sleep(3000);
				if (config.isBrowserStackExecution())
					driver.launchApp();
				else
					driver.activateApp(config.getAppPackage());

				sleep(3000);
				findElementForMobile(AppHeaders.myProfileScreen);
			}
		}
	}

	public void openApp() throws Exception {
		sleep(3000);
		if (config.isBrowserStackExecution()) {
			driver.activateApp(config.getAppPackage());
			
			driver.rotate(ScreenOrientation.PORTRAIT);
		} else
			driver.activateApp(config.getAppPackage());
		sleep(5000);
	}

	public void terminateApp() throws Exception {
		driver.terminateApp(config.getAppPackage());
		driver.activateApp(config.getAppPackage());
	}

	public static int randIntDigits(int min, int max) {
		Random rand = new Random();
		int randomNum = (rand.nextInt((max - min) + 1) + rand.nextInt((max - min) + 1)) / 2;
		return randomNum;
	}

	/**
	 * Get Driver Instance
	 */
	public AppiumDriver<MobileElement> getCurrentDriverInstance() {
		return driver;
	}

	/**
	 * Closes the Browser
	 */
	public void closeBrowser() {
		if (driver != null)
			driver.quit();
	}

	public MobileElement findElementForMobile(String locator) throws Exception {
		log("Finding element with logic: " + locator, true);
		return driver.findElement(getBy(locator));
	}

	public WebElement findElementForMobile(String locatorString, boolean isOptional) throws Exception {
		try {
			System.out.println(locatorString);
			return findElementForMobile(locatorString);
		} catch (NoSuchElementException nse) {
			if (isOptional) {
				return null;
			} else {
				throw new RuntimeException("Element " + locatorString + " not found");
			}
		}
	}

	public Configuration getConfiguration() {
		if (config == null) {
			config = new Configuration();
		}
		return config;
	}

	public boolean verifyMobileElement(String locatorString) throws Exception {
		return verifyMobileElement(driver, locatorString, false);
	}

	public boolean verifyMobileElement(AppiumDriver<MobileElement> driver, String locatorString,
			boolean checkVisibility) throws Exception {
		boolean isDisplayed = true;
		try {
			if (checkVisibility) {
				isDisplayed = (findElementForMobile(locatorString).isDisplayed());
			} else {
				findElementForMobile(locatorString);
			}
		} catch (NoSuchElementException nsee) {
			Assert.assertTrue(false, "Element not found using locator: " + locatorString);
		}
		return isDisplayed;
	}

	public void sleep(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public List<MobileElement> findElementsForMobile(String locator) throws Exception {

		Reporter.log("Finding element with logic: " + locator, true);
		return driver.findElements(getBy(locator));
	}

	public String getCurrentSessionID() {
		return currentSessionID;
	}

	public void waitForMobileElementClickable(WebElement element) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForMobileElementVisible(WebElement element) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
	}

	public void selectCheckBox(String locator) throws Exception {
		if (!findElementForMobile(locator).isSelected()) {
			clickMobileElement(locator);
		}
	}

	public void deselectCheckBox(String locator) throws Exception {
		if (findElementForMobile(locator).isSelected()) {
			clickMobileElement(locator);
		}
	}

	public void enterMobileText(String text, String locator) throws Exception {
		//findElementForMobile(locator).click();
		findElementForMobile(locator).clear();
		findElementForMobile(locator).sendKeys(text);
	}

	public void clickMobileElement(String locator) throws Exception {
		findElementForMobile(locator).click();
	}

	public void waitUntilMobileElementDisplayed(String locator) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		Reporter.log("Finding element with logic: " + locator, true);
		wait.until(ExpectedConditions.visibilityOfElementLocated(getBy(locator)));
	}

	public void verifyAbsent(String locator) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = null;
		try {
			Reporter.log("Finding element with logic: " + locator, true);
			element = driver.findElement(getBy(locator));
			Assert.assertTrue(false,
					"Expected element to be absent, but it was found on the page. Text = " + element.getText());
		} catch (Exception e) {
			// It's good if not found
		} finally {
			driver.manage().timeouts().implicitlyWait(GLOBALTIMEOUT, TimeUnit.SECONDS);
		}
	}

	public By getBy(String locator) throws Exception {
		String string = locator;
		String[] parts = string.split(":");
		String type = parts[0];
		String object = parts[1];

		if (parts.length > 2) {
			for (int i = 2; i < parts.length; i++) {
				object = object + ":" + parts[i];
			}
		}

		try {
			if (type.equals("id")) {
				return By.id(object);
			} else if (type.equals("name")) {
				return By.name(object);
			} else if (type.equals("class")) {
				return By.className(object);
			} else if (type.equals("link")) {
				return By.linkText(object);
			} else if (type.equals("partiallink")) {
				return By.partialLinkText(object);
			} else if (type.equals("css")) {
				return By.cssSelector(object);
			} else if (type.equals("xpath")) {
				return By.xpath(object);
			} else {
				throw new Exception("Invalid locator finding strategy, " + locator);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void verifyText(String locator, String expectedValue) throws Exception {
		String actualValue = findElementForMobile(locator).getText();
		Assert.assertEquals(actualValue, expectedValue,
				"values didnot match for " + locator + "Expected =" + expectedValue + "  Actual =" + actualValue);
	}

	public void verifiyContains(String locator, String expectedValue) throws Exception {
		String actualValue = findElementForMobile(locator).getText();
		actualValue.contains(expectedValue);
	}

	public void swipeDownByText(String text) {
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ text + "\").instance(0))"))
				.click();
	}

	public void horizontalSwipe(String startLocator, String endLocator) throws Exception {
		MobileElement startElement = findElementForMobile(startLocator);
		MobileElement endElement = findElementForMobile(endLocator);

		int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
		int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

		int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
		int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
		TouchAction touchAction = new TouchAction(driver);

		touchAction.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release()
				.perform();
		sleep(1000);
	}

	public void horizontalRightSwipe(String startLocator) throws Exception {
		WebElement element = findElementForMobile(startLocator);
		Dimension dim = element.getSize();
		int Ancor = element.getSize().getHeight() / 2;

		Double screenWidthStart = dim.getWidth() * 0.8;
		int scrollStart = screenWidthStart.intValue();

		Double screenWidthEnd = dim.getWidth() * 0.2;
		int scrollEnd = screenWidthEnd.intValue();

		AndroidTouchAction touch = new AndroidTouchAction((PerformsTouchActions) driver);
		touch.press(PointOption.point(scrollStart, Ancor)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
				.moveTo(PointOption.point(scrollEnd, Ancor)).release().perform();

		sleep(1000);

	}

	public void horizontalLeftSwipe(String startLocator) throws Exception {
		WebElement element = findElementForMobile(startLocator);
		Dimension dim = element.getSize();
		int Ancor = element.getSize().getHeight() / 2;

		Double screenWidthStart = dim.getWidth() * 0.8;
		int scrollStart = screenWidthStart.intValue();

		Double screenWidthEnd = dim.getWidth() * 0.2;
		int scrollEnd = screenWidthEnd.intValue();

		AndroidTouchAction touch = new AndroidTouchAction((PerformsTouchActions) driver);
		touch.press(PointOption.point(scrollEnd, Ancor)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
				.moveTo(PointOption.point(scrollStart, Ancor)).release().perform();
		sleep(1000);
	}

	public static void log(String message, boolean reporter) {
		System.out.println(message);
		if (reporter) {
			Reporter.log(message);
		}
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void longPressElement(String locator) throws Exception {
		MobileElement element = findElementForMobile(locator);
		AndroidTouchAction touch = new AndroidTouchAction(driver);
		touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element))).release()
				.perform();
	}
	
	public void portraitOriantation()
	{
		driver.rotate(ScreenOrientation.PORTRAIT);
	}

}