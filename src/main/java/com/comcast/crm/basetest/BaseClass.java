package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;

public class BaseClass {
	public WebDriver driver = null;
	public DataBaseUtility dblib = new DataBaseUtility();
	public FileUtility flib = new FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public ExcelUtility elib = new ExcelUtility();
	public LoginPage lp;
	public WebDriverUtility wblib = new WebDriverUtility();
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "SmokeTesting", "RegressionTesting" })
	public void configBS() throws Throwable {
		System.out.println("===Connect to DB,Report Config===");
		dblib.getDBConnection();
	}

	// @Parameters("Browser")
	@BeforeClass(groups = { "SmokeTesting", "RegressionTesting" })
	public void configBC() throws Throwable {
		System.out.println("===launch the  Browser===");
		String browser = flib.getDataFromPropertiesFile("browser");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;// temporary driver
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "SmokeTesting", "RegressionTesting" })
	public void configBM() throws Throwable {
		System.out.println("=Login=");
		String url = flib.getDataFromPropertiesFile("url");
		String username = flib.getDataFromPropertiesFile("username");
		String password = flib.getDataFromPropertiesFile("password");
		driver.get(url);
		wblib.waitForPageToLoad(driver);
		lp = new LoginPage(driver);
		lp.loginToapp(username, password);
	}

	@AfterMethod(groups = { "SmokeTesting", "RegressionTesting" })
	public void configAM() {
		System.out.println("=Logout=");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "SmokeTesting", "RegressionTesting" })
	public void configAC() {
		System.out.println("===Close the Browser===");
		driver.quit();
	}

	@AfterSuite(groups = { "SmokeTesting", "RegressionTesting" })
	public void configAS() throws SQLException {
		System.out.println("===Close DB, Report backUP===");
		dblib.closeDBConnection();
		
	}
}
