package practice.test;
/**
 * test class for Contact module
 * @author 91765
 */

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryUtility.LoginPage;

public class CondingStandards_SearchContectTest extends BaseClass{
   /**
    * scenario:login()---->navigateContact--->createContact()---verify
    */
	
	@Test
	public void searchContactTest()
	{
		/*step-1:login to app*/
	    LoginPage lp=new LoginPage(driver);
	    lp.loginToapp("username","password");
	}
}
