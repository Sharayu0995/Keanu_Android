package keanu.PageObject;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import keanu.Library.AppLibrary;

public class ChatScreen {

	private AppLibrary appLibrary;

	public static String chatRoomName = "xpath://android.widget.TextView[@text='replace']";
	public static String endPoint = "id:info.guardianproject.keanuapp:id/statusText";
	public static String searchHistory = "id:info.guardianproject.keanuapp:id/menu_search";

	public static String createChatRoomButton = "id:info.guardianproject.keanuapp:id/fab";
	public static String createGroupButton = "id:info.guardianproject.keanuapp:id/btnCreateGroup";
	public static String startChatTick = "id:info.guardianproject.keanuapp:id/action_start_chat";

	public static String findFriendTextField = "id:info.guardianproject.keanuapp:id/email";
	public static String addFriend = "xpath://android.widget.TextView[@text='Add friend']";
	public static String addFriendButton = "id:info.guardianproject.keanuapp:id/btnAddFriend";

	public static String availableFriendInList = "xpath://android.widget.TextView[@text='replace']";
	public static String selectedAvtarCheck = "xpath://android.widget.ImageView[@resource-id='info.guardianproject.keanuapp:id/avatarCheck']";

	public static String groupInfo = "id:info.guardianproject.keanuapp:id/menu_group_info";
	public static String groupName = "id:info.guardianproject.keanuapp:id/tvGroupName";
	public static String editGroupSubject = "id:info.guardianproject.keanuapp:id/edit_group_subject";
	public static String editGroupTextField = "class:android.widget.EditText";
	public static String clickOKButton = "xpath://android.widget.Button[@text='OK']";

	public static String addFriendsInGroup = "id:info.guardianproject.keanuapp:id/tvActionAddFriends";
	public static String notificationTitle = "xpath://android.widget.TextView[@text='Notifications']";
	public static String notificationTogglSwitch = "id:info.guardianproject.keanuapp:id/chkNotifications";
	public static String leaveRoom = "id:info.guardianproject.keanuapp:id/tvActionLeave";
	public static String leaveRoomPopupTitle = "id:info.guardianproject.keanuapp:id/alertTitle";
	public static String leaveRoomMessage = "id:android:id/message";
	public static String archiveRoomButton = "xpath://android.widget.Button[contains(@text,'Archive')] | //android.widget.Button[contains(@text,'ARCHIVE')]";
	public static String cancelRoomButton = "xpath://android.widget.Button[contains(@text,'Cancel')] | //android.widget.Button[contains(@text,'CANCEL')]";
	public static String leaveRoomButton = "xpath://android.widget.Button[contains(@text,'Leave')] | //android.widget.Button[contains(@text,'LEAVE')]";

	public static String clickOnParticularChatRoom = "xpath://android.widget.LinearLayout//android.widget.TextView[@text='replace']";

	public static String composeMesage = "id:info.guardianproject.keanuapp:id/composeMessage";
	public static String sendMsgButton = "id:info.guardianproject.keanuapp:id/btnSend";
	public static String attachButton = "id:info.guardianproject.keanuapp:id/btnAttach";
	public static String verifyMessage = "xpath://android.widget.TextView[@text='replace']";

	public static String attachPicture = "id:info.guardianproject.keanuapp:id/btnAttachPicture";
	public static String takePicture = "id:info.guardianproject.keanuapp:id/btnTakePicture";
	public static String attachSticker = "id:info.guardianproject.keanuapp:id/btnAttachSticker";
	public static String attachAudio = "id:info.guardianproject.keanuapp:id/btnAttachAudio";
	public static String attachFiles = "id:info.guardianproject.keanuapp:id/btnAttachFile";

	public static String whaleSticker = "xpath://android.widget.ImageView[@content-desc='success-whale.png']";
	public static String windSailSticker = "xpath://android.widget.ImageView[@content-desc='windsail.png']";
	public static String verifySticker = "xpath:(//android.widget.ImageView[@resource-id='info.guardianproject.keanuapp:id/media_thumbnail'])[1]";
	public static String micButton = "id:info.guardianproject.keanuapp:id/btnMic";
	public static String holdToTalkOnMic = "id:info.guardianproject.keanuapp:id/buttonHoldToTalk";
	public static String playButton = "xpath:(//android.widget.ImageView[@resource-id='info.guardianproject.keanuapp:id/play'])[1]";
	public static String seekBarButton = "xpath://android.widget.SeekBar[@instance='0']";
	public static String chatGroupsList = "xpath://android.widget.TextView[contains(@text,'You have been invited')]";
	public static String chatGroups = "xpath:(//android.widget.TextView[contains(@text,'invited to chat')])[replace]";
	public static String joinGroup = "id:info.guardianproject.keanuapp:id/btnJoinAccept";
	public static String declineJoiningGroup = "id:info.guardianproject.keanuapp:id/btnJoinDecline";
	public static String clickOnFriend = "xpath:(//android.widget.TextView[contains(@text,'replace')])[1]";
	public static String checkMembers = "xpath://android.widget.TextView[contains(@text,'@replace:neo.keanu.im')]";
	public static String checkSelfStatus = "xpath://android.widget.TextView[contains(@text,'replace (you)')]";

	public static String findYourFiend = "xpath://android.widget.TextView[contains(@text,'Find your friend')]";
	public static String inviteLinkOptions = "xpath://android.widget.TextView[contains(@text,'Send your invite link')]";
	public static String shareOptions = "xpath://android.widget.TextView[contains(@text,'Standing next to them?')]";

	public static String chooseAFriendTitle = "xpath://android.widget.TextView[contains(@text,'Choose a Friend')]";
	
	//Locators: Create Story
	public static String selectGroup="xpath:(//android.widget.TextView[@index='0'])[3]";
	public static String attachBtn="id:btnAttach";
	public static String attachCreateStory="id:btnCreateStory";
	public static String storyTitle="id:editTitle";
	public static String addMedia="id:action_add_media";
	public static String postaudioAsStory="id:btnMicrophone";
	public static String sendaudiofileAsStory="id:btnSend";
	public static String sendaudioFileinChatRoom="id:menu_send";
	public static String verifyStory="id:media_thumbnail";
	
	public static String createGroup="id:fab";
	
	public static String searchFriend="id:email";
	public static String clickonAddFriendBtn="id:btnAddFriend";
	public static String moreinfoBtn="id:menu_group_info";
	public static String editGroupName="id:edit_group_subject";
	public static String enterRoomName="id:custom";
	public static String clickonOkBtn="xpath://android.widget.Button[@text='OK']";
	public static String takeBack="xpath://android.widget.ImageButton[@content-desc='‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‎‎‏‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‎‏‏‎‏‎‎‎‎‎‏‏‏‎‏‎‎‎‎‎‏‏‎‏‏‎‎‏‎‏‎‏‏‏‏‏‎‎Navigate up‎‏‎‎‏‎']";
	

	public ChatScreen(AppLibrary appLibrary) {
		this.appLibrary = appLibrary;
	}

	public void verifyfindFriendUI(String userName) throws Exception {
		appLibrary.findElementForMobile(createChatRoomButton).click();
		appLibrary.sleep(2000);
		try {
			appLibrary.findElementForMobile(addFriend).click();
			appLibrary.sleep(2000);
		} catch (Exception e) {
			// no friend in contacts available so add friend option is not
			// available
		}
		appLibrary.openApp();
		appLibrary.verifyText(findYourFiend, "Find your friend");
		appLibrary.verifyText(inviteLinkOptions, "Send your invite link");
		appLibrary.verifyText(shareOptions, "Standing next to them?");
		appLibrary.navigateBack();
		try {
			appLibrary.findElementForMobile(chooseAFriendTitle);
			appLibrary.navigateBack();
		} catch (Exception e) {
			// On main screen
		}
		appLibrary.openApp();
	}

	public void checkMemberList(String chatGroupName, String userName, Boolean self) throws Exception {
		navigateToChatRoom(chatGroupName);
		appLibrary.findElementForMobile(groupInfo).click();
		appLibrary.verifyText(checkMembers.replace("replace", userName), "@" + userName + ":neo.keanu.im");
		if (self)
			appLibrary.verifyText(checkSelfStatus.replace("replace", userName), userName + " (you)");
		navBack();
	}

	public void joinChatGroups() throws Exception {
		appLibrary.sleep(5000);
		appLibrary.terminateApp();
		try {
			List<MobileElement> list = appLibrary.findElementsForMobile(chatGroupsList);
			int size = list.size();
			for (int i = 0; i < size; i++) {
				appLibrary.findElementForMobile(chatGroups.replace("replace", Integer.toString(i + 1))).click();
				try {
					appLibrary.findElementForMobile(joinGroup).click();
				} catch (Exception e) {

				}

				appLibrary.navigateBack();
			}
			appLibrary.sleep(5000);
		} catch (Exception e) {
			appLibrary.reopenApp();
			List<MobileElement> list = appLibrary.findElementsForMobile(chatGroupsList);
			int size = list.size();
			for (int i = 0; i < size; i++) {
				appLibrary.findElementForMobile(chatGroups.replace("replace", Integer.toString(i + 1))).click();
				try {
					appLibrary.findElementForMobile(joinGroup).click();
				} catch (Exception e1) {
				}

				appLibrary.navigateBack();
			}
			appLibrary.sleep(5000);
		}
	}

	public void composeAndSendMessage(String msg1) throws Exception {
		appLibrary.enterMobileText(msg1, composeMesage);
		appLibrary.findElementForMobile(sendMsgButton).click();
		appLibrary.sleep(10000);
	}

	public void attachments(Boolean sticker1, Boolean sticker2) throws Exception {
		appLibrary.findElementForMobile(attachButton).click();
		if (sticker1) {
			appLibrary.findElementForMobile(attachSticker).click();
			appLibrary.findElementForMobile(whaleSticker).click();
			appLibrary.sleep(10000);
		}
		if (sticker2) {
			appLibrary.findElementForMobile(attachSticker).click();
			appLibrary.findElementForMobile(windSailSticker).click();
			appLibrary.sleep(10000);
		}
	}

	public void verifySendMessage(String msg) throws Exception {
		appLibrary.verifyText(verifyMessage.replace("replace", msg), msg);
	}

	public void verifySendStickers() throws Exception {
		appLibrary.findElementForMobile(verifySticker);
	}

	public void verifyVoiceMessage() throws Exception {
		appLibrary.findElementForMobile(playButton);
		appLibrary.findElementForMobile(seekBarButton);
	}
	
	public void verifyStory() throws Exception
	{
		appLibrary.verifyMobileElement(verifyStory);
		appLibrary.findElementForMobile(verifyStory);
	}
	public void sendVoiceMsg() throws Exception {
		appLibrary.findElementForMobile(micButton).click();
		appLibrary.horizontalSwipe(holdToTalkOnMic, sendMsgButton);
		appLibrary.sleep(10000);
	}

	public void createChatRoomBySearchingFriend(String friendName, String RoomName) throws Exception {
		appLibrary.findElementForMobile(createChatRoomButton).click();
		appLibrary.findElementForMobile(addFriendButton).click();
		appLibrary.enterMobileText(friendName, findFriendTextField);
		appLibrary.findElementForMobile(addFriendButton).click();
		appLibrary.sleep(3000);

		try {
			appLibrary.findElementForMobile(groupInfo).click();
			appLibrary.findElementForMobile(editGroupSubject).click();
			appLibrary.enterMobileText(RoomName, editGroupTextField);
			appLibrary.findElementForMobile(clickOKButton).click();
			appLibrary.sleep(3000);
			navBack();
		} catch (Exception e) {
			appLibrary.reopenApp();
			appLibrary.findElementForMobile(groupInfo).click();
			appLibrary.findElementForMobile(editGroupSubject).click();
			appLibrary.enterMobileText(RoomName, editGroupTextField);
			appLibrary.findElementForMobile(clickOKButton).click();
			appLibrary.sleep(3000);
			navBack();
		}
	}

	public void navigateToChatRoom(String chatRoom) throws Exception
	{
		appLibrary.findElementForMobile(clickOnParticularChatRoom.replace("replace", chatRoom)).click();
	}

	public void editChatRoomName(String chatGroupName, String editedName) throws Exception {
		navigateToChatRoom(chatGroupName);
		appLibrary.findElementForMobile(groupInfo).click();
		appLibrary.verifyText(groupName, chatGroupName);
		appLibrary.findElementForMobile(editGroupSubject).click();
		appLibrary.enterMobileText(editedName, editGroupTextField);
		appLibrary.findElementForMobile(clickOKButton).click();
		appLibrary.sleep(5000);
		navBack();
	}

	public void addingFriendInExistingRoom(String chatGroupName, String friendName) throws Exception {
		navigateToChatRoom(chatGroupName);
		appLibrary.findElementForMobile(groupInfo).click();
		appLibrary.findElementForMobile(addFriendsInGroup).click();
		appLibrary.findElementForMobile(addFriend).click();
		appLibrary.enterMobileText(friendName, findFriendTextField);
		appLibrary.findElementForMobile(addFriendButton).click();
		appLibrary.sleep(3000);
		navBack();
	}

	public void leaveRoom(String chatGroupName) throws Exception {
		navigateToChatRoom(chatGroupName);
		appLibrary.findElementForMobile(groupInfo).click();
		appLibrary.sleep(2000);
		appLibrary.findElementForMobile(leaveRoom).click();
		appLibrary.verifyText(leaveRoomMessage,
				"Your group chat history will be wiped away. To keep these chats, archive the group instead.");
		appLibrary.verifyText(leaveRoomPopupTitle, "Leave Group?");

		appLibrary.findElementForMobile(cancelRoomButton).click();
		appLibrary.sleep(2000);
		appLibrary.findElementForMobile(leaveRoom).click();
		appLibrary.verifyText(leaveRoomMessage,
				"Your group chat history will be wiped away. To keep these chats, archive the group instead.");
		appLibrary.verifyText(leaveRoomPopupTitle, "Leave Group?");

		appLibrary.findElementForMobile(leaveRoomButton).click();
		appLibrary.sleep(2000);
		verifyChatRoomAbsence(chatGroupName);
	}

	public void archiveChatRoomFromChatInfo(String chatGroupName) throws Exception {
		navigateToChatRoom(chatGroupName);
		appLibrary.enterMobileText(chatGroupName, composeMesage);
		appLibrary.findElementForMobile(sendMsgButton).click();
		appLibrary.findElementForMobile(groupInfo).click();
		appLibrary.sleep(2000);
		appLibrary.findElementForMobile(leaveRoom).click();
		appLibrary.verifyText(leaveRoomMessage,
				"Your group chat history will be wiped away. To keep these chats, archive the group instead.");
		appLibrary.verifyText(leaveRoomPopupTitle, "Leave Group?");
		appLibrary.findElementForMobile(archiveRoomButton).click();
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

	public void archiveChatRoom(String RoomName) throws Exception {
		appLibrary.horizontalSwipe(chatRoomName.replace("replace", RoomName), endPoint);
	}

	public void verifyChatRoom(String RoomName) throws Exception {
		appLibrary.findElementForMobile(chatRoomName.replace("replace", RoomName));
	}

	public void verifyChatRoomAbsence(String RoomName) {
		appLibrary.verifyAbsent(chatRoomName.replace("replace", RoomName));
	}

	public void unArchiveChatRoom(String RoomName) throws Exception {
		appLibrary.horizontalSwipe(chatRoomName.replace("replace", RoomName), endPoint);
	}
	
	
	
	public ChatScreen createStory(String storyName) throws Exception
	{
		
		//appLibrary.verifyMobileElement(verifyChatIcon);
		
		appLibrary.verifyMobileElement(selectGroup);
		appLibrary.clickMobileElement(selectGroup);
		appLibrary.verifyMobileElement(attachBtn);
		appLibrary.clickMobileElement(attachBtn);
		appLibrary.verifyMobileElement(attachCreateStory);
		appLibrary.clickMobileElement(attachCreateStory);
		appLibrary.verifyMobileElement(storyTitle);
		appLibrary.enterMobileText(storyName, storyTitle);
		appLibrary.verifyMobileElement(addMedia);
		appLibrary.clickMobileElement(addMedia);
		appLibrary.verifyMobileElement(postaudioAsStory);
		appLibrary.longPressElement(postaudioAsStory);
		appLibrary.sleep(1000);
		appLibrary.verifyMobileElement(sendaudiofileAsStory);
		appLibrary.clickMobileElement(sendaudiofileAsStory);
		appLibrary.sleep(1000);
		appLibrary.verifyMobileElement(sendaudioFileinChatRoom);
		appLibrary.clickMobileElement(sendaudioFileinChatRoom);
		appLibrary.sleep(2000);
		return new ChatScreen(appLibrary);
		
	}
	
	public void createChatGroup(String chatGroupName,String friendName) throws Exception
	{
			
		appLibrary.findElementForMobile(createGroup).click();
		//appLibrary.findElementForMobile(clickonCreateRoom).click();
	
		appLibrary.clickMobileElement(searchFriend);
		appLibrary.enterMobileText(searchFriend,friendName);
		appLibrary.clickMobileElement(searchFriend);
		appLibrary.findElementForMobile(clickonAddFriendBtn).click();
		appLibrary.sleep(5000);
		appLibrary.verifyMobileElement(moreinfoBtn);
		appLibrary.findElementForMobile(moreinfoBtn).click();
		appLibrary.findElementForMobile(editGroupName).click();
		appLibrary.enterMobileText(chatGroupName, enterRoomName);
		appLibrary.clickMobileElement(clickonOkBtn);
		appLibrary.sleep(1000);
		appLibrary.verifyMobileElement(clickOnParticularChatRoom.replace("replace", chatGroupName));
		appLibrary.clickMobileElement(takeBack);
		
		
	}
}
