package keanu.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import keanu.Library.AppLibrary;

public class FriendsScreen {

	private AppLibrary appLibrary;

	public static String checkFriend = "xpath://android.widget.TextView[contains(@text,'@replace:neo.keanu.im')]";
	public static String startChat = "id:info.guardianproject.keanuapp:id/btnStartChat";
	public static String groupInfo = "id:info.guardianproject.keanuapp:id/menu_group_info";
	public static String groupName = "id:info.guardianproject.keanuapp:id/tvGroupName";
	public static String editGroupSubject = "id:info.guardianproject.keanuapp:id/edit_group_subject";
	public static String editGroupTextField = "class:android.widget.EditText";
	public static String clickOKButton = "xpath://android.widget.Button[@text='OK']";
	public static String searchHistory = "id:info.guardianproject.keanuapp:id/menu_search";

	// Delete Contact
	public static String kebabMenu = "xpath://android.widget.ImageView[@content-desc='More options']";
	public static String deleteContact = "xpath://android.widget.TextView[contains(@text,'Delete Contact')]";
	public static String deleteContactPopup = "id:info.guardianproject.keanuapp:id/alertTitle";
	public static String deleteContactMessage = "id:android:id/message";
	public static String okButton = "xpath://android.widget.Button[contains(@text,'OK')]";

	// Add Friend
	public static String clickOnAddFriend = "id:info.guardianproject.keanuapp:id/fab";
	public static String findFriendTextField = "id:info.guardianproject.keanuapp:id/email";
	public static String addFriendButton = "id:info.guardianproject.keanuapp:id/btnAddFriend";
	public static String clickOnParticularUser = "xpath://android.widget.LinearLayout//android.widget.TextView[@text='replace']";

	public FriendsScreen(AppLibrary appLibrary) throws Exception {
		this.appLibrary = appLibrary;
	}

	public void addFriend(String friendName) throws Exception {
		appLibrary.findElementForMobile(clickOnAddFriend).click();
		appLibrary.enterMobileText(friendName, findFriendTextField);
		appLibrary.sleep(5000);
		appLibrary.findElementForMobile(addFriendButton).click();
		appLibrary.sleep(5000);
		appLibrary.navigateBack();
	}

	public void selectParticularUser(String friendName) throws Exception {
		appLibrary.findElementForMobile(clickOnParticularUser.replace("replace", friendName)).click();
	}

	public void verifyUserAbsence(String friendName) {
		appLibrary.verifyAbsent(clickOnParticularUser.replace("replace", friendName));
	}

	public void deleteContact(String un) throws Exception {
		appLibrary.findElementForMobile(kebabMenu).click();
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(deleteContact).click();
		appLibrary.verifyText(deleteContactPopup, "Delete Contact");
		appLibrary.verifiyContains(deleteContactMessage, un);
		appLibrary.verifiyContains(deleteContactMessage, "will be deleted.");
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(okButton).click();
	}

	public void selectFriendAndCreateChatRoom(String friend, String roomName, String verifyText) throws Exception {
		try {
			appLibrary.findElementForMobile(checkFriend.replace("replace", friend)).click();
			appLibrary.verifyText(checkFriend.replace("replace", friend), verifyText);
			appLibrary.findElementForMobile(startChat).click();

			appLibrary.findElementForMobile(groupInfo).click();
			appLibrary.findElementForMobile(editGroupSubject).click();
			appLibrary.enterMobileText(roomName, editGroupTextField);
			appLibrary.findElementForMobile(clickOKButton).click();
			appLibrary.sleep(5000);
			navBack();
		} catch (Exception e) {
			createChatRoomBySearchingFriend(friend, roomName);
		}
	}

	public void createChatRoomBySearchingFriend(String friendName, String RoomName) throws Exception {
		appLibrary.findElementForMobile(clickOnAddFriend).click();
		appLibrary.findElementForMobile(addFriendButton).click();
		appLibrary.enterMobileText(friendName, findFriendTextField);
		appLibrary.findElementForMobile(addFriendButton).click();
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(groupInfo).click();
		appLibrary.findElementForMobile(editGroupSubject).click();
		appLibrary.enterMobileText(RoomName, editGroupTextField);
		appLibrary.findElementForMobile(clickOKButton).click();
		appLibrary.sleep(3000);
		navBack();
	}

	public void navBack() throws Exception {
		appLibrary.navigateBack();
		appLibrary.navigateBack();
		try {
			appLibrary.findElementForMobile(searchHistory);
		} catch (Exception e) {
			appLibrary.navigateBack();
			appLibrary.findElementForMobile(searchHistory);
		}
	}
}
