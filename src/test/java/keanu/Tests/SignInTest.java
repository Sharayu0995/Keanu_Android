package keanu.Tests;

import java.util.logging.Logger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import keanu.Library.AppLibrary;
import keanu.Library.TestBase;
import keanu.PageObject.SignUpSignInScreen;
import keanu.PageObject.WelcomeScreen;

public class SignInTest extends TestBase {

	public Logger logger;

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary("Sign-In Test");
	}

	@Test
	public void userLogin() throws Exception {
		appLibrary.getDriverInstance();
		WelcomeScreen wc = new WelcomeScreen(appLibrary);
		wc.skipToSignIn();

		SignUpSignInScreen signIn = new SignUpSignInScreen(appLibrary);
		signIn.accountSelection(true);
		signIn.signIn(appLibrary.getConfiguration().getUser1(), appLibrary.getConfiguration().getUser1Pass(),
				appLibrary.getConfiguration().getKeanuServer());
	}
}
