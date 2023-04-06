package com.demowebshop.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessages;
import com.demowebshop.pages.HomePage;
import com.demowebshop.utilities.ExcelUtility;

public class HomeTest extends Base{
	HomePage home;
	@Test(priority=1,enabled=true,description="TC001 verify home page title")
	public void TC001_verifyHomePageTitle()
	{
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("HomePage");
		String expectedHomePageTitle=data.get(1).get(0);
		home=new HomePage(driver);
		String actualHomePageTitle=home.getHomePageTitle();
		Assert.assertEquals(expectedHomePageTitle, actualHomePageTitle,ErrorMessages.TITLE_FAILURE_MESSAGES);
	}
	@Test(priority=1,enabled=true,description="TC002 verify subscribe Email message")
	public void TC002_verifySubscribeEmailMessage()
	{
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("HomePage");
		String expSubMessage=data.get(1).get(1);
		home=new HomePage(driver);
		home.enterSubEmail();
		home.clickOnSubButton();
		String actualSubMessage=home.getSubMessage();
		Assert.assertEquals(expSubMessage, actualSubMessage,ErrorMessages.EMAIL_FAILURE_MESSAGES);
		
	}
	
	

}
