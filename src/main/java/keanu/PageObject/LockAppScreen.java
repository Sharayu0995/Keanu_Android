package keanu.PageObject;

import io.appium.java_client.MobileElement;
import keanu.Library.AppLibrary;

public class LockAppScreen {

	private AppLibrary appLibrary;

	public static String moreOptions = "xpath://android.widget.ImageView[@content-desc='More options']";
	public static String appLockOption = "xpath://android.widget.TextView[contains(@text,'Lock the app')]";
	public static String resetLockOption = "xpath://android.widget.TextView[@text='Reset Lock']";

	public static String logoSticker = "xpath://android.widget.TextView[@text='Please set a passphrase to lock the app']";
	public static String setPhraseText = "xpath://android.widget.TextView[contains(@text,'Please set a passphrase to lock the app')]";
	public static String skipButton = "id:info.guardianproject.keanuapp:id/btnSkip";

	public static String pwdButton ="xpath://android.widget.TextView[@text='Set Password']";
	public static String pwdPlaceHolder ="xpath://android.widget.EditText[@text='Password']";
	public static String confirmPwdPlaceHolder ="xpath://android.widget.EditText[@text='Confirm New Password']";
	public static String pwdNotMatchMsg = "xpath://android.widget.TextView[contains(@text,'Password did not match, please try again')]";
	public static String confirmPasswordBtn="xpath://android.widget.TextView[@text='Confirm Password']";

	public static String enterPwd = "xpath://android.widget.EditText[contains(@text,'Password')]";

	public LockAppScreen(AppLibrary appLibrary) {
		this.appLibrary = appLibrary;
	}

	public void clickOnMoreOption() throws Exception {
		appLibrary.sleep(1500);
		appLibrary.findElementForMobile(moreOptions).click();
	}

	public void appLockOption() throws Exception {
		appLibrary.sleep(1500);
		appLibrary.findElementForMobile(appLockOption).click();
	}

	public void resetLockOption() throws Exception {
		appLibrary.sleep(1500);
		appLibrary.findElementForMobile(resetLockOption).click();
	}

	public void lockAppUI() throws Exception {
		//appLibrary.findElementForMobile(logoSticker);
		appLibrary.verifyText(setPhraseText, "Please set a passphrase to lock the app");
	}

	public void lockAppSkip() throws Exception {
		appLibrary.findElementForMobile(skipButton).click();
	}

	public void lockAppIncorrectConfirmPwd(String pwd, String confirmPwd) throws Exception {
		appLibrary.verifyMobileElement(pwdPlaceHolder);
		appLibrary.enterMobileText(pwd, pwdPlaceHolder);
		appLibrary.findElementForMobile(pwdButton).click();
		appLibrary.enterMobileText(confirmPwd,confirmPwdPlaceHolder);
		appLibrary.findElementForMobile(confirmPasswordBtn).click();
		//appLibrary.sleep(3000);
		//appLibrary.verifyMobileElement(pwdNotMatchMsg);
		appLibrary.findElementForMobile(confirmPasswordBtn).click();
		appLibrary.sleep(3000);
	}

	public void setLockApp(String pwd) throws Exception 
	{   
		appLibrary.verifyMobileElement(pwdPlaceHolder);
		appLibrary.enterMobileText(pwd,pwdPlaceHolder);
		appLibrary.findElementForMobile(pwdButton).click();
		appLibrary.enterMobileText(pwd,confirmPwdPlaceHolder);
		appLibrary.findElementForMobile(confirmPasswordBtn).click();
	}

	public void lockAndUnlockApp(String pwd) throws Exception {
		appLibrary.openApp();
		appLibrary.sleep(1000);
		appLibrary.openApp();
		MobileElement enter = appLibrary.findElementForMobile(enterPwd);
		appLibrary.enterMobileText(pwd, enterPwd);
		enter.submit();
	}

	public void resetLock() throws Exception {
		appLibrary.openApp();
		appLibrary.sleep(1000);
		appLibrary.openApp();
		appLibrary.verifyMobileElement(resetLockOption);
		appLibrary.findElementForMobile(resetLockOption).click();
		appLibrary.sleep(2000);
	}
}
