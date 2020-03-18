package com.DISTEST.testcases;

import java.io.IOException;
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

public class Test_Methodology_Page extends TestBase {
	
	
	@BeforeMethod
	public void ini(Method method) {
		logger = extent.startTest(method.getName());
		methodologyPagePre();
	}
	
	
	@Test(priority = 5)
	public void Test_Case_5() throws InterruptedException {
		System.out.println("Test Case 5 !  running !");
		
		String actualResult = "Methodology | Disruptive Innovation Services";
		String expectedResult = driver.getTitle();
		Assert.assertEquals(actualResult, expectedResult);
		
		
	}
	
	@Test(priority = 6)
	public void Test_Case_6() throws InterruptedException {
		System.out.println("Test Case 6 !  running !");
		
		String actualResult = "https://disruptive-innoserv.com/methodology";
		String expectedResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, expectedResult);
		
		
	}
	
	@Test(priority = 7)
	public void Test_Case_7() throws InterruptedException {
		System.out.println("Test Case 7 !  running !");
		WebElement OpenSpaceFacilityImg = driver.findElement(By.xpath("//*[@id=\"3cdaa970-dc8f-408f-9aa5-6951e799d85d\"]/div/div/section/div/div/div[5]/div/div[1]/span/img"));
		Actions action = new Actions(driver);
		action.moveToElement(OpenSpaceFacilityImg).build().perform();
		
		Thread.sleep(2000);
		
		if (OpenSpaceFacilityImg.isDisplayed())
		{
			System.out.println("The Button is Displayed");
		}else
		{
			System.out.println("The Botton is not Displayed");
		}
		
				
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
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


