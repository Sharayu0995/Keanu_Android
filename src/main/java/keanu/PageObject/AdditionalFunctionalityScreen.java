package keanu.PageObject;

import keanu.Library.AppLibrary;

public class AdditionalFunctionalityScreen {
	private AppLibrary appLibrary;

	public static String moreOptions = "xpath://android.widget.ImageView[@content-desc='More options']";
	public static String myAccountOption = "xpath://android.widget.TextView[@text='My Accounts']";
	public static String settingsOption = "xpath://android.widget.TextView[contains(@text,'Settings')]";
	public static String lockAppOption = "xpath://android.widget.TextView[contains(@text,'Lock the app')]";
	public static String signOutOption = "xpath://android.widget.TextView[contains(@text,'Sign out')]";

	// My Accoutns
	public static String addAccount = "id:menu_add_account";
	public static String serverVerify = "xpath:(//android.widget.TextView[contains(@text,'neo.keanu.im')])[1]";
	public static String acconutOnOffSwitch = "xpath:(//android.widget.Switch[@index='1'])[1]";
	public static String availableUser = "xpath://android.widget.TextView[contains(@text,'replace')]";

	// Settings
	public static String language = "xpath://android.widget.TextView[contains(@text,'Languages')]";
	public static String myData = "xpath://android.widget.TextView[contains(@text,'Protect My Data')]";
	public static String panicTrigger = "xpath://android.widget.TextView[contains(@text,'Panic Trigger App')]";
	public static String panicMessage = "xpath://android.widget.TextView[contains(@text,'A panic app can trigger the app to')]";
	public static String panicSetup = "xpath://android.widget.TextView[contains(@text,'Panic Setup')]";
	public static String panicNotification = "xpath://android.widget.TextView[contains(@text,'Set up how the app reacts to a panic notification.')]";
	public static String customColour = "xpath://android.widget.TextView[contains(@text,'Custom Colors')]";
	public static String headerColours = "xpath://android.widget.TextView[contains(@text,'Header Colors')]";
	public static String headerColourMessage = "xpath://android.widget.TextView[contains(@text,'Color of headers, actionbars and toolbars')]";
	public static String textColour = "xpath://android.widget.TextView[contains(@text,'Text Color')]";
	public static String textColourMessage = "xpath://android.widget.TextView[contains(@text,'Color of text in messages and lists')]";
	public static String backgroundColour = "xpath://android.widget.TextView[contains(@text,'Background Color')]";
	public static String backgroundColourMessage = "xpath://android.widget.TextView[contains(@text,'Color of chat backgrounds and lists')]";
	public static String resetColour = "xpath://android.widget.TextView[contains(@text,'Reset Colors')]";
	public static String resetColourMessage = "xpath://android.widget.TextView[contains(@text,'Reset colors to default values')]";
	public static String autoStart = "xpath://android.widget.TextView[contains(@text,'Start Automatically')]";
	public static String autoStartMessage = "xpath://android.widget.TextView[contains(@text,'Always start and automatically')]";

	public static String NotificationSetting = "xpath://android.widget.TextView[contains(@text,'Notification settings')]";
	public static String imNotification = "xpath://android.widget.TextView[contains(@text,'IM notifications')]";
	public static String notificationMsg = "xpath://android.widget.TextView[contains(@text,'Notify in status bar when IM arrives')]";
	public static String viberateOption = "xpath://android.widget.TextView[contains(@text,'Vibrate')]";
	public static String viberateMsg = "xpath://android.widget.TextView[contains(@text,'Also vibrate when IM arrives')]";
	public static String soundOption = "xpath://android.widget.TextView[contains(@text,'Sound')]";
	public static String soundMessage = "xpath://android.widget.TextView[contains(@text,'Also play ringtone when IM arrives')]";
	public static String selectRingtone = "xpath://android.widget.TextView[contains(@text,'Select Custom Ringtone')]";
	public static String enableDebugLog = "xpath://android.widget.TextView[contains(@text,'Enable Debug Logs')]";
	public static String enableDebugLogMsg = "xpath://android.widget.TextView[contains(@text,'Output app log data to standard out / logcat for debugging')]";
	public static String blockScreenshot = "xpath://android.widget.TextView[contains(@text,'Block Screenshots')]";
	public static String blockScreenshotMessage = "xpath://android.widget.TextView[contains(@text,'Block attempts for other apps to take')]";
	public static String photoVerification = "xpath://android.widget.TextView[contains(@text,'Photo Verification')]";
	public static String photoVerificationMsg = "xpath://android.widget.TextView[contains(@text,'Add extra proof data to your photos to make')]";
	public static String snackbarMsg = "id:snackbar_text";

	public AdditionalFunctionalityScreen(AppLibrary appLibrary) {
		this.appLibrary = appLibrary;
	}

	public void settingUI() throws Exception {
		appLibrary.verifyText(language, "Languages");
		appLibrary.verifyText(myData, "Protect My Data");
		appLibrary.verifyText(panicTrigger, "Panic Trigger App");
		appLibrary.verifyText(panicMessage,
				"A panic app can trigger the app to lock, send a message, delete data, etc.");
		appLibrary.verifyText(panicSetup, "Panic Setup");
		appLibrary.verifyText(panicNotification, "Set up how the app reacts to a panic notification.");
		appLibrary.verifyText(customColour, "Custom Colors");
		appLibrary.verifyText(headerColours, "Header Colors");
		appLibrary.verifyText(headerColourMessage, "Color of headers, actionbars and toolbars");
		appLibrary.verifyText(textColour, "Text Color");
		appLibrary.verifyText(textColourMessage, "Color of text in messages and lists");
		appLibrary.verifyText(backgroundColour, "Background Color");
		appLibrary.verifyText(backgroundColourMessage, "Color of chat backgrounds and lists");
		appLibrary.verifyText(resetColour, "Reset Colors");
		appLibrary.verifyText(resetColourMessage, "Reset colors to default values");
		appLibrary.verifyText(autoStart, "Start Automatically");
		appLibrary.verifyText(autoStartMessage,
				"Always start and automatically sign into previously logged in accounts");

		appLibrary.swipeDownByText("Add extra proof data to your photos to make it easier");
		appLibrary.verifyText(NotificationSetting, "Notification settings");
		appLibrary.verifyText(imNotification, "IM notifications");
		appLibrary.verifyText(notificationMsg, "Notify in status bar when IM arrives");
		appLibrary.verifyText(viberateOption, "Vibrate");
		appLibrary.verifyText(viberateMsg, "Also vibrate when IM arrives");
		appLibrary.verifyText(soundOption, "Sound");
		appLibrary.verifyText(soundMessage, "Also play ringtone when IM arrives");
		appLibrary.verifyText(selectRingtone, "Select Custom Ringtone");
		appLibrary.verifyText(enableDebugLog, "Enable Debug Logs");
		appLibrary.verifyText(enableDebugLogMsg, "Output app log data to standard out / logcat for debugging");
		appLibrary.verifyText(blockScreenshot, "Block Screenshots");
		appLibrary.verifyText(blockScreenshotMessage, "Block attempts for other apps to take screenshots of this app");
		appLibrary.verifyText(photoVerification, "Photo Verification");
		appLibrary.verifyText(photoVerificationMsg,
				"Add extra proof data to your photos to make it easier for people to verify the authenticity");
		appLibrary.navigateBack();
	}

	public void clickOnMoreOption() throws Exception {
		appLibrary.sleep(4000);
		appLibrary.findElementForMobile(moreOptions).click();
	}

	public void myAccountNavigation() throws Exception {
		appLibrary.sleep(5000);
		appLibrary.findElementForMobile(myAccountOption).click();
		appLibrary.sleep(2000);
	}
	

	public void settingsNavigation() throws Exception {
		clickOnMoreOption();
		appLibrary.findElementForMobile(settingsOption).click();
	}

	public void lockAppNavigation() throws Exception {
		clickOnMoreOption();
		appLibrary.findElementForMobile(lockAppOption).click();
		appLibrary.sleep(2000);
	}

	public void signOut() throws Exception {
		clickOnMoreOption();
		appLibrary.findElementForMobile(signOutOption).click();
	}

	public void menuOptions() throws Exception {
		appLibrary.findElementForMobile(moreOptions).click();
		appLibrary.verifyText(myAccountOption, "My Accounts");
		appLibrary.verifyText(settingsOption, "Settings");
		appLibrary.verifyText(lockAppOption, "Lock the app");
		appLibrary.verifyText(signOutOption, "Sign out");

	}

	public void myAccountVerification(String un, String serverUsed) throws Exception {
		String uName = appLibrary.findElementForMobile(availableUser.replace("replace", un)).getText();
		uName.contains(un);
		appLibrary.verifyText(serverVerify, "Online - " + serverUsed);
	}

	public void deactivateAccount(String serverUsed) throws Exception {
		appLibrary.verifyText(serverVerify, "Online - " + serverUsed);
		appLibrary.findElementForMobile(acconutOnOffSwitch).click();
		appLibrary.sleep(3000);
		appLibrary.verifyText(serverVerify, serverUsed);
	}

	public void activateAccount(String serverUsed) throws Exception {
		appLibrary.verifyText(serverVerify, serverUsed);
		appLibrary.findElementForMobile(acconutOnOffSwitch).click();
		appLibrary.sleep(5000);
		appLibrary.verifyText(serverVerify, "Online - " + serverUsed);
	}

	public void accountChange(String un) throws Exception {
		appLibrary.longPressElement(availableUser.replace("replace", un));
		//appLibrary.verifyText(snackbarMsg, "Default account changed");
	}

	public void addAccount() throws Exception {
		appLibrary.findElementForMobile(addAccount).click();
		appLibrary.sleep(2000);
	}
}
