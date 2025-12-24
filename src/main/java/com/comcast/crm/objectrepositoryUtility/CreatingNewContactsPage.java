package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactsPage {
	
	WebDriver driver;
	public CreatingNewContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
    private	WebElement lastnameEdt;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebtn;
	

	@FindBy(name="support_start_date")
	private WebElement startDatecal;
	
	@FindBy(name="support_end_date")
	private WebElement endDatecal;
	
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement clickOrgSelectIcon;
	
	public WebElement getClickOrgSelectIcon() {
		return clickOrgSelectIcon;
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createContact(String lastname)
	{
	  lastnameEdt.sendKeys(lastname);
	  savebtn.click();
	}
	
	public void selectSupportDate(String lastname, String startDate, String endDate)
	{
	    lastnameEdt.sendKeys(lastname);
	    startDatecal.clear();
	    startDatecal.sendKeys(startDate);

	    endDatecal.clear();
	    endDatecal.sendKeys(endDate);

	    savebtn.click();
	}
    
    public void selectOrgModule(String contactLastname)
    {
    	lastnameEdt.sendKeys(contactLastname);
    	clickOrgSelectIcon.click();
    }
    
}
