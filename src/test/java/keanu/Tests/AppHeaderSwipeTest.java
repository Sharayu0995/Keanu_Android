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
import keanu.PageObject.ChatScreen;
import keanu.PageObject.SignUpSignInScreen;
import keanu.PageObject.WelcomeScreen;

public class AppHeaderSwipeTest extends TestBase {

	public Logger logger;
	AppHeaders header;
	SignInTest login;
	SignUpSignInScreen signIn;
	WelcomeScreen wc;
	ChatScreen cs;
	String user;
	String pass;
	String server;

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary("App Header Swip Test");
		logger = Logger.getLogger("App Header Swip Test");
		PropertyConfigurator.configure("Log4j.properties");
		driver = (AppiumDriver<MobileElement>) appLibrary.getDriverInstance();
		user=appLibrary.getConfiguration().getUser1();
		pass=appLibrary.getConfiguration().getUser1Pass();
		header = new AppHeaders(appLibrary);
		signIn = new SignUpSignInScreen(appLibrary);
		login = new SignInTest();
		wc = new WelcomeScreen(appLibrary);
		cs = new ChatScreen(appLibrary);
		server=appLibrary.getConfiguration().getKeanuServer();
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
	}

	@Test(priority = 1)
	public void userLogin() throws Exception {
		wc.skipToSignIn();
		signIn.accountSelection(true);
		signIn.signIn(user, pass, server);
	}

	@Test(priority = 2)
	public void headerVerification() throws Exception {
		header.navigateChatToFriend();
		header.verifyFriendScreen();

		header.navigateFriendToDiscover();
		header.verifyDiscoverScreen();

		header.navigateDiscoverToMyProfile();
		header.verifyMyProfileScreen();

		header.navigateMyProfileToDiscover();
		header.verifyDiscoverScreen();

		header.navigateDiscoverToFriend();
		header.verifyFriendScreen();

		header.navigateFriendToChat();
		header.verifyChatsScreen();
	}
}
