package keanu.PageObject;

import keanu.Library.AppLibrary;

public class AppHeaders {

	private AppLibrary appLibrary;

	public static String chatScreen = "xpath://androidx.appcompat.app.ActionBar.Tab[@content-desc='Chats']";
	public static String friendScreen = "xpath://androidx.appcompat.app.ActionBar.Tab[@content-desc='Contacts']";
	public static String discoverScreen = "xpath://androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Discover\"]/android.widget.ImageView";
	
	public static String myProfileScreen="xpath://androidx.appcompat.app.ActionBar.Tab[@content-desc='Me']/android.widget.ImageView";
	public static String searchHistory = "id:info.guardianproject.keanuapp:id/menu_search";
	public static String hamburgerButton = "id:info.guardianproject.keanuapp:id/menu_sort";
	public static String threeDotsButton = "xpath://android.widget.ImageView[@content-desc='More options']";
	public static String searchEditor = "id:info.guardianproject.keanuapp:id/search_src_text";
	public static String searchResultVerify = "xpath://android.widget.TextView[@text='replace']";
	public static String cancelSearchEditor = "id:info.guardianproject.keanuapp:id/search_close_btn";
	public static String friendsScreenTitle = "xpath://android.widget.TextView[@text='Keanu | Friends']";
	public static String discoverScreenTitle = "xpath://android.widget.TextView[@text='Keanu | Discover']";
	public static String myProfileScreenTitle = "xpath://android.widget.TextView[@text='Keanu | Me']";
	public static String chatsScreenTitle = "xpath://android.widget.TextView[@text='Keanu | Chats']";
	public static String archiveScreenTitle = "xpath://android.widget.TextView[@text='Keanu | Archive']";

	public static String activeMenuOption = "xpath://android.widget.TextView[@text='Active']";
	public static String archiveMenuOption = "xpath://android.widget.TextView[@text='Archive']";

	public static String myAccountsMenuOption = "xpath://android.widget.TextView[@text='My Accounts']";
	public static String settingsMenuOption = "xpath://android.widget.TextView[@text='Settings']";
	public static String lockAppMenuOption = "xpath://android.widget.TextView[@text='Lock the app']";
	public static String signOutMenuOption = "xpath://android.widget.TextView[@text='Sign out']";

	public static String navigateBack = "xpath:(//android.widget.ImageButton)[1]";

	public static String userName = "xpath://android.widget.TextView[contains(@resource-id,'providerName')]";
	public static String server = "xpath://android.widget.TextView[contains(@resource-id,'loginName')]";
	//public static String fullScreen = "id:viewpager";
    public static String fullScreen="id:action_bar_root";
	public static String closeAppButton = "id:android:id/aerr_close";

	public AppHeaders(AppLibrary appLibrary) {
		this.appLibrary = appLibrary;
	}

	public void randomNavigate() throws Exception {
		appLibrary.terminateApp();
		Boolean next = true;
		int i;
		try {
			for (i = 1; i < 4; i++) {
				headerNavigate();
				if (i == 3) {
					next = false;
				}
			}
			try {
				if (!(next == false)) {
					appLibrary.reopenApp();
				}
			} catch (Exception e) {
				appLibrary.reopenApp();
			}

		} catch (Exception e1) {
			appLibrary.reopenApp();
		}
	}

	public AppHeaders verifyHeaders() throws Exception {
		appLibrary.verifyMobileElement(searchHistory);
		appLibrary.verifyMobileElement(hamburgerButton);
		appLibrary.verifyMobileElement(threeDotsButton);
		return new AppHeaders(appLibrary);
	}

	public AppHeaders navigateToChat() throws Exception {
		appLibrary.findElementForMobile(chatScreen).click();
		appLibrary.sleep(1000);
		appLibrary.verifyText(chatsScreenTitle, "Keanu | Chats");
		verifyHeaders();
		return new AppHeaders(appLibrary);
	}

	public AppHeaders navigateToArchive() throws Exception {
		appLibrary.findElementForMobile(chatScreen).click();
		appLibrary.verifyText(archiveScreenTitle, "Keanu | Archive");
		verifyHeaders();
		return new AppHeaders(appLibrary);
	}

	public void headerNavigate() throws Exception {
		appLibrary.findElementForMobile(friendScreen).click();
		appLibrary.findElementForMobile(discoverScreen).click();
		appLibrary.findElementForMobile(myProfileScreen).click();
		appLibrary.findElementForMobile(chatScreen).click();
	}

	public AppHeaders navigateToFriends() throws Exception {
		appLibrary.findElementForMobile(friendScreen).click();
		appLibrary.verifyText(friendsScreenTitle, "Keanu | Friends");
		verifyHeaders();
		return new AppHeaders(appLibrary);
	}

	public AppHeaders navigateToDiscover() throws Exception {
		appLibrary.findElementForMobile(discoverScreen).click();
		appLibrary.verifyText(discoverScreenTitle, "Keanu | Discover");
		verifyHeaders();
		return new AppHeaders(appLibrary);
	}

	public AppHeaders navigateToMyProfile() throws Exception {
		appLibrary.sleep(5000);
		appLibrary.findElementForMobile(myProfileScreen).click();
		appLibrary.verifyText(myProfileScreenTitle, "Keanu | Me");
		verifyHeaders();
		return new AppHeaders(appLibrary);
	}

	public AppHeaders searchOption(String searchText) throws Exception {
		appLibrary.findElementForMobile(searchHistory).click();
		appLibrary.enterMobileText(searchText, searchEditor);
		appLibrary.sleep(2000);
		appLibrary.verifyText(searchResultVerify.replace("replace", searchText), searchText);
		return new AppHeaders(appLibrary);
	}

	public AppHeaders cancelSearch() throws Exception {
		appLibrary.findElementForMobile(cancelSearchEditor).click();
		appLibrary.findElementForMobile(navigateBack).click();
		return new AppHeaders(appLibrary);
	}

	public AppHeaders hamburgerMenuOption() throws Exception {
		appLibrary.findElementForMobile(hamburgerButton).click();
		appLibrary.findElementForMobile(activeMenuOption);
		appLibrary.findElementForMobile(archiveMenuOption);
		return new AppHeaders(appLibrary);
	}

	public AppHeaders navigateToActiveChats() throws Exception {
		appLibrary.findElementForMobile(hamburgerButton).click();
		appLibrary.findElementForMobile(activeMenuOption).click();
		return new AppHeaders(appLibrary);
	}

	public AppHeaders navigateToArchiveChats() throws Exception {
		appLibrary.findElementForMobile(hamburgerButton).click();
		appLibrary.findElementForMobile(archiveMenuOption).click();
		return new AppHeaders(appLibrary);
	}

	public AppHeaders myAccount() throws Exception {
		appLibrary.findElementForMobile(threeDotsButton).click();
		appLibrary.findElementForMobile(myAccountsMenuOption);
		return new AppHeaders(appLibrary);
	}

	public AppHeaders settings() throws Exception {
		appLibrary.findElementForMobile(threeDotsButton).click();
		appLibrary.findElementForMobile(settingsMenuOption).click();
		return new AppHeaders(appLibrary);
	}

	public AppHeaders lockApp() throws Exception {
		appLibrary.findElementForMobile(threeDotsButton).click();
		appLibrary.findElementForMobile(lockAppMenuOption).click();
		return new AppHeaders(appLibrary);
	}

	public AppHeaders signOut() throws Exception {
		appLibrary.findElementForMobile(threeDotsButton).click();
		appLibrary.findElementForMobile(signOutMenuOption).click();
		return new AppHeaders(appLibrary);
	}

	public AppHeaders threeDotsMenuOption() throws Exception {
		appLibrary.findElementForMobile(hamburgerButton).click();
		appLibrary.findElementForMobile(myAccountsMenuOption);
		appLibrary.findElementForMobile(settingsMenuOption);
		appLibrary.findElementForMobile(lockAppMenuOption);
		appLibrary.findElementForMobile(signOutMenuOption);
		return new AppHeaders(appLibrary);
	}

	public AppHeaders myAccountVerification(String un, String serverUsed) throws Exception {
		appLibrary.findElementForMobile(threeDotsButton).click();
		appLibrary.findElementForMobile(myAccountsMenuOption).click();
		appLibrary.verifiyContains(userName, un);
		appLibrary.verifyText(server, "Online - " + serverUsed);
		appLibrary.sleep(2000);
		return new AppHeaders(appLibrary);

	}

	public void navigateChatToFriend() throws Exception {
		appLibrary.horizontalRightSwipe(fullScreen);
	}

	public void navigateFriendToDiscover() throws Exception {
		appLibrary.horizontalRightSwipe(fullScreen);
	}

	public void navigateDiscoverToMyProfile() throws Exception {
		appLibrary.horizontalRightSwipe(fullScreen);
	}

	public void navigateMyProfileToDiscover() throws Exception {
		appLibrary.horizontalLeftSwipe(fullScreen);
	}

	public void navigateDiscoverToFriend() throws Exception {
		appLibrary.horizontalLeftSwipe(fullScreen);
	}

	public void navigateFriendToChat() throws Exception {
		appLibrary.horizontalLeftSwipe(fullScreen);
	}

	public void verifyChatsScreen() throws Exception {
		appLibrary.verifyText(chatsScreenTitle, "Keanu | Chats");
		verifyHeaders();
	}

	public void verifyFriendScreen() throws Exception {
		appLibrary.verifyText(friendsScreenTitle, "Keanu | Friends");
		verifyHeaders();
	}

	public void verifyDiscoverScreen() throws Exception {
		appLibrary.verifyText(discoverScreenTitle, "Keanu | Discover");
		verifyHeaders();
	}

	public void verifyMyProfileScreen() throws Exception {
		appLibrary.verifyText(myProfileScreenTitle, "Keanu | Me");
		verifyHeaders();
	}

}
