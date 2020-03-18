package com.DISTEST.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DISTEST.base.TestBase;


public class HomePage extends TestBase {
	
	@FindBy(css = "")
	List<WebElement> Element1;
	
	public HomePage() {

		PageFactory.initElements(driver, this);
		
	}
	

}
