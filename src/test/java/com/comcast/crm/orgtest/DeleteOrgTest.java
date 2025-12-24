package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;


public class DeleteOrgTest {
	@Test
	public void testcase() throws Throwable { 
		FileUtility flib=new FileUtility();  
		String browser=flib.getDataFromPropertiesFile("browser");
		String url=flib.getDataFromPropertiesFile("url");
		String username=flib.getDataFromPropertiesFile("username");
		String password=flib.getDataFromPropertiesFile("password");
		
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		String orgname=elib.getDataFromExcel("org",1,2)+jlib.getRandomNumber();
		String shippingadd=elib.getDataFromExcel("org",1,5);
		
		WebDriver driver=null;
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		WebDriverUtility wblib=new WebDriverUtility();
	    wblib.waitForPageToLoad(driver);
		driver.get(url);
		LoginPage lp=new LoginPage(driver);

		lp.loginToapp("admin","admin");
		
		//navigate to Organization module
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		//click on create organization button
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		//enter the details in org
		CreatingNewOrganizationPage cp=new CreatingNewOrganizationPage(driver);
		cp.createOrg(orgname,shippingadd);
		
		//verify the header msge Expected Result
		 OrganizationInfoPage oip=new  OrganizationInfoPage(driver);
		 String actOrgname=oip.getHeadermsg().getText();
		 if(actOrgname.contains(orgname))
		 {
			 System.out.println(orgname+ " is verified");
		 }
		 else
		 {
			 System.out.println(orgname+ " is not verified");
		 }
		 //go back to Organization page 
		 hp.getOrgLink().click();
	     //search for organization 
		 op.getSearchedt().sendKeys(orgname);
		 wblib.select(op.getSearchdd(),"Organization Name");
		 op.getSearchbtn().click();
		 
		 driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		 
	    //in dynamic webtable select and delete org
		 
		 //logout
		// hp.logout();
	  // 	driver.quit();
	  
	 }
}
