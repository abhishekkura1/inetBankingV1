package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.ExcelUtils;

public class TC_002_LoginDataDrivenTest extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDataDrivenTest(String user,String pwd)throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("User name provided");
		lp.setPassword(pwd);
		logger.info("Password provided");
		lp.clickSubmit();
		Thread.sleep(1000);
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("Login failed");
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			logger.warn("Login passed");
			lp.clickLogout();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	@DataProvider(name="LoginData")
	String[][] getData()throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rownum=ExcelUtils.getRowCount(path,"Sheet1");
		int colcount=ExcelUtils.getCellCount(path,"Sheet1",1);
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=ExcelUtils.getCellData(path,"Sheet1",i,j);
			}
		}
		return logindata;
	}
}