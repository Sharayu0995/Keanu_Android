package keanu.Tests;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import keanu.Library.AppLibrary;
import keanu.Library.TestBase;
import keanu.PageObject.AppHeaders;
import keanu.PageObject.MyProfileScreen;
import keanu.PageObject.SignUpSignInScreen;
import keanu.PageObject.WelcomeScreen;

public class MyProfileSignInTest extends TestBase {

	public Logger logger;
	SignUpSignInScreen signIn;
	MyProfileScreen myProfile;
	AppHeaders header;
	WelcomeScreen wc;
	String user;
	String pass;
	String server;

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary("MyProfile Sign-In Test");
		logger = Logger.getLogger("MyProfile Sign-In Test");
		PropertyConfigurator.configure("Log4j.properties");
		driver = (AppiumDriver<MobileElement>) appLibrary.getDriverInstance();
		user=appLibrary.getConfiguration().getUser1();
		pass=appLibrary.getConfiguration().getUser1Pass();
		server=appLibrary.getConfiguration().getKeanuServer();
		signIn = new SignUpSignInScreen(appLibrary);
		myProfile = new MyProfileScreen(appLibrary);
		header = new AppHeaders(appLibrary);
		wc = new WelcomeScreen(appLibrary);
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
	}

	@Test(priority = 1)
	public void userLogin() throws Exception {
		wc.skipToSignIn();
		signIn.accountSelection(true);
		signIn.signIn(user, pass,server);
	}
	@Test(priority = 2)
	public void verifyUser() throws Exception {
		header.navigateToMyProfile();
		myProfile.userVerification(user, pass);
		header.myAccountVerification(user, server);
	}

/*	@Test(priority = 3)
	public void checkDevicesAndKeys() throws Exception
	{	appLibrary.navigateBack();
		myProfile.deviceKeyVerify(false,true);
	}*/

	// @Test(priority = 3)
	// public void uploadProfilePicture() {
	// myProfile.addProfilePictureViaCamera();
	// myProfile.addProfilePictureViaFile();
	// }
}
