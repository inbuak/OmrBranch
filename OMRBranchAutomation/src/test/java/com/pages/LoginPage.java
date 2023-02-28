package com.pages;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Inbanesan
 * @see used to maintain Login page elements and methods
 * date 18-01-2023 
 */
public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "//b[contains(text(),'Invalid Login details')]")
	private WebElement loginErrorMsg;
	@CacheLookup
	@FindBy(id = "username")
	private WebElement txtUserName;
	@CacheLookup
	@FindBy(id = "password")
	private WebElement txtPassWord;
	@CacheLookup
	@FindBy(id = "login")
	private WebElement btnLogin;

	public WebElement getLoginErrorMsg() {
		return loginErrorMsg;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassWord() {
		return txtPassWord;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
/**
 * @see used to perform common loginstep
 * @param userName
 * @param passWord
 */
	public void loginCommonStep(String userName, String passWord) {
		sendKeysToElement(getTxtUserName(), userName);
		sendKeysToElement(getTxtPassWord(), passWord);

	}
/**
 * @see used to perform login
 * @param userName
 * @param passWord
 */
	public void login(String userName, String passWord) {
		loginCommonStep(userName, passWord);
		clickElement(getBtnLogin());

	}
/**
 * @see used to perform login with enter key 
 * @param userName
 * @param passWord
 * @throws AWTException
 */
	public void loginWihEnterKey(String userName, String passWord) throws AWTException {
		loginCommonStep(userName, passWord);
		robotKey(KeyEvent.VK_TAB);
		robotKey(KeyEvent.VK_TAB);
		robotKey(KeyEvent.VK_ENTER);

	}

}
