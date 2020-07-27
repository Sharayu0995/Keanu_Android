package keanu.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import keanu.Library.AppLibrary;

public class DiscoverScreen {

	private AppLibrary appLibrary;

	public static String navToServices = "xpath://android.widget.TextView[contains(@text,'Services')]";
	public static String navToPhotoStream = "xpath://android.widget.TextView[contains(@text,'Photo Stream')]";
	public static String navToCreateGroup = "xpath://android.widget.TextView[contains(@text,'Create Group (Room)')]";
	public static String navToShareSticker = "xpath://android.widget.TextView[contains(@text,'Sticker Share')]";
	public static String navToChangeTheme = "xpath://android.widget.TextView[contains(@text,'Change Theme')]";
	public static String editGroupSubject = "id:info.guardianproject.keanuapp:id/edit_group_subject";
	public static String editGroupTextField = "class:android.widget.EditText";
	public static String clickOKButton = "xpath://android.widget.Button[@text='OK']";
	public static String searchHistory = "id:info.guardianproject.keanuapp:id/menu_search";
	public static String verifyeditGroupName="id:tvGroupName";

	public static String waleSticket = "xpath://android.widget.ImageView[@content-desc='success-whale.png']";

	public DiscoverScreen(AppLibrary appLibrary) {
		this.appLibrary = appLibrary;
	}

	public void selectSticker() throws Exception {
		appLibrary.findElementForMobile(waleSticket).click();
	}

	public void discScreenUI() throws Exception {
		appLibrary.verifyText(navToServices, "Services");
		appLibrary.verifyText(navToPhotoStream, "Photo Stream");
		appLibrary.verifyText(navToCreateGroup, "Create Group (Room)");
		appLibrary.verifyText(navToShareSticker, "Sticker Share");
		appLibrary.verifyText(navToChangeTheme, "Change Theme");
	}

	public void navigateToServices() throws Exception {
		appLibrary.findElementForMobile(navToServices).click();
		appLibrary.sleep(2000);
		appLibrary.verifyText(navToServices, "Services");
	}

	public void navigateToPhotoStream() throws Exception {
		appLibrary.findElementForMobile(navToPhotoStream).click();
		appLibrary.sleep(2000);
		appLibrary.verifyText(navToPhotoStream, "Photo Stream");
	}

	public void createAGroup(String roomName) throws Exception {
		appLibrary.findElementForMobile(navToCreateGroup).click();
		updateChatRoom(roomName);
	}

	public void navigateToShareSticker() throws Exception {
		appLibrary.findElementForMobile(navToShareSticker).click();
		appLibrary.sleep(2000);
		appLibrary.verifyText(navToShareSticker, "Sticker Share");
	}

	public void navigateToChangeTheme() throws Exception {
		appLibrary.findElementForMobile(navToChangeTheme);
	}

	public void updateChatRoom(String roomName) throws Exception {
		appLibrary.findElementForMobile(editGroupSubject).click();
		appLibrary.enterMobileText(roomName, editGroupTextField);
		appLibrary.findElementForMobile(clickOKButton).click();
		appLibrary.sleep(9000);
		appLibrary.verifyMobileElement(verifyeditGroupName.replace("replace", roomName));
		navToBack();
	}

	public void navToBack() throws Exception {
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
