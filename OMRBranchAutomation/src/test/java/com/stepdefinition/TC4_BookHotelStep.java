package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author elcot
 * @see used to maintain BookHotel page stepdefinitions
 * @date 18-1-2023
 */
public class TC4_BookHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to perform hotel booking
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param dataTable
	 */
	@Then("User should perform Hotel Booking {string},{string} and {string}")
	public void userShouldPerformHotelBookingAnd(String firstName, String lastName, String address,
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> list = dataTable.asMaps();
		Map<String, String> map = list.get(0);
		String ccNum = map.get("ccNo");
		String ccType = map.get("ccType");
		String ccExpMonth = map.get("expMonth");
		String ccExpYear = map.get("expYear");
		String cvvNum = map.get("cvvNum");
		pom.getBookHotelPage().bookHotel(firstName, lastName, address, ccNum, ccType, ccExpMonth, ccExpYear, cvvNum);
	}

	/**
	 * @see used to verify booking success message
	 * @param expBookHotelSuccessMsg
	 */
	@Then("User should verify after hotel booking success meassage {string} and save the orderId")
	public void userShouldVerifyAfterHotelBookingSuccessMeassageAndSaveTheOrderId(String expBookHotelSuccessMsg) {
		WebElement txtBookConfirmMsg = pom.getBookConfirmationPage().getTxtBookConfirmMsg();
		String actBookHotelSuccessMsg = getTextFromElement(txtBookConfirmMsg);
		Assert.assertEquals("Verify after hotel booking success messsage", expBookHotelSuccessMsg,
				actBookHotelSuccessMsg);
		String bookingId = pom.getBookConfirmationPage().getBookingId();
		System.out.println(bookingId);

	}

	/**
	 * @see used to click book now button
	 */
	@Then("User should click on Book now button")
	public void userShouldClickOnBookNowButton() {
		pom.getBookHotelPage().clickBookNow();
	}

	/**
	 * used to verify booking error messages
	 * 
	 * @param expFirstNameErrorMsg
	 * @param expLastNameErrorMsg
	 * @param expAddressErrorMsg
	 * @param expCcNumErrorMsg
	 * @param expCcTypeErrorMsg
	 * @param expCcExpiryErrorMsg
	 * @param expCvvNumErrorMsg
	 */
	@Then("User should verify after click on Book now error messages {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyAfterClickOnBookNowErrorMessagesAnd(String expFirstNameErrorMsg,
			String expLastNameErrorMsg, String expAddressErrorMsg, String expCcNumErrorMsg, String expCcTypeErrorMsg,
			String expCcExpiryErrorMsg, String expCvvNumErrorMsg) {

		String[] expBookHotelErrorMsgs = { expFirstNameErrorMsg, expLastNameErrorMsg, expAddressErrorMsg, expCcNumErrorMsg,
				expCcTypeErrorMsg, expCcExpiryErrorMsg, expCvvNumErrorMsg };

		WebElement firstNameErrorMsg = pom.getBookHotelPage().getTxtFirstNameErrorMsg();
		String actFirstNameErrorMsg = getTextFromElement(firstNameErrorMsg);

		WebElement lastNameErrorMsg = pom.getBookHotelPage().getTxtLastNameerrorMsg();
		String actLastNameErrorMsg = getTextFromElement(lastNameErrorMsg);

		WebElement addressErrorMsg = pom.getBookHotelPage().getTxtAddressErrorMsg();
		String actAddressErrorMsg = getTextFromElement(addressErrorMsg);

		WebElement ccNumErrorMsg = pom.getBookHotelPage().getTxtCcNumErrorMsg();
		String actCcNumErrorMsg = getTextFromElement(ccNumErrorMsg);

		WebElement ccTypeErrorMsg = pom.getBookHotelPage().getTxtCcTypeErrorMsg();
		String actCcTypeErrorMsg = getTextFromElement(ccTypeErrorMsg);

		WebElement ccExpiryErrorMsg = pom.getBookHotelPage().getTxtCcExpiryErrorMsg();
		String actCcEXipryErrorMsg = getTextFromElement(ccExpiryErrorMsg);

		WebElement ccCvvNumErrorMsg = pom.getBookHotelPage().getTxtCcCvvNumErrorMsg();
		String actCvvNumErrorMsg = getTextFromElement(ccCvvNumErrorMsg);

		String[] actBookHotelErrorMsgs = { actFirstNameErrorMsg, actLastNameErrorMsg, actAddressErrorMsg, actCcNumErrorMsg,
				actCcTypeErrorMsg, actCcEXipryErrorMsg, actCvvNumErrorMsg };
		Assert.assertArrayEquals("Verify after click on book now error messages", expBookHotelErrorMsgs, actBookHotelErrorMsgs);

	}

}
