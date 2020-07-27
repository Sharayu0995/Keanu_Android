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
import keanu.PageObject.DiscoverScreen;
import keanu.PageObject.FriendsScreen;
import keanu.PageObject.MyProfileScreen;
import keanu.PageObject.SignUpSignInScreen;
import keanu.PageObject.WelcomeScreen;

public class CreateStoryTest extends TestBase
{
	
	
	SignUpSignInScreen signIn1;
	WelcomeScreen wc1;
	ChatScreen cs1;
	
	SignUpSignInScreen signIn2;
	WelcomeScreen wc2;
	ChatScreen cs2;
	AppHeaders header2;
	Integer randInt;
	String roomName;
	String sendMsg;
	String sendMsg1;
	String server;
	String user;
	String pass;
	String user1;
	String pass1;
	String user2;
	DiscoverScreen disc;
	public Logger logger;
	AppHeaders header;
	SignInTest login;
	AdditionalFunctionalityScreen menuOption;
	ChatScreen cs;
	MyProfileScreen myProfile;
	FriendsScreen fs;

	@BeforeClass
	public void setup() throws Exception
	{
		appLibrary = new AppLibrary("My Create Story Test");
		logger = Logger.getLogger("My Create Story Test");
		PropertyConfigurator.configure("Log4j.properties");
		driver = (AppiumDriver<MobileElement>) appLibrary.getDriverInstance();
		user=appLibrary.getConfiguration().getUser1();
		pass=appLibrary.getConfiguration().getUser1Pass();
		user1=appLibrary.getConfiguration().getUser2();
		pass1=appLibrary.getConfiguration().getUser2Pass();
		server=appLibrary.getConfiguration().getKeanuServer();
		header = new AppHeaders(appLibrary);
		signIn1 = new SignUpSignInScreen(appLibrary);
		login = new SignInTest();
		wc1 = new WelcomeScreen(appLibrary);
		menuOption = new AdditionalFunctionalityScreen(appLibrary);
		cs = new ChatScreen(appLibrary);
		myProfile = new MyProfileScreen(appLibrary);
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
	}
	
	@Test(priority = 1)
	public void login() throws Exception {
		wc1.skipToSignIn();
		signIn1.accountSelection(true);
		signIn1.signIn(user, pass, server);
	}
	
	@Test(priority = 2)
	public void createChatRoom() throws Exception
	{
		String chatRoom = "New Chat Room " + randInt;
		header.navigateToDiscover();
		header.navigateToChat();
		cs.createChatGroup(chatRoom,"denil");
	}
	

/*  @Test(priority =3)
	public void createStoryTest() throws Exception
	{
		appLibrary.sleep(1000);
		new ChatScreen(appLibrary).createStory("My Story");
	}*/
}
