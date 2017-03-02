package ua.gudkov.acceptic;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import ua.gudkov.acceptic.pages.LoginPage;
import ua.gudkov.acceptic.pages.MailBoxPage;

public class LoginTest {
	private static WebDriver driver;
	private String userName = "test68895";
	private String password = "gdfeR45E33";

	@BeforeClass
	public static void setup() {
		driver = DriverFactory.getDriver(DriverFactory.FIREFOX_DRIVER);
		driver.get("https://www.gmail.com");
	}

	@Test
	public void openMailBoxTest() {
		new LoginPage(driver).logIn(userName, password);
		Assert.assertTrue(new MailBoxPage(driver).getTitle().toLowerCase().contains(userName));
	}

	@Test
	public void getUnreadMsgTest() {
		System.out.println(new MailBoxPage(driver).getUnreadMsgNum());
	}

	@AfterClass
	public static void clearData() {
		driver.close();
	}

}
