package keanu.Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	private String appDir;
	private String appName;
	private String deviceId1;
	private String deviceId2;
	private String appActivity;
	private String appPackage;
	private Boolean isBrowserStackExecution;
	private String browserStackUserName;
	private String browserStackAuthKey;
	private String osVersion1;
	private String osVersion2;
	private String deviceName1;
	private String deviceName2;
	private String osName;
	private String appUrl;
	private String keanuServer;
	private String user1;
	private String user1Pass;
	private String user2;
	private String user2Pass;
	private String user3;

	public Configuration() {
		final Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("config.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		isBrowserStackExecution = (System.getProperty("isBrowserstack.execution") != null
				&& !(System.getProperty("isBrowserstack.execution").equals("${isBrowserstack.execution}")))
						? (System.getProperty("isBrowserstack.execution").equals("true"))
						: Boolean.parseBoolean(prop.getProperty("isBrowserstack.execution", "false").trim());

		browserStackUserName = System.getProperty("browserstack.username") != null
				? System.getProperty("browserstack.username")
				: prop.getProperty("browserstack.username");

		browserStackAuthKey = System.getProperty("browserstack.authkey") != null
				? System.getProperty("browserstack.authkey")
				: prop.getProperty("browserstack.authkey");

		osVersion1 = System.getProperty("os.version1") != null ? System.getProperty("os.version1")
				: prop.getProperty("os.version1");

		osVersion2 = System.getProperty("os.version2") != null ? System.getProperty("os.version2")
				: prop.getProperty("os.version2");

		deviceName1 = System.getProperty("device.name1") != null ? System.getProperty("device.name1")
				: prop.getProperty("device.name1");

		deviceName2 = System.getProperty("device.name2") != null ? System.getProperty("device.name2")
				: prop.getProperty("device.name2");

		osName = System.getProperty("OS.name") != null ? System.getProperty("OS.name") : prop.getProperty("OS.name");

		appDir = System.getProperty("app.dir") != null ? System.getProperty("app.dir") : prop.getProperty("app.dir");

		appName = System.getProperty("app.name") != null ? System.getProperty("app.name")
				: prop.getProperty("app.name");

		deviceId1 = System.getProperty("device.id1") != null ? System.getProperty("device.id1")
				: prop.getProperty("device.id1");

		deviceId2 = System.getProperty("device.id2") != null ? System.getProperty("device.id2")
				: prop.getProperty("device.id2");

		appPackage = System.getProperty("app.package") != null ? System.getProperty("app.package")
				: prop.getProperty("app.package");

		appActivity = System.getProperty("app.activity") != null ? System.getProperty("app.activity")
				: prop.getProperty("app.activity");

		appUrl = System.getProperty("appUrl") != null ? System.getProperty("appUrl") : prop.getProperty("appUrl");

		keanuServer = System.getProperty("keanu.server") != null ? System.getProperty("keanu.server")
				: prop.getProperty("keanu.server");

		user1 = System.getProperty("user1") != null ? System.getProperty("user1") : prop.getProperty("user1");

		user2 = System.getProperty("user2") != null ? System.getProperty("user2") : prop.getProperty("user2");

		user1Pass = System.getProperty("user1.pass") != null ? System.getProperty("user1.pass")
				: prop.getProperty("user1.pass");

		user2Pass = System.getProperty("user2.pass") != null ? System.getProperty("user2.pass")
				: prop.getProperty("user2.pass");

		user3 = System.getProperty("user3") != null ? System.getProperty("user3") : prop.getProperty("user3");

		AppLibrary.log("Printing Configs", true);
		AppLibrary.log("appdir:" + appDir, true);
		AppLibrary.log("appname:" + appName, true);
		AppLibrary.log("OSName:" + osName, true);
		AppLibrary.log("deviceId1:" + deviceId1, true);
		AppLibrary.log("deviceId2:" + deviceId2, true);
		AppLibrary.log("appActivity:" + appActivity, true);
		AppLibrary.log("appPackage:" + appPackage, true);
		AppLibrary.log("isBrowserStackExecution:" + isBrowserStackExecution, true);
		AppLibrary.log("osVersion1:" + osVersion1, true);
		AppLibrary.log("osVersion2:" + osVersion2, true);
		AppLibrary.log("deviceName1:" + deviceName1, true);
		AppLibrary.log("deviceName2:" + deviceName2, true);
		AppLibrary.log("keanuServer:" + keanuServer, true);
		AppLibrary.log("user1:" + user1, true);
		AppLibrary.log("user1Pass:" + user1Pass, true);
		AppLibrary.log("user2:" + user2, true);
		AppLibrary.log("user2Pass:" + user2Pass, true);
		AppLibrary.log("user3:" + user3, true);
		AppLibrary.log("appUrl:" + appUrl, true);

	}

	public String getUser3() {
		return user3;
	}

	public String getUser1() {
		return user1;
	}

	public String getUser2() {
		return user2;
	}

	public String getUser1Pass() {
		return user1Pass;
	}

	public String getUser2Pass() {
		return user2Pass;
	}

	public String getKeanuServer() {
		return keanuServer;
	}

	public boolean isBrowserStackExecution() {
		return isBrowserStackExecution;
	}

	public String getBrowserStackUserName() {
		return browserStackUserName;
	}

	public String getBrowserStackAuthKey() {
		return browserStackAuthKey;
	}

	public String getOSVersion1() {
		return osVersion1;
	}

	public String getOSVersion2() {
		return osVersion2;
	}

	public String getDeviceName1() {
		return deviceName1;
	}

	public String getDeviceName2() {
		return deviceName2;
	}

	public String getBrowserStackAppURL() {
		return appUrl;
	}

	public String getappDir() {
		return appDir;
	}

	public String getappName() {
		return appName;
	}

	public String getOsName() {
		return osName;
	}

	public String getDeviceId1() {
		return deviceId1;
	}

	public String getDeviceId2() {
		return deviceId2;
	}

	public String getAppPackage() {
		return appPackage;
	}

	public String getAppActivity() {
		return appActivity;
	}
}