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
import keanu.PageObject.DiscoverScreen;
import keanu.PageObject.SignUpSignInScreen;
import keanu.PageObject.WelcomeScreen;

public class DiscoverScreenCheckServicesTest extends TestBase {

	public Logger logger;
	SignUpSignInScreen signIn;
	AppHeaders header;
	DiscoverScreen disc;
	WelcomeScreen wc;
	String user;
	String pass;
	String server;

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary("Discover Screen Check Services");
		logger = Logger.getLogger("Discover Screen Check Services");
		PropertyConfigurator.configure("Log4j.properties");

		driver = (AppiumDriver<MobileElement>) appLibrary.getDriverInstance();
		user = appLibrary.getConfiguration().getUser1();
		pass = appLibrary.getConfiguration().getUser1Pass();
		signIn = new SignUpSignInScreen(appLibrary);
		header = new AppHeaders(appLibrary);
		disc = new DiscoverScreen(appLibrary);
		wc = new WelcomeScreen(appLibrary);
		server = appLibrary.getConfiguration().getKeanuServer();
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
	public void checkServices() throws Exception {
		header.navigateToDiscover();
		disc.navigateToServices();
		appLibrary.navigateBack();
	}
}
