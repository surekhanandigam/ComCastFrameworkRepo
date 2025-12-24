package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
   
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className="dvHeaderText")
	private WebElement headermsg;
	
	public WebElement getHeadermsg() {
		return headermsg;
	}
	
	@FindBy(id="dtlview_Phone")
	private WebElement actphn;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement actIndustry;
	
	@FindBy(id="mouseArea_Type")
	private WebElement actType;
	
	public WebElement getActphn() {
		return actphn;
	}

	public WebElement getActIndustry() {
		return actIndustry;
	}

	public WebElement getActType() {
		return actType;
	}
	

	
	
	
	
}
