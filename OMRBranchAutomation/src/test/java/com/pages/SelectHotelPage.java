package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Inbanesan
 * @see used to maintain SelectHotel page elements and methods
 * date 18-01-2023 
 */
public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement txtSearchHotelSuccessMsg;

	@CacheLookup
	@FindBy(id = "radiobutton_0")
	private WebElement rdoSelect;
	@CacheLookup
	@FindBy(id = "continue")
	private WebElement btnContinue;
	@FindBy(id="radiobutton_span")
	private WebElement txtselectErrorMsg;

	public WebElement getTxtSelectErrorMsg() {
		return txtselectErrorMsg;
	}

	public WebElement getSearchHotelSuccessMsg() {
		return txtSearchHotelSuccessMsg;
	}

	public WebElement getRadioSelect() {
		return rdoSelect;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
/**
 * @see used to perform select hotel
 */
	public void selectHotel() {
		clickElement(getRadioSelect());
		clickContinue();

	}
/**
 * @see used to click continue button
 */
	public void clickContinue() {
		clickElement(getBtnContinue());

	}

}
