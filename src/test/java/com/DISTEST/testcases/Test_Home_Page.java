package com.DISTEST.testcases;


import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.DISTEST.base.TestBase;
import com.DISTEST.utils.TestUtil;
import com.relevantcodes.extentreports.LogStatus;


public class Test_Home_Page extends TestBase {
	
	
	public Test_Home_Page() {
		super();
	}
	
	@BeforeMethod
	public void start(Method method) throws InterruptedException, Throwable {
		
		logger = extent.startTest(method.getName());
		initialization(prop.getProperty("local"));
		
	}
	
	
	@Test(priority = 1)
	public void Test_Case_1() throws InterruptedException {
		System.out.println("Test Case 1 !  running !");
		
		String actualResult = "Disruptive Innovation Services - Home";
		String expectedResult = driver.getTitle();
		Assert.assertEquals(actualResult, expectedResult);
		
		
	}
	
	
	@Test(priority = 2)
	public void Test_Case_2() throws InterruptedException {
		System.out.println("Test Case 2 !  running !");
		
		String actualResult = "https://disruptive-innoserv.com/";
		String expectedResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, expectedResult);
		
		
	}
	
	@Test(priority = 3)
	public void Test_Case_3() throws InterruptedException {
		System.out.println("Test Case 3 !  running !");
		
		WebElement logo = driver.findElement(By.xpath("//img[@data-field-id='logo']"));
		if (logo.isDisplayed())
		{
			System.out.println("The logo is Displayed");
		}else
		{
			System.out.println("The logo is not Displayed");
		}
		
				
	}
	
	
	@Test(priority = 4)
	public void Test_Case_4() throws InterruptedException {
		System.out.println("Test Case 4 !  running !");
		
		WebElement findOutMoreButton = driver.findElement(By.xpath("//a[@data-aid='CTA_BUTTON_RENDERED']"));
		Actions action = new Actions(driver);
		action.moveToElement(findOutMoreButton).build().perform();
		
		Thread.sleep(2000);
		
		if (findOutMoreButton.isDisplayed())
		{
			System.out.println("The Button is Displayed");
		}else
		{
			System.out.println("The Botton is not Displayed");
		}
		
				
	}
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Throwable {
		
		if (result.getStatus() == ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL, "Test Failed " + result.getThrowable());
			String picturePath = TestUtil.TakeSnapshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(picturePath));
			

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test case Skipped is " + result.getName());

		} else {
			logger.log(LogStatus.PASS, "Test passed");
			String picturePath = TestUtil.TakeSnapshot(driver, result.getName());
			logger.log(LogStatus.PASS, logger.addScreenCapture(picturePath));
			
		}

		extent.endTest(logger);
		driver.quit();
	}
	
	
	

}
