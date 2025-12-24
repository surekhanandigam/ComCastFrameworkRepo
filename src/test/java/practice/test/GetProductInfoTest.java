package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {

	@DataProvider
	public Object[][] getProductInfoTest() throws Throwable {

	    ExcelUtility eu = new ExcelUtility();
	 
	    int rowcount = eu.getRowcount("product"); 

	    Object[][] obj = new Object[rowcount][2];

	    for (int i = 1; i <=rowcount; i++) {
	        obj[i-1][0] = eu.getDataFromExcel("product", i, 0);
	        obj[i-1][1] = eu.getDataFromExcel("product", i, 1); 
	    }
	    return obj;
	}
	
	@Test(dataProvider="getProductInfoTest")
	public void getData(String brandName,String productName)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys(brandName,Keys.ENTER);
		String price=driver.findElement(By.xpath("//div[text()='"+productName+"']//ancestor::div[@class='ZFwe0M row']//descendant::div[@class='hZ3P6w DeU9vF']"))
		.getText();
		System.out.println(price);	
	}
}
