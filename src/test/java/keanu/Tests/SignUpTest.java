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

public class SignUpTest extends TestBase {

	public Logger logger;
	SignUpSignInScreen signUp;
	MyProfileScreen myProfile;
	AppHeaders header;
	WelcomeScreen wc;

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary("Sign-Up Test");
		logger = Logger.getLogger("Sign-Up Test");
		PropertyConfigurator.configure("Log4j.properties");
		driver = (AppiumDriver<MobileElement>) appLibrary.getDriverInstance();
		signUp = new SignUpSignInScreen(appLibrary);
		wc = new WelcomeScreen(appLibrary);
		myProfile = new MyProfileScreen(appLibrary);
		header = new AppHeaders(appLibrary);
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
	}

	@Test
	public void userSignUp() throws Exception {
		wc.skipToSignIn();
		signUp.accountSelection(false);
		signUp.signUp("testuser2", "pass123");
	}
}
