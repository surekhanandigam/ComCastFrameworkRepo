package practice.test;

import org.testng.Assert;

import org.testng.annotations.Test;


public class RetryAnalyzer_InvoiceTest {
	@Test(retryAnalyzer=com.comcast.crm.generic.listenerutility.RetryListenerImp.class)
	public void activateSim()
	{
		System.out.println("executeInvoiceTest");
		Assert.assertEquals("","Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
}
