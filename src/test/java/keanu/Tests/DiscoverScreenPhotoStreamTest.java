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
import keanu.PageObject.DiscoverScreen;
import keanu.PageObject.SignUpSignInScreen;
import keanu.PageObject.WelcomeScreen;

public class DiscoverScreenPhotoStreamTest extends TestBase {

	public Logger logger;
	SignUpSignInScreen signIn;
	AppHeaders header;
	WelcomeScreen wc;
	ChatScreen cs;
	DiscoverScreen disc;
	Integer randInt;
	String user;
	String pass;
	String server;

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary("Discover Screen Photo Stream Test");
		logger = Logger.getLogger("Discover Screen Photo Stream Test");
		PropertyConfigurator.configure("Log4j.properties");

		driver = (AppiumDriver<MobileElement>) appLibrary.getDriverInstance();
		user = appLibrary.getConfiguration().getUser1();
		pass = appLibrary.getConfiguration().getUser1Pass();
		signIn = new SignUpSignInScreen(appLibrary);
		header = new AppHeaders(appLibrary);
		wc = new WelcomeScreen(appLibrary);
		disc = new DiscoverScreen(appLibrary);
		cs = new ChatScreen(appLibrary);
		server=appLibrary.getConfiguration().getKeanuServer();
		
		randInt = AppLibrary.randIntDigits(9999, 999999);
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
	public void checkPhotoStream() throws Exception {
		header.navigateToDiscover();
		disc.navigateToPhotoStream();
		appLibrary.navigateBack();
	}
}
