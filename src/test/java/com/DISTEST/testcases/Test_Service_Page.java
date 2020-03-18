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

public class Test_Service_Page extends TestBase {
	
	@BeforeMethod
	public void start(Method method) throws InterruptedException, Throwable {
		
		logger = extent.startTest(method.getName());
		ServicePagePre();
		
	}
	
	
	
	
	@Test(priority = 8)
	public void Test_Case_8() throws InterruptedException {
        System.out.println("Test Case 8 !  running !");
		
		String actualResult = "Disruptive Innovation Services | Disruptive Innovation Services";
		String expectedResult = driver.getTitle();
		Assert.assertEquals(actualResult, expectedResult);
		
		
	}
	
	@Test(priority = 9)
	public void Test_Case_9() throws InterruptedException {
		System.out.println("Test Case 9 !  running !");
		
		String actualResult = "https://disruptive-innoserv.com/services";
		String expectedResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, expectedResult);
		
		
	}
	
	
	@Test(priority = 10)
	public void Test_Case_10() throws InterruptedException {
		System.out.println("Test Case 10 !  running !");
		
		WebElement ProjectManagementServicesImg = driver.findElement(By.xpath("//img[@data-aid='ABOUT_IMAGE_RENDERED4']"));
		Actions action = new Actions(driver);
		action.moveToElement(ProjectManagementServicesImg).build().perform();
		
		Thread.sleep(2000);
		
		if (ProjectManagementServicesImg.isDisplayed())
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
