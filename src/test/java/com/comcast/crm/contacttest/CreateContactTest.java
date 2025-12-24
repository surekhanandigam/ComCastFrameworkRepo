package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryUtility.ContactsInfoPage;
import com.comcast.crm.objectrepositoryUtility.ContactsPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewContactsPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;
/**
 * @author 91765
 */

public class CreateContactTest extends BaseClass {
	@Test(groups="SmokeTesting")
	public void testcase() throws Throwable {
        /*step-1:read testscript data from ExcelFile*/
		String browser = flib.getDataFromPropertiesFile("browser");
		String lastname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		wblib.waitForPageToLoad(driver);
		
		/*step-2:navigate to contact module*/
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
        
		/*step-3:click on "create Contact" Button*/
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		/*step-4:enter all the details & create new Contact*/
		CreatingNewContactsPage cnp = new CreatingNewContactsPage(driver);
		cnp.createContact(lastname);

		ContactsInfoPage cip = new ContactsInfoPage(driver);
	    String actheaderInfo=cip.getHeaderInfo().getText();
	    boolean status=actheaderInfo.contains(lastname);
	    Assert.assertEquals(status,true);
	    
	    String actLastName=cip.getLastnameInfo().getText();
	   // Assert.assertEquals(lastname, actLastName);
	    SoftAssert soft=new SoftAssert();
	    soft.assertEquals(actLastName,lastname);
	    soft.assertAll();
	}

	@Test(groups="RegressionTesting")
	public void createContactWithsupportDateTest() throws Throwable {
		/*step-1:read testscript data from ExcelFile*/
		String browser = flib.getDataFromPropertiesFile("browser");
		String lastname = elib.getDataFromExcel("contact", 4, 2) + jlib.getRandomNumber();
		/*step-2:navigate to contact module*/
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		/*step-3:click on "create Contact" Button*/
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		String startDate = jlib.getSystemDateYYYYMMDD();
		String endDate = jlib.getRequiredDateYYYYMMDD(30);
		/*step-4:enter all the details & create new Contact*/
		CreatingNewContactsPage cnp = new CreatingNewContactsPage(driver);
		cnp.selectSupportDate(lastname, startDate, endDate);

		// verify start date expected result
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actstartDate = cip.getStartDateValue().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actstartDate,startDate);
		String actendDate = cip.getEndDateValue().getText();
		soft.assertEquals(actendDate,endDate);
		soft.assertAll();
	}

	@Test(groups="RegressionTesting")
	public void createContactWithOrgTest() throws Throwable {
		String browser = flib.getDataFromPropertiesFile("browser");
		/*step-1:read testscript data from ExcelFile*/
		String orgname = elib.getDataFromExcel("org", 7, 2) + jlib.getRandomNumber();
		String shippingadd = elib.getDataFromExcel("org", 7, 5);
		String contactLastname = elib.getDataFromExcel("contact", 7, 3) + jlib.getRandomNumber();
		/*step-2:navigate to contact module*/
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnp = new CreatingNewOrganizationPage(driver);
		cnp.createOrg(orgname, shippingadd);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		// verify Header msge expected result------------------------------------
		String actHeaderInfo = oip.getHeadermsg().getText();
		boolean org=actHeaderInfo.contains(orgname);
	    Assert.assertEquals(org,true);
		hp.getContactLink().click();
		/*step-3:click on "create Contact" Button*/
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		/*step-4:enter all the details & create new Contact*/
		CreatingNewContactsPage cncp = new CreatingNewContactsPage(driver);
		cncp.selectOrgModule(contactLastname);

		wblib.switchToTabOnURL(driver, "module=Accounts");
		op.selectOrgName(orgname);
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		wblib.switchToTabOnTitle(driver, "Contacts&action");
		cncp.getSavebtn().click();

		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String actOrgname = cip.getOrgnameValidation().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actOrgname,orgname);
		soft.assertAll();
	}
}
