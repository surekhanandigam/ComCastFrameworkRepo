package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
 
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="accountname")
	private WebElement orgnameEdt;
	
	@FindBy(name="ship_street")
	private WebElement shippingaddEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	@FindBy(name="industry")
	private WebElement industrydd;
	
	@FindBy(name="accounttype")
	private WebElement typedb;
	
	@FindBy(id="phone")
	private WebElement phn;
	
	public WebElement getPhn() {
		return phn;
	}

	public WebElement getTypedb() {
		return typedb;
	}

	public WebElement getOrgnameEdt() {
		return orgnameEdt;
	}

	public WebElement getIndustrydd() {
		return industrydd;
	}

	public WebElement getOrgname() {
		return orgnameEdt;
	}

	public WebElement getShippingadd() {
		return shippingaddEdt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createOrg(String orgname,String shippingadd)
	{
		 orgnameEdt.sendKeys(orgname);
		 shippingaddEdt.sendKeys(shippingadd);
		 savebtn.click();
	}
	
	public void selectIndustry(String orgname,String shippingadd,String industry,String type)
	{
		orgnameEdt.sendKeys(orgname);
		shippingaddEdt.sendKeys(shippingadd);
		Select sel=new Select(industrydd);
		sel.selectByVisibleText(industry);
		Select sel1=new Select(typedb);
		sel1.selectByVisibleText(type); 
		savebtn.click();	
	}
	
	public void enterPhnNum(String orgname,String shippingadd,String phnnum)
	{
		orgnameEdt.sendKeys(orgname);
		shippingaddEdt.sendKeys(shippingadd);
		phn.sendKeys(phnnum);
		savebtn.click();	
	}
}
