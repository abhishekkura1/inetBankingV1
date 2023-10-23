package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_003_AddCustomerTest extends BaseClass
{
	@Test
	public void addNewCustomer()throws InterruptedException,IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		Thread.sleep(1000);
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("Providing customer details...");
		addcust.custName("Abhishek");
		addcust.custGender("male");
		addcust.custdob("18","08","1997");
		Thread.sleep(2000);
		addcust.custAddress("India");
		addcust.custCity("Bangalore");
		addcust.custState("Karnataka");
		addcust.custPinno(560001);
		addcust.custTelephoneno("9876543210");
		String email=randomString()+"@gmail.com";
		addcust.custEmailid(email);
		addcust.custPassword("abcdef");
		addcust.custSubmit();
		Thread.sleep(1000);
		logger.info("Validation started...");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}
		else
		{
			logger.info("Test case failed");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}