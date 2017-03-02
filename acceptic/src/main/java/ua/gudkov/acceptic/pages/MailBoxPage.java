package ua.gudkov.acceptic.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ua.gudkov.acceptic.constants.Const;
import ua.gudkov.acceptic.util.Extractor;
import ua.gudkov.acceptic.util.Waiter;

public class MailBoxPage {
	private final WebDriver driver;
	private By inboxTab = By.xpath("//a[@href='https://mail.google.com/mail/#inbox']");

	public MailBoxPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public String getTitle (){
		Waiter.waitFor(driver, ExpectedConditions.presenceOfElementLocated(inboxTab));
		return driver.getTitle();
	}

	public int getUnreadMsgNum() {
		String title = Waiter.waitFor(driver, ExpectedConditions.presenceOfElementLocated(inboxTab))
				.getAttribute("title");
		String msgNum = Extractor.extractByRegex(title, Const.Regex.VALUE_IN_BRACKETS);
		return Extractor.stringToInt(msgNum);

	}

}
