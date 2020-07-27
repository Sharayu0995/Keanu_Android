package keanu.Tests;

import java.util.concurrent.TimeUnit;
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

public class ChatCreateEditTest extends TestBase {

	public Logger logger;
	SignUpSignInScreen signIn1;
	WelcomeScreen wc1;
	ChatScreen cs1;
	AppHeaders header1;

	SignUpSignInScreen signIn2;
	WelcomeScreen wc2;
	ChatScreen cs2;
	AppHeaders header2;
	Integer randInt;
	String roomName;
	String editroomName;
	String sendMsg;
	String sendMsg1;
	String server;
	String user;
	String pass;
	String user1;
	String pass1;
	
	
	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary("Chat Create Edit Test 1");
		appLibrary1 = new AppLibrary("Chat Create Edit Test 2");
		logger = Logger.getLogger("Chat Create Edit Test");
		PropertyConfigurator.configure("Log4j.properties");

		driver = (AppiumDriver<MobileElement>) appLibrary.getDriverInstance("device1", "4723");
		driver1 = (AppiumDriver<MobileElement>) appLibrary1.getDriverInstance("device2", "5000");

		server = appLibrary.getConfiguration().getKeanuServer();
		user = appLibrary.getConfiguration().getUser1();
		pass = appLibrary.getConfiguration().getUser1Pass();
		user1 = appLibrary.getConfiguration().getUser2();
		pass1 = appLibrary.getConfiguration().getUser2Pass();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		signIn1 = new SignUpSignInScreen(appLibrary);
		wc1 = new WelcomeScreen(appLibrary);
		cs1 = new ChatScreen(appLibrary);
		header1 = new AppHeaders(appLibrary);

		signIn2 = new SignUpSignInScreen(appLibrary1);
		wc2 = new WelcomeScreen(appLibrary1);
		cs2 = new ChatScreen(appLibrary1);
		header2 = new AppHeaders(appLibrary1);

		randInt = AppLibrary.randIntDigits(9999, 999999);
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
	}

	@Test(priority = 1)
	public void userLogin() throws Exception {
		wc1.skipToSignIn();
		signIn1.accountSelection(true);
		signIn1.signIn(user, pass, server);
		header1.randomNavigate();

		wc2.skipToSignIn();
		signIn2.accountSelection(true);
		signIn2.signIn(user1, pass1, server);
		header2.randomNavigate();
	}

	@Test(priority = 2)
	public void createChatRoom() throws Exception {
		roomName = "New Test Chat room " + randInt;
		editroomName = "Chat room edited " + randInt;

		cs1.verifyfindFriendUI("testuser08");
		cs1.createChatRoomBySearchingFriend("@" + user1 + ":" + server, roomName);
		cs1.verifyChatRoom(roomName);

		cs2.joinChatGroups();
		cs2.verifyChatRoom(roomName);

		cs1.editChatRoomName(roomName, editroomName);
		cs1.verifyChatRoom(editroomName);
		header1.navigateToDiscover();
		header1.navigateToChat();
		cs1.verifyChatRoom(editroomName);

		header2.navigateToDiscover();
		header2.navigateToChat();
		cs2.verifyChatRoom(editroomName);
	}
}
