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

public class AppHeaderArchiveUnarchiveTest extends TestBase {

	public Logger logger;
	SignUpSignInScreen signIn1, signIn2;
	WelcomeScreen wc1, wc2;
	ChatScreen cs1, cs2;
	AppHeaders header1, header2;
	Integer randInt;
	String roomName;
	String user1;
	String pass1;
	String server;
	String user;
	String pass;

	
	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary("AppHeader Archive Unarchive Test 1");
		appLibrary1 = new AppLibrary("AppHeader Archive Unarchive Test 2");
		logger = Logger.getLogger("AppHeader Archive Unarchive Test");
		PropertyConfigurator.configure("Log4j.properties");

		driver = (AppiumDriver<MobileElement>) appLibrary.getDriverInstance("device1", "4723");
		driver1 = (AppiumDriver<MobileElement>) appLibrary1.getDriverInstance("device2", "5000");
		user=appLibrary.getConfiguration().getUser1();
		pass=appLibrary.getConfiguration().getUser1Pass();
		user1=appLibrary.getConfiguration().getUser2();
		pass1=appLibrary.getConfiguration().getUser2Pass();
		server=appLibrary.getConfiguration().getKeanuServer();

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

		wc2.skipToSignIn();
		signIn2.accountSelection(true);
		signIn2.signIn(user1, pass1, server);
	}

	@Test(priority = 2)
	public void createChatRoom() throws Exception {
		roomName = "New Test Chat room " + randInt;

		cs1.verifyfindFriendUI(user);
		cs1.createChatRoomBySearchingFriend(user1, roomName);
		cs1.verifyChatRoom(roomName);

		cs2.joinChatGroups();
		cs2.verifyChatRoom(roomName);
	}

	@Test(priority = 3)
	public void archiveChatRoom() throws Exception {

		header1.navigateToActiveChats();
		header2.navigateToActiveChats();

		cs1.navigateToChatRoom(roomName);
		cs1.composeAndSendMessage("hi");
		appLibrary.navigateBack();
		cs1.archiveChatRoom(roomName);

		header2.navigateToActiveChats();
		cs2.verifyChatRoom(roomName);

		cs1.verifyChatRoomAbsence(roomName);
		header1.navigateToArchiveChats();
		header1.navigateToDiscover();
		header1.navigateToArchive();
		cs1.verifyChatRoom(roomName);
	}

	@Test(priority = 4)
	public void unArchiveChatRoom() throws Exception {
		cs1.unArchiveChatRoom(roomName);
		cs2.verifyChatRoom(roomName);

		cs1.verifyChatRoomAbsence(roomName);
		header1.navigateToActiveChats();
		header1.navigateToDiscover();
		header1.navigateToChat();
		cs1.verifyChatRoom(roomName);

		header2.navigateToActiveChats();
		cs2.verifyChatRoom(roomName);
	}
}
