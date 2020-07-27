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

public class FriendsScreenTest extends TestBase {

	public Logger logger;
	SignUpSignInScreen signIn1;
	WelcomeScreen wc1;
	ChatScreen cs1;
	AppHeaders header1;
	String user;
	String pass;

	SignUpSignInScreen signIn2;
	WelcomeScreen wc2;
	ChatScreen cs2;
	AppHeaders header2;
	FriendsScreen fs;
	Integer randInt;
	String roomName;
	String sendMsg;
	String sendMsg1;
	String user1;
	String pass1;
	String server;

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary("Friends Screen Test 1");
		appLibrary1 = new AppLibrary("Friends Screen Test 2");
		logger = Logger.getLogger("Friends Screen Test");
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
		fs = new FriendsScreen(appLibrary);

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
	public void chatWithSpecificFriend() throws Exception {

		roomName = "New Test Chat room " + randInt;
		header1.navigateToFriends();
		fs.selectFriendAndCreateChatRoom(user1, roomName,"@"+user1+":"+server);
	//	"@" + "harpreet89" + ":neo.keanu.im"
		header1.navigateToChat();
		cs1.verifyChatRoom(roomName);

		cs2.joinChatGroups();
		cs2.verifyChatRoom(roomName);
	}

	@Test(priority = 3)
	public void deleteNewContact() throws Exception {
		header1.navigateToFriends();
		fs.addFriend(user1);
		fs.selectParticularUser(user1);
		fs.deleteContact(user1);
		header1.navigateToChat();
		header1.navigateToFriends();
		fs.verifyUserAbsence(user1);
	}

	@Test(priority = 4)
	public void addDeletedContact() throws Exception {
		header1.navigateToFriends();
		fs.addFriend(user1);
	}

	@Test(priority = 5)
	public void createGroupWithReAddedDeletedContact() throws Exception {
		fs.selectFriendAndCreateChatRoom(user1, roomName + randInt,"@"+user1+":"+server);
		header1.navigateToChat();
		cs1.verifyChatRoom(roomName + randInt);

		cs2.joinChatGroups();
		cs2.verifyChatRoom(roomName + randInt);
	}
}
