package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * @author Inbanesan
 * @see used maintain all common step definifions
 * @date 18-01-2023
 */
public class CommonStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to get adactin page
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Given("User is on the adactin hotel page")
	public void userIsOnTheAdactinHotelPage() {
		
		
	}

	

	/**
	 * @see used to verify login success message
	 * @param expLoginSuccessMsg
	 */
	@Then("User should verify after login success message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String expLoginSuccessMsg) {
		WebElement txtSuccessLogin = pom.getSearchHotelPage().getTxtSuccessLogin();
		String actLoginSuccessMsg = getAttributeValue(txtSuccessLogin);
		Assert.assertEquals("Verify after login success message", actLoginSuccessMsg, expLoginSuccessMsg);

	}

}
