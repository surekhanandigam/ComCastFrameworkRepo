package com.comcast.crm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
//SMOKE SCENARIO : CREATING THE ORG WITH MANDATORY FIELDS
public class CreateOrganizationTest extends BaseClass {
	@Test(groups="SmokeTesting")
	public void createOrgTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO,"read data from Excel");

		String browser = flib.getDataFromPropertiesFile("browser");

		String orgname = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
		String shippingadd = elib.getDataFromExcel("org", 1, 5);

		// navigate to Organization module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to Org Page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on create organization button
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create org page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// enter the details in org
		UtilityClassObject.getTest().log(Status.INFO,"create new org page");
		CreatingNewOrganizationPage cp = new CreatingNewOrganizationPage(driver);
		cp.createOrg(orgname, shippingadd);

		// verify the header msge Expected Result---------------------
		UtilityClassObject.getTest().log(Status.INFO,orgname + "----------create new org page");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgname = oip.getHeadermsg().getText();
		boolean act=actOrgname.contains(orgname);
	    Assert.assertEquals(act,true);
	}

	@Test(groups="RegressionTesting")
	public void createOrgWithIndustry() throws Throwable {
		String browser = flib.getDataFromPropertiesFile("browser");

		String orgname = elib.getDataFromExcel("org", 4, 2) + jlib.getRandomNumber();
		String industry = elib.getDataFromExcel("org", 4, 4);
		String type = elib.getDataFromExcel("org", 4, 5);
		String shippingadd = elib.getDataFromExcel("org", 4, 6);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.selectIndustry(orgname, shippingadd, industry, type);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actind = oip.getActIndustry().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actind,industry);
		
		String acttype = oip.getActType().getText();
		soft.assertEquals(acttype,type);
		soft.assertAll();
	}

	@Test(groups="RegressionTesting")
	public void createOrgWithPhonenumber() throws Throwable {
		String browser = flib.getDataFromPropertiesFile("browser");

		String orgname = elib.getDataFromExcel("org", 7, 2) + jlib.getRandomNumber();
		String phnnum = elib.getDataFromExcel("org", 7, 4);
		String shippingadd = elib.getDataFromExcel("org", 7, 5);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage co = new CreatingNewOrganizationPage(driver);
		co.enterPhnNum(orgname, shippingadd, phnnum);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actphnnum = oip.getActphn().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actphnnum,phnnum);
		soft.assertAll();
		
	}
}
