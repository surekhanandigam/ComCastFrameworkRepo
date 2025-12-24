package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	 WebDriver driver;
	 public OrganizationsPage(WebDriver driver)
	    {
	    	this.driver=driver;
	    	PageFactory.initElements(driver,this);
	    }
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;
	 
	@FindBy(name="search_text")
	private WebElement searchedt;
	
	@FindBy(name="search_field")
	private WebElement searchdd;
	
	@FindBy(name="submit")
	private WebElement searchbtn;
	
	@FindBy(id="search_txt")
	private WebElement searchTxt;
	
	@FindBy(name="search")
	private WebElement searchOrg;
	
	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getSearchedt() {
		return searchedt;
	}

	public WebElement getSearchdd() {
		return searchdd;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	public WebElement getSearchOrg() {
		return searchOrg;
	}

	public void selectOrgName(String orgname)
	{
		searchTxt.sendKeys(orgname);
		searchOrg.click();
	}
	
	
	
	
}
