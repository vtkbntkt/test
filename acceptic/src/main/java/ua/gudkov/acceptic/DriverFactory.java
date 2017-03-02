package ua.gudkov.acceptic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class DriverFactory {
	public static final int FIREFOX_DRIVER = 1;

	public static WebDriver getDriver(int whichFactory) {
		switch (whichFactory) {
		case FIREFOX_DRIVER:
			System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
			return new FirefoxDriver();
		default:
			return null;
		}
	}

}
