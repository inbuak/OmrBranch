package com.stepdefinition;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Inbanesan
 * @see used to maintain login page stepdefinitions
 * @date 18-1-2023
 *
 */
public class TC1_LoginStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to perform login
	 * @param userName
	 * @param passWord
	 */

	@When("User should perform login {string} , {string}")
	public void userShouldPerformLogin(String userName, String passWord) {
		pom.getLoginPage().login(userName, passWord);
	

	}
	/**
	 * @see used to perform login using enter key
	 * @param userName
	 * @param passWord
	 * @throws AWTException
	 */
	@When("User should perform login using enter {string} , {string}")
	public void userShouldPerformLoginUsingEnter(String userName, String passWord) throws AWTException {
		pom.getLoginPage().loginWihEnterKey(userName, passWord);

	}

	@Then("User should verify after login error message {string}")
	public void userShouldVerifyAfterLoginErrorMessage(String expLoginErrorMsg) {
		WebElement loginErrorMsg = pom.getLoginPage().getLoginErrorMsg();
		String actLoginErrorMsg = getTextFromElement(loginErrorMsg);
		boolean b = actLoginErrorMsg.contains(expLoginErrorMsg);
		Assert.assertTrue("Verify after login error message", b);

	}

}
