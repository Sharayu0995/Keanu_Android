package keanu.PageObject;

import java.util.List;

import io.appium.java_client.MobileElement;
import keanu.Library.AppLibrary;

public class MyProfileScreen {

	private AppLibrary appLibrary;

	
	public static String userName ="xpath:(//android.widget.TextView[@index='0'])[3]";
	public static String userNameDevServer = "xpath://android.widget.TextView[contains(@resource-id,'edtName')]";
	public static String userPassword = "id:info.guardianproject.keanuapp:id/edtPass";
	public static String editUserName = "xpath://android.widget.ImageView[contains(@resource-id,'edit_account_nickname')]";
	public static String editPassword = "xpath://android.widget.ImageView[contains(@resource-id,'edit_account_password')]";
	public static String pwdShowButton = "id:info.guardianproject.keanuapp:id/btnShowPass";
	public static String profilePicture = "id:info.guardianproject.keanuapp:id/imageAvatar";
	public static String camera = "xpath://android.widget.TextView[contains(@text,'Camera')]";
	public static String gallery = "xpath://android.widget.TextView[contains(@text,'Gallery')]";
	public static String files = "xpath://android.widget.TextView[contains(@text,'Files')]";
	public static String clickOnCamera = "xpath://android.widget.ImageView[@content-desc='Shutter']";
	public static String cameraClickDone = "xpath://android.widget.ImageButton[@content-desc='Done']";
	public static String cancelButton = "xpath://android.widget.Button[contains(@text,'CANCEL')]";
	public static String OKButton = "xpath://android.widget.Button[contains(@text,'OK')]";
	public static String clickOnFile = "xpath://android.widget.ImageView[contains(@instance,'4')]";
	public static String deviceAndKeysButton = "id:btnViewDevices";
	//public static String deviceList = "xpath://android.widget.TextView[contains(@text,'Keanu')]";
	public static String deviceList="xpath://android.widget.TextView[contains(@text,'device-')]";

	public MyProfileScreen(AppLibrary appLibrary) {
		this.appLibrary = appLibrary;
	}

	public void deviceKeyVerify(Boolean signUp, Boolean signIn)  throws Exception {
		appLibrary.findElementForMobile(deviceAndKeysButton).click();
		appLibrary.sleep(10000);
		List<MobileElement> list = appLibrary.findElementsForMobile(deviceList);
		appLibrary.sleep(10000);
		int deivceCount = list.size();
		if (signUp)
			assert deivceCount < 2;
		if (signIn)
			assert deivceCount > 1;
	}

	public MyProfileScreen userVerification(String un, String password)  throws Exception {
		appLibrary.verifyText(userName, un);
		appLibrary.findElementForMobile(pwdShowButton).click();
		appLibrary.verifyText(userPassword, password);
		appLibrary.findElementForMobile(pwdShowButton).click();
		return new MyProfileScreen(appLibrary);
	}

	public void addProfilePictureViaCamera() throws Exception  {
		appLibrary.findElementForMobile(profilePicture).click();
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(camera).click();
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(clickOnCamera).click();
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(cameraClickDone).click();
		appLibrary.findElementForMobile(cancelButton).click();

		appLibrary.findElementForMobile(profilePicture).click();
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(camera).click();
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(clickOnCamera).click();
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(cameraClickDone).click();
		appLibrary.findElementForMobile(OKButton).click();
	}

	public void addProfilePictureViaFile() throws Exception  {
		appLibrary.findElementForMobile(profilePicture).click();
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(files).click();
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(clickOnFile).click();
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(cancelButton).click();

		appLibrary.findElementForMobile(profilePicture).click();
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(files).click();
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(clickOnFile).click();
		appLibrary.sleep(3000);
		appLibrary.findElementForMobile(OKButton).click();
	}

}
