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
import keanu.PageObject.AdditionalFunctionalityScreen;
import keanu.PageObject.AppHeaders;
import keanu.PageObject.ChatScreen;
import keanu.PageObject.MyProfileScreen;
import keanu.PageObject.SignUpSignInScreen;
import keanu.PageObject.WelcomeScreen;

public class MyAccountsTest extends TestBase {

	public Logger logger;
	AppHeaders header;
	SignInTest login;
	SignUpSignInScreen signIn;
	WelcomeScreen wc;
	ChatScreen cs;
	AdditionalFunctionalityScreen menuOption;
	MyProfileScreen myProfile;
	String user;
	String pass;
	String user1;
	String pass1;
	
	String server;

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary("My Accounts Test");
		logger = Logger.getLogger("My Accounts Test");
		PropertyConfigurator.configure("Log4j.properties");
		driver = (AppiumDriver<MobileElement>) appLibrary.getDriverInstance();
		user=appLibrary.getConfiguration().getUser1();
		pass=appLibrary.getConfiguration().getUser1Pass();
		user1=appLibrary.getConfiguration().getUser2();
		pass1=appLibrary.getConfiguration().getUser2Pass();
		server=appLibrary.getConfiguration().getKeanuServer();
		header = new AppHeaders(appLibrary);
		signIn = new SignUpSignInScreen(appLibrary);
		login = new SignInTest();
		wc = new WelcomeScreen(appLibrary);
		menuOption = new AdditionalFunctionalityScreen(appLibrary);
		cs = new ChatScreen(appLibrary);
		myProfile = new MyProfileScreen(appLibrary);
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
	}

	@Test(priority = 1)
	public void login() throws Exception {
		wc.skipToSignIn();
		signIn.accountSelection(true);
		signIn.signIn(user, pass, server);
	}

	@Test(priority = 2)
	public void myAcconuts() throws Exception {
		header.navigateToMyProfile();
		myProfile.userVerification(user, pass);
		menuOption.menuOptions();
		menuOption.myAccountNavigation();
		menuOption.myAccountVerification(user, server);
	}

	@Test(priority = 3)
	public void addAccount() throws Exception {
		
		menuOption.addAccount();
		//appLibrary.portraitOriantation();
		signIn.accountSelection(true);
		
		signIn.signIn(user1, pass1, server);
		
		header.navigateToChat();
		appLibrary.sleep(5000);
		header.navigateToMyProfile();
		myProfile.userVerification(user1, pass1);
		menuOption.clickOnMoreOption();
		
		menuOption.myAccountNavigation();
		menuOption.myAccountVerification(user1, server);

	}

	@Test(priority = 4)
	public void activateDeactivateAccount() throws Exception {
		menuOption.deactivateAccount(server);
		menuOption.activateAccount(server);
	}

	@Test(priority = 5)
	public void defaultAccountChange() throws Exception {
		menuOption.accountChange(user);
		appLibrary.navigateBack();
		myProfile.userVerification(user, pass);
		menuOption.clickOnMoreOption();
		menuOption.myAccountNavigation();
		menuOption.accountChange(user1);
		appLibrary.navigateBack();
		myProfile.userVerification(user1, pass1);
	}

	// public void checkSettings(){
	// menuOption.settingsNavigation();
	// menuOption.settingUI();
	// }*/
}
