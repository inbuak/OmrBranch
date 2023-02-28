package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Inbanesan
 * @see used to maintain cancelBooking page elements and methods
 * date 18-01-2023 
 */
public class CancelBookingPage extends BaseClass {
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "order_id_text")
	private WebElement txtSearch;
	@CacheLookup
	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;
	@CacheLookup
	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement btnCancel;
	@FindBy(id="search_result_error")
	private WebElement txtcancelSuccessMsg;

	public WebElement getTxtCancelSuccessMsg() {
		return txtcancelSuccessMsg;
	}


	public WebElement getBtnCancel() {
		return btnCancel;
	}


	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getTxtSearch() {
		return txtSearch;
	}
/**
 * @see used to cancel the orderid
 * @param orderNo
 */
	public void cancelBookingId(String orderNo) {
		
		sendKeysToElement(getTxtSearch(), orderNo);
		clickElement(getBtnGo());
		clickElement(getBtnCancel());
		alertAccept();
	}

}
