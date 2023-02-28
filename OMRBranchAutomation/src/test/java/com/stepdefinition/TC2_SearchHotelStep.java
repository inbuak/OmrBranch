package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Inbanesan
 * @see used to maintain SearchHotel page stepdefinitions
 * @date 18-1-2023
 *
 */
public class TC2_SearchHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to perform hotel search
	 * @param location
	 * @param hotelName
	 * @param roomType
	 * @param noOfRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 * @param childsPerRoom
	 */
	@Then("User should Perform Search Hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldPerformSearchHotelAnd(String location, String hotelName, String roomType, String noOfRooms,
			String checkInDate, String checkOutDate, String adultsPerRoom, String childsPerRoom) {
		pom.getSearchHotelPage().searchHolel(location, hotelName, roomType, noOfRooms, checkInDate, checkOutDate,
				adultsPerRoom, childsPerRoom);
	}

	/**
	 * @see used to verfiy Search hotel success message
	 * @param expSearchSuccessmsg
	 */
	@Then("User should verify after Search success message {string}")
	public void userShouldVerifyAfterSearchSuccessMessage(String expSearchSuccessmsg) {
		WebElement txtSelectHotel = pom.getSelectHotelPage().getSearchHotelSuccessMsg();
		String actSearchSuccessMsg = getTextFromElement(txtSelectHotel);
		Assert.assertEquals("Verify after Search success message", expSearchSuccessmsg, actSearchSuccessMsg);

	}

	/**
	 * @see used to perform hotel search with mandatory fields
	 * @param location
	 * @param noOfRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 */
	@Then("User should entry only mandatory fields {string},{string},{string},{string} and {string}")
	public void userShouldEntryOnlyMandatoryFieldsAnd(String location, String noOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom) {
		pom.getSearchHotelPage().searchHotel(location, noOfRooms, checkInDate, checkOutDate, adultsPerRoom);
	}

	/**
	 * @see used to verify after search error messages
	 * @param expCheckInErrorMsg
	 * @param expCheckOutErrorMsg
	 */
	@Then("User should verify after Search error messages {string} and {string}")
	public void userShouldVerifyAfterSearchErrorMessagesAnd(String expCheckInErrorMsg, String expCheckOutErrorMsg) {
		String[] expErrorMsgs = { expCheckInErrorMsg, expCheckOutErrorMsg };

		WebElement checkInDateErrorMsg = pom.getSearchHotelPage().getTxtCheckInDateErrorMsg();
		String actCheckInErrorMsg = getTextFromElement(checkInDateErrorMsg);

		WebElement checkOutDateErrorMsg = pom.getSearchHotelPage().getTxtCheckOutDateErrorMsg();
		String actChectOutErrorMsg = getTextFromElement(checkOutDateErrorMsg);

		String[] actErrorMsgs = { actCheckInErrorMsg, actChectOutErrorMsg };
		Assert.assertArrayEquals("Verify afetr search  error messages", expErrorMsgs, actErrorMsgs);
	}
/**
 * @see used to perform hotel search without entering any fields
 */
	@Then("User should click on Search button")
	public void userShouldClickOnSearchButton() {
		pom.getSearchHotelPage().searchHotel();
	}
/**
 * @see used to verify search hotel error msg
 * @param expLocationErrorMsg
 */
	@Then("User should verify after Search error message {string}")
	public void userShouldVerifyAfterSearchErrorMessage(String expLocationErrorMsg) {
		WebElement locationErrorMsg = pom.getSearchHotelPage().getTxtLocationErrorMsg();
		String actLocationErrorMsg = getTextFromElement(locationErrorMsg);
		Assert.assertEquals("Verify after search location error message", expLocationErrorMsg, actLocationErrorMsg);
	}

}
