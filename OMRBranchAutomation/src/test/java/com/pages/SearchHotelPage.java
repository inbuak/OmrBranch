package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Inbanesan
 * @see used to maintain SearchHotel page elements and methods
 * date 18-01-2023 
 */
public class SearchHotelPage extends BaseClass {
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(id="username_show")
	private WebElement txtSuccessLogin;
	@CacheLookup
	@FindBy(id = "location")
	private WebElement ddnLoction;
	@CacheLookup
	@FindBy(id = "hotels")
	private WebElement ddnHotel;
	@CacheLookup
	@FindBy(id = "room_type")
	private WebElement ddnRoomType;
	@CacheLookup
	@FindBy(id = "room_nos")
	private WebElement ddnNoOfRoom;
	@CacheLookup
	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;
	@CacheLookup
	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;
	@CacheLookup
	@FindBy(id = "adult_room")
	private WebElement ddnNoOfAdultRoom;
	@CacheLookup
	@FindBy(id = "child_room")
	private WebElement ddnNoOfChildRoom;
	@CacheLookup
	@FindBy(id = "Submit")
	private WebElement btnSearch;
	
	@FindBy(id="checkin_span")
	private  WebElement txtcheckInDateErrorMsg;
	@FindBy(id="checkout_span")
	private WebElement txtcheckOutDateErrorMsg;
@FindBy(id="location_span")
private WebElement txtlocationErrorMsg;
	public WebElement getTxtCheckInDateErrorMsg() {
		return txtcheckInDateErrorMsg;
	}
	public WebElement getTxtLocationErrorMsg() {
		return txtlocationErrorMsg;
	}
	public WebElement getTxtCheckOutDateErrorMsg() {
		return txtcheckOutDateErrorMsg;
	}

	public WebElement getTxtSuccessLogin() {
		return txtSuccessLogin;
	}

	public WebElement getDdnLoction() {
		return ddnLoction;
	}

	public WebElement getDdnHotel() {
		return ddnHotel;
	}

	public WebElement getDdnRoomType() {
		return ddnRoomType;
	}

	public WebElement getDdnNoOfRoom() {
		return ddnNoOfRoom;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getDdnNoOfAdultRoom() {
		return ddnNoOfAdultRoom;
	}

	public WebElement getDdnNoOfChildRoom() {
		return ddnNoOfChildRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}
/**
 * @see used to perform commom search hotel common step
 * @param location
 * @param noOfRooms
 * @param chechInDate
 * @param chechOutDate
 * @param noOfAdults
 */
	public void searchHotelCommonStep(String location, String noOfRooms, String chechInDate, String chechOutDate,
			String noOfAdults) {
		selectOptionByText(getDdnLoction(), location);
		selectOptionByText(getDdnNoOfRoom(), noOfRooms);
		clearElement(getTxtCheckInDate());
		sendKeysToElement(getTxtCheckInDate(), chechInDate);
		clearElement(getTxtCheckOutDate());
		sendKeysToElement(getTxtCheckOutDate(), chechOutDate);
		selectOptionByText(getDdnNoOfAdultRoom(), noOfAdults);

	}
/**
 * @see used to perform search hotel with mandatory fields
 * @param location
 * @param noOfRooms
 * @param chechInDate
 * @param chechOutDate
 * @param noOfAdults
 */
	public void searchHotel(String location, String noOfRooms, String chechInDate, String chechOutDate,
			String noOfAdults) {
		searchHotelCommonStep(location, noOfRooms, chechInDate, chechOutDate, noOfAdults);
		searchHotel();

	}
/**
 * @see used to perfom search hotel with all fields
 * @param location
 * @param hotel
 * @param roomType
 * @param noOfRooms
 * @param chechInDate
 * @param chechOutDate
 * @param noOfAdults
 * @param noOfChilds
 */
	public void searchHolel(String location, String hotel, String roomType, String noOfRooms, String chechInDate,
			String chechOutDate, String noOfAdults,String noOfChilds) {
		searchHotelCommonStep(location, noOfRooms, chechInDate, chechOutDate, noOfAdults);
		selectOptionByText(getDdnHotel(), hotel);
		selectOptionByText(getDdnRoomType(), roomType);
		selectOptionByText(getDdnNoOfChildRoom(), noOfChilds); 
		searchHotel();

	}
/**
 * @see used to searh hotel without any fields
 */
	public void searchHotel() {
		clickElement(getBtnSearch());

	}

}
