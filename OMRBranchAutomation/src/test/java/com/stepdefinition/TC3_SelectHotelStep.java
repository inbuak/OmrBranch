package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Inbanesan
 * @see used to maintain SelectHotel page stepdefinitions
 * @date 18-1-2023
 */
public class TC3_SelectHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to perform hotel select
	 */
	@Then("User should perform Select hotel by hotel name")
	public void userShouldPerformSelectHotelByHotelName() {
		pom.getSelectHotelPage().selectHotel();
	}

	/**
	 * @see used to verify after hotel select success message
	 * @param expSelectSuccessMsg
	 */
	@Then("User should verify after select hotel success message {string}")
	public void userShouldVerifyAfterSelectHotelSuccessMessage(String expSelectSuccessMsg) {
		WebElement txtBookHotel = pom.getBookHotelPage().getTxtSelectHotelSuccessMsg();
		String actSelectSucessMsg = getTextFromElement(txtBookHotel);
		Assert.assertEquals("Verify after select hotel success message", expSelectSuccessMsg, actSelectSucessMsg);
	}

	/**
	 * @see used to click continue button
	 */
	@Then("User should click on continue")
	public void userShouldClickOnContinue() {
		pom.getSelectHotelPage().clickContinue();
	}

	/**
	 * @see used to verify select hotel error message
	 * @param expSelectErrorMsg
	 */
	@Then("User should verify after click on continue error message {string}")
	public void userShouldVerifyAfterClickOnContinueErrorMessage(String expSelectErrorMsg) {
		WebElement selectErrorMsg = pom.getSelectHotelPage().getTxtSelectErrorMsg();
		String actSelectErrorMsg = getTextFromElement(selectErrorMsg);
		Assert.assertEquals("Verify after click on continue error message", expSelectErrorMsg, actSelectErrorMsg);
	}

}
