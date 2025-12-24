package com.comcast.crm.objectrepositoryUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author 91765
 * 
 * Contains Login Page elements & business lib like login()
 */
public class LoginPage { //Rule-1 create a separate java class
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Rule-2 Object Creation
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
  
	//Rule-3 Object Intialization
	
	//Rule-4 Object Encapsulation
	
	//Rule-5 we can provide action
/**
 * login to application bases on username ,password arguments
 * @param username
 * @param password
 */
	public void loginToapp(String username,String password)
	{
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbtn.click();
	}

	public void setUsernameEdt(WebElement usernameEdt) {
		this.usernameEdt = usernameEdt;
	}
	
	
	
	
}
