package keanu.PageObject;

import keanu.Library.AppLibrary;

public class SignUpSignInScreen {

	private AppLibrary appLibrary;

	// Account Selection Locators (New or existing account)
	public static String createAnAccountButton ="id:btnShowRegister";
	public static String signInToExistingAccButton ="id:btnShowLogin";

	// Sign Up Locators
	public static String createIDTitle = "xpath://android.widget.TextView[@text='Create an ID']";
	public static String userIDTextField = "xpath://android.widget.EditText[@resource-id='info.guardianproject.keanuapp:id/edtNameAdvanced']";
	public static String enterPwdTextField = "xpath://android.widget.EditText[@resource-id='info.guardianproject.keanuapp:id/edtNewPass']";
	public static String confirmPwdTextField = "xpath://android.widget.EditText[@resource-id='info.guardianproject.keanuapp:id/edtNewPassConfirm']";
	public static String registerButton = "xpath://android.widget.Button[@resource-id='info.guardianproject.keanuapp:id/btnNewRegister']";

	// Sign In Locators
	public static String existingAccountMessage = "xpath://android.widget.TextView[@text='You can use an existing account on any server you would like.']";
	public static String usernameTextField = "xpath://android.widget.EditText[contains(@resource-id,'edtName')]";
	public static String pwdTextField = "xpath://android.widget.EditText[contains(@resource-id,'edtPass')]";
	public static String serverTextField = "xpath://android.widget.EditText[contains(@resource-id,'edtServer')]";
	public static String signInButton = "xpath://android.widget.Button[contains(@resource-id,'btnSignIn')]";

	public SignUpSignInScreen(AppLibrary appLibrary) {
		this.appLibrary = appLibrary;
	}

	public SignUpSignInScreen accountSelection(Boolean existingAccount) throws Exception 
	{
		if (existingAccount)
		{
			
			appLibrary.findElementForMobile(signInToExistingAccButton).click();
		}
		else
		{
			appLibrary.findElementForMobile(createAnAccountButton).click();
		}
		return new SignUpSignInScreen(appLibrary);
	}

	public SignUpSignInScreen signIn(String username, String password, String serverName) throws Exception {

			appLibrary.verifyText(existingAccountMessage,
					"You can use an existing account on any server you would like.");
			appLibrary.enterMobileText(username, usernameTextField);
			appLibrary.enterMobileText(password, pwdTextField);
			appLibrary.enterMobileText(serverName, serverTextField);
			appLibrary.sleep(2000);
			appLibrary.findElementForMobile(signInButton).click();
			appLibrary.sleep(5000);
		
		//appLibrary.terminateApp();
		return new SignUpSignInScreen(appLibrary);
	}

	public SignUpSignInScreen signUp(String username, String password) throws Exception {
		try {
			appLibrary.verifyText(createIDTitle, "Create an ID");
			appLibrary.enterMobileText(username, userIDTextField);
			appLibrary.enterMobileText(password, enterPwdTextField);
			appLibrary.enterMobileText(password, confirmPwdTextField);
			appLibrary.sleep(2000);
			// appLibrary.findElementForMobile(driver, registerButton).click();
			appLibrary.sleep(5000);
		} catch (Exception e) {
			appLibrary.openApp();
			appLibrary.verifyText(createIDTitle, "Create an ID");
			appLibrary.enterMobileText(username, userIDTextField);
			appLibrary.enterMobileText(password, enterPwdTextField);
			appLibrary.enterMobileText(password, confirmPwdTextField);
			// appLibrary.findElementForMobile(driver, registerButton).click();
		}
		appLibrary.openApp();
		return new SignUpSignInScreen(appLibrary);
	}
}
