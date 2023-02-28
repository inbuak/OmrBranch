package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author elcot
 * @see used to maintain CancelBooking stepdefinitions
 * @date 18-1-2023
 */
public class TC5_CancelBookingStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to cancel generated orderId
	 */
	@Then("User should Cancel the generated orderId")
	public void userShouldCancelTheGeneratedOrderId() {
		String currentBookingId = pom.getBookConfirmationPage().getBookingId();
		pom.getBookConfirmationPage().getLnkBookedItinerary().click();
		pom.getCancelBookingPage().cancelBookingId(currentBookingId);

	}

	/**
	 * @see used to verify cancel success message
	 * @param expCancelErrorMsg
	 */
	@Then("User should verify after Cancel success message {string}")
	public void userShouldVerifyAfterCancelSuccessMessage(String expCancelErrorMsg) {
		WebElement cancelSuccessMsg = pom.getCancelBookingPage().getTxtCancelSuccessMsg();
		String actCancelSuccessMsg = getTextFromElement(cancelSuccessMsg);
		Assert.assertEquals("verify after cancel success message", expCancelErrorMsg, actCancelSuccessMsg);
	}

	/**
	 * @see used to cancel existing orderId
	 * @param existingOrderId
	 */
	@Then("User should perform Cancel the existing orederId {string}")
	public void userShouldPerformCancelTheExistingOrederId(String existingOrderId) {
		pom.getBookConfirmationPage().getLnkBookedItinerary().click();
		pom.getCancelBookingPage().cancelBookingId(existingOrderId);
	}

}
