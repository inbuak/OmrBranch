package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Inbanesan
 * @see used to maintain BookConfirmation page elements and methods
 * date 18-01-2023 
 */

public class BookConfirmationPage extends BaseClass {
	public BookConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement txtBookHotelSuccessMsg;
	@CacheLookup
	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement lnkBookedItinerary;

	public WebElement getLnkBookedItinerary() {
		return lnkBookedItinerary;
	}

	@CacheLookup
	@FindBy(id = "order_no")
	private WebElement txtOrderNo;
	public WebElement getTxtBookConfirmMsg() {
		return txtBookHotelSuccessMsg;
	}

	public WebElement getTxtOrderNo() {
		return txtOrderNo;
	}
/**
 * @see used to get generated ordrid
 * @return String
 */
	public String getBookingId(){
		String orderId = getAttributeValue(getTxtOrderNo());
		return orderId;

	}

}
