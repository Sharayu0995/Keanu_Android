package keanu.PageObject;

import keanu.Library.AppLibrary;

public class WelcomeScreen {

	private AppLibrary appLibrary;

	public static String selectLanguageButton = "id:info.guardianproject.keanuapp:id/languageButton";
//	public static String skipButton = "id:info.guardianproject.keanuapp:id/nextButton";
	public static String skipButton = "xpath://android.widget.TextView[contains(@text,'Skip')]";
	public static String languageTitle = "id:android:id/alertTitle";
	public static String selectLang = "xpath://android.widget.CheckedTextView[@text='replace']";

	public WelcomeScreen(AppLibrary appLibrary) {
		this.appLibrary = appLibrary;
	}

	public WelcomeScreen skipToSignIn() throws Exception {
		appLibrary.findElementForMobile(skipButton).click();
		return new WelcomeScreen(appLibrary);
	}

	public WelcomeScreen selectLang(String lang) throws Exception {
		appLibrary.findElementForMobile(selectLanguageButton).click();
		appLibrary.verifyText(languageTitle, "Languages");
		appLibrary.swipeDownByText(lang);
		return new WelcomeScreen(appLibrary);
	}
}
