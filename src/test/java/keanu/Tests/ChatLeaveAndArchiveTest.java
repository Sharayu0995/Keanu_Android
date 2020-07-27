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
import keanu.PageObject.FriendsScreen;
import keanu.PageObject.SignUpSignInScreen;
import keanu.PageObject.WelcomeScreen;

public class ChatLeaveAndArchiveTest extends TestBase {

	public Logger logger;
	SignUpSignInScreen signIn1;
	WelcomeScreen wc1;
	ChatScreen cs1;
	AppHeaders header1;
	FriendsScreen fs1;

	SignUpSignInScreen signIn2;
	WelcomeScreen wc2;
	ChatScreen cs2;
	AppHeaders header2;
	FriendsScreen fs2;

	Integer randInt;
	String roomName;
	String sendMsg;
	String sendMsg1;
	String server;
	String user;
	String pass;
	String user1;
	String pass1;

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary("Chat Leave And Archive Test 1");
		appLibrary1 = new AppLibrary("Chat Leave And Archive Test 2");
		logger = Logger.getLogger("Chat Leave And Archive Test");
		PropertyConfigurator.configure("Log4j.properties");

		driver = (AppiumDriver<MobileElement>) appLibrary.getDriverInstance("device1", "4723");
		driver1 = (AppiumDriver<MobileElement>) appLibrary1.getDriverInstance("device2", "5000");
		server = appLibrary.getConfiguration().getKeanuServer();
		user = appLibrary.getConfiguration().getUser1();
		pass = appLibrary.getConfiguration().getUser1Pass();
		user1 = appLibrary.getConfiguration().getUser2();
		pass1 = appLibrary.getConfiguration().getUser2Pass();

		signIn1 = new SignUpSignInScreen(appLibrary);
		wc1 = new WelcomeScreen(appLibrary);
		cs1 = new ChatScreen(appLibrary);
		header1 = new AppHeaders(appLibrary);
		fs1 = new FriendsScreen(appLibrary);

		signIn2 = new SignUpSignInScreen(appLibrary1);
		wc2 = new WelcomeScreen(appLibrary1);
		cs2 = new ChatScreen(appLibrary1);
		header2 = new AppHeaders(appLibrary1);
		fs2 = new FriendsScreen(appLibrary1);
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
//		cs1.verifyfindFriendUI("agam89");
		cs1.createChatRoomBySearchingFriend("@" + user1 + ":" + server, roomName);
		appLibrary.terminateApp();

		cs1.verifyChatRoom(roomName);

		cs2.joinChatGroups();
		cs2.verifyChatRoom(roomName);
	}

	@Test(priority = 3)
	public void archiveRoomFromGroupInfo() throws Exception {
		cs1.archiveChatRoomFromChatInfo(roomName);
		cs1.verifyChatRoomAbsence(roomName);

		header2.navigateToActiveChats();
		cs2.verifyChatRoom(roomName);

		header1.navigateToArchiveChats();
		cs1.unArchiveChatRoom(roomName);

		header2.navigateToActiveChats();
		cs2.verifyChatRoom(roomName);

		cs1.verifyChatRoomAbsence(roomName);
		appLibrary.terminateApp();
		header1.navigateToActiveChats();
		cs1.verifyChatRoom(roomName);

		header2.navigateToActiveChats();
		cs2.verifyChatRoom(roomName);
	}

	@Test(priority = 4)
	public void leaveRoomFromGroupInfo() throws Exception {
		cs1.leaveRoom(roomName);
		cs1.verifyChatRoomAbsence(roomName);
		header1.navigateToArchiveChats();
		cs1.verifyChatRoomAbsence(roomName);

		cs2.leaveRoom(roomName);
		cs2.verifyChatRoomAbsence(roomName);
		header2.navigateToArchiveChats();
		cs2.verifyChatRoomAbsence(roomName);

	}

	@Test(priority = 5)
	public void DeleteContact() throws Exception {

		header1.navigateToFriends();
		fs1.selectParticularUser(user1);
		fs1.deleteContact(user);

		header2.navigateToFriends();
		fs2.selectParticularUser(user);
		fs2.deleteContact(user1);
	}
}
