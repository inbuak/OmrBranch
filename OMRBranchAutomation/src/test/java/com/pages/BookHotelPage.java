package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Inbanesan
 * @see used to maintain BookHotel page elements and methods
 * date 18-01-2023 
 */
public class BookHotelPage extends BaseClass {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
		}
	@CacheLookup
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement txtSelectHotelSuccessMsg;
	@CacheLookup
	@FindBy(id="first_name")
	private WebElement txtFirstName;
	@CacheLookup
	@FindBy(id="last_name")
	private WebElement txtLastName;
	@CacheLookup
	@FindBy(id="address")
	private WebElement txtAddress;
	@CacheLookup
	@FindBy(id="cc_num")
	private WebElement txtCcNum;
	@CacheLookup
	@FindBy(id="cc_type")
	private WebElement ddnCcType;
	@CacheLookup
	@FindBy(id="cc_exp_month")
	private WebElement ddnCcExpMonth;
	@CacheLookup
	@FindBy(id="cc_exp_year")
	private WebElement ddnCcExpYear;
	@CacheLookup
	@FindBy(id="cc_cvv")
	private WebElement txtCcCvv;
	@CacheLookup
	@FindBy(id="book_now")
	private WebElement btnbookNow;
	@FindBy(id="first_name_span")
	private WebElement txtfirstNameErrorMsg;
	@FindBy(id="last_name_span")
	private WebElement txtlastNameerrorMsg;
	@FindBy(id="address_span")
	private WebElement txtaddressErrorMsg;
	@FindBy(id="cc_num_span")
	private WebElement txtccNumErrorMsg;
	@FindBy(id="cc_type_span")
	private WebElement txtccTypeErrorMsg;
	@FindBy(id="cc_expiry_span")
	private WebElement txtccExpiryErrorMsg;
	@FindBy(id="cc_cvv_span")
	private WebElement txtccCvvNumErrorMsg;
	
	public WebElement getTxtFirstNameErrorMsg() {
		return txtfirstNameErrorMsg;
	}
	public WebElement getTxtLastNameerrorMsg() {
		return txtlastNameerrorMsg;
	}
	public WebElement getTxtAddressErrorMsg() {
		return txtaddressErrorMsg;
	}
	public WebElement getTxtCcNumErrorMsg() {
		return txtccNumErrorMsg;
	}
	public WebElement getTxtCcTypeErrorMsg() {
		return txtccTypeErrorMsg;
	}
	public WebElement getTxtCcExpiryErrorMsg() {
		return txtccExpiryErrorMsg;
	}
	public WebElement getTxtCcCvvNumErrorMsg() {
		return txtccCvvNumErrorMsg;
	}
	public WebElement getTxtSelectHotelSuccessMsg() {
		return txtSelectHotelSuccessMsg;
	}
	public WebElement getTxtFirstName() {
		return txtFirstName;
	}
	public WebElement getTxtLastName() {
		return txtLastName;
	}
	public WebElement getTxtAddress() {
		return txtAddress;
	}
	public WebElement getTxtCcNum() {
		return txtCcNum;
	}
	public WebElement getDdnCcType() {
		return ddnCcType;
	}
	public WebElement getDdnCcExpMonth() {
		return ddnCcExpMonth;
	}
	public WebElement getDdnCcExpYear() {
		return ddnCcExpYear;
	}
	public WebElement getTxtCcCvv() {
		return txtCcCvv;
	}
	public WebElement getBtnbookNow() {
		return btnbookNow;
	}
	/**
	 * @see used to perform hotel booking
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param ccNum
	 * @param ccType
	 * @param ccExpMonth
	 * @param ccExpYear
	 * @param txtCcV
	 */
	public void bookHotel(String firstName,String lastName,String address, String ccNum,
								String ccType,String ccExpMonth,String ccExpYear, String txtCcV) {
		sendKeysToElement(getTxtFirstName(), firstName);
		sendKeysToElement(getTxtLastName(), lastName);
		sendKeysToElement(getTxtAddress(), address);
		sendKeysToElement(getTxtCcNum(), ccNum);
		selectOptionByText(getDdnCcType(), ccType);
		selectOptionByText(getDdnCcExpMonth(), ccExpMonth);
		selectOptionByText(getDdnCcExpYear(), ccExpYear);
		sendKeysToElement(getTxtCcCvv(), txtCcV);
		clickBookNow();
	}
	/**
	 * @see used to click book now button
	 */
	public void clickBookNow() {
		clickElement(getBtnbookNow());	
	}
	}
