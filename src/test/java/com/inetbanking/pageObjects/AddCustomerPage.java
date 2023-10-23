package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage
{
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(how=How.XPATH,using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	@FindBy(how=How.NAME,using="name")
	@CacheLookup
	WebElement txtCustomerName;
	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement rdGender;
	@CacheLookup
	@FindBy(how=How.ID_OR_NAME,using="dob")
	WebElement txtdob;
	@CacheLookup
	@FindBy(how=How.NAME,using="addr")
	WebElement txtaddress;
	@CacheLookup
	@FindBy(how=How.NAME,using="city")
	WebElement txtcity;
	@CacheLookup
	@FindBy(how=How.NAME,using="state")
	WebElement txtstate;
	@CacheLookup
	@FindBy(how=How.NAME,using="pinno")
	WebElement txtpinno;
	@CacheLookup
	@FindBy(how=How.NAME,using="telephoneno")
	WebElement txttelephoneno;
	@CacheLookup
	@FindBy(how=How.NAME,using="emailid")
	WebElement txtemailid;
	@CacheLookup
	@FindBy(how=How.NAME,using="password")
	WebElement txtpassword;
	@CacheLookup
	@FindBy(how=How.NAME,using="sub")
	WebElement btnSubmit;
	public void clickAddNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	public void custGender(String cgender)
	{
		rdGender.click();
	}
	public void custdob(String dd,String mm,String yyyy)
	{
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yyyy);
	}
	public void custAddress(String caddress)
	{
		txtaddress.sendKeys(caddress);
	}
	public void custCity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	public void custState(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	public void custPinno(int cpinno)
	{
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	public void custTelephoneno(String ctelephoneno)
	{
		txttelephoneno.sendKeys(ctelephoneno);
	}
	public void custEmailid(String cemailid)
	{
		txtemailid.sendKeys(cemailid);
	}
	public void custPassword(String cpassword)
	{
		txtpassword.sendKeys(cpassword);
	}
	public void custSubmit()
	{
		btnSubmit.click();
	}
}