package ua.gudkov.acceptic.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class Waiter {
	public static final int DEFAULT_TIME_OUT = 10;

	public static WebElement waitFor(WebDriver driver, ExpectedCondition<WebElement> condition) {
		return new WebDriverWait(driver, DEFAULT_TIME_OUT).until(condition);

	}


}
