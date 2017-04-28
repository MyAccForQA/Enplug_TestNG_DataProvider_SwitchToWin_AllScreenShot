package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom_pf.HomePage;
import pom_pf.LoginPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

@Title("TestS_Start")
@Description("Description")
public class TestS extends Test_BeforeAndAfter {

	// #1
	@Title("test_HomePage")
	@Test(groups = { "ff", "ok" })
	public void test_HomePage() {

		// ????????????????????????
		String exp = "Digital Signage Software for Marketing and Communications";
		// ????????????????????????
		try {
			String act = driver.getTitle();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePage - " + exp);
		}
	}

	// #2
	@Title("test_HomePageToGoLogin")
	@Test(groups = { "ff", "ok" })
	public void test_HomePageToGoLogin() {

		boolean exp = true;
		try {
			String startWindow = driver.getWindowHandle();

			new HomePage(driver, wait).findAndClickLink_Login();

			driver.switchTo().window(startWindow).close();
			driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

			LoginPage loginPF = new LoginPage(driver, wait);

			boolean act = loginPF.findButton_Login_isDisplayed();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoLogin " + exp);
		}
	}

	@DataProvider(name = "WrongEmail")
	public static String[][] wrongEmail() {
		String[][] str = { { "qwe", "qweasdzxc", "false" }, { "qwe@", "qweasdzxc", "false" },
				{ "qwe@asd", "qweasdzxc", "false" }, { "qwe@asd.", "qweasdzxc", "false" },
				{ "qwe@asd.c", "qweasdzxc", "false" }, { "qwe@.com", "qweasdzxc", "false" },
				{ "qwe@.", "qweasdzxc", "false" } };
		return str;
	}

	// #3
	@Title("test_HomePageToGoLogin_WrongEmail_ErrorValid")
	@Test(groups = { "ff", "ok" }, dataProvider = "WrongEmail")
	public void test_HomePageToGoLogin_WrongEmail_ErrorValid(String email, String pass, String must) {

		boolean exp = Boolean.valueOf(must);
		try {
			String startWindow = driver.getWindowHandle();

			new HomePage(driver, wait).findAndClickLink_Login();

			driver.switchTo().window(startWindow).close();
			driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

			LoginPage loginPF = new LoginPage(driver, wait);

			loginPF.findAndFillInField_Username(email);
			loginPF.findAndFillInField_Password(pass);

			boolean act = loginPF.findButton_Login_isEnabled();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoLogin_WrongEmail_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}

	@DataProvider(name = "IncorrectEmail")
	public static String[][] incorrectEmail() {
		String[][] str = { { "qwerty@asdf.com", "qweasdzxc", "Your email or password was incorrect." },
				{ "asdfgh@asdf.com", "qweasdzxc", "Your email or password was incorrect." },
				{ "zxcvbn@asdf.com", "qweasdzxc", "Your email or password was incorrect." } };
		return str;
	}

	// #4
	@Title("test_HomePageToGoLogin_IncorrectEmail_ErrorValid")
	@Test(groups = { "ff", "ok" }, dataProvider = "IncorrectEmail")
	public void test_HomePageToGoLogin_IncorrectEmail_ErrorValid(String email, String pass, String must) {

		String exp = must;
		try {
			String startWindow = driver.getWindowHandle();

			new HomePage(driver, wait).findAndClickLink_Login();

			driver.switchTo().window(startWindow).close();
			driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

			LoginPage loginPF = new LoginPage(driver, wait);

			loginPF.findAndFillInField_Username(email);
			loginPF.findAndFillInField_Password(pass);

			String act = null;
			if (loginPF.findButton_Login_isEnabled()) {
				loginPF.findAndClickButton_Login();
				act = loginPF.find_IncorrectEmail_Message();
			}

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoLogin_IncorrectEmail_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}
}