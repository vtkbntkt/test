package ua.gudkov.acceptic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ua.gudkov.acceptic.util.Waiter;

public class LoginPage {
	private final WebDriver driver;
	private By userName = By.id("Email");
	private By nextBtn = By.id("next");
	private By password = By.id("Passwd");
	private By signInBtn = By.id("signIn");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		if (!"Gmail".equals(driver.getTitle())) {
			throw new IllegalStateException("It is not the login page");
		}
	}

	public void typeUserName(String keysToSend) {
		Waiter.waitFor(driver, ExpectedConditions.presenceOfElementLocated(userName)).sendKeys(keysToSend);
	}

	public void submitName() {
		driver.findElement(nextBtn).submit();
	}

	public void typePassword(String keysToSend) {
		Waiter.waitFor(driver, ExpectedConditions.presenceOfElementLocated(password)).sendKeys(keysToSend);

	}

	public void submitLogin() {
		driver.findElement(signInBtn).submit();
	}

	public void logIn(String userName, String password) {
		typeUserName(userName);
		submitName();
		typePassword(password);
		submitLogin();
	}

}
