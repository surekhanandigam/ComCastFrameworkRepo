package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {

	WebDriver driver;
	public ContactsInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement headerInfo;
    
	@FindBy(id="dtlview_Last Name")
	private WebElement lastnameInfo;
	
	@FindBy(xpath="//td[@id=\"mouseArea_Organization Name\"]/a")
	private WebElement orgnameValidation; 
	
	public WebElement getOrgnameValidation() {
		return orgnameValidation;
	}

	public WebElement getLastnameInfo() {
		return lastnameInfo;
	}

	@FindBy(id="dtlview_Support Start Date")
	private WebElement startDateValue;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement endDateValue;
	
	public WebElement getStartDateValue() {
		return startDateValue;
	}

	public WebElement getEndDateValue() {
		return endDateValue;
	}

	public WebElement getHeaderInfo() {
		return headerInfo;
	}
}
