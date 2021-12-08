package com.financepeer.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.financepeer.base.TestBase;
import com.financepeer.pages.SignUpPage;
import com.financepeer.util.TestUtil;
import com.financepeer.util.Xls_Reader;

public class SignUpPageTest extends TestBase
{

	public static SignUpPage singupPage;
	public TestUtil testUtil;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	public SignUpPageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		singupPage=new SignUpPage();	
	}
	
	@BeforeMethod
	public void startTest(ITestResult result) {
		testStart(result);
	}
	
	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	
	@Test(priority=1, enabled=true)
	public void verifySignUpLinkInLoginPopup() throws Throwable
	{
		Assert.assertTrue(singupPage.verifySignUpLinkInLoginPopup());
	}
	
	@Test(priority=2, enabled=true)
	public void verifySignUpLinkClickInLogin() throws Throwable
	{
		String actUrl = singupPage.verifySignUpLinkClickInLogin();
		Assert.assertEquals(actUrl, prop.getProperty("signUpUrl"));
		System.out.println(actUrl);
	}
	
	
	
	
	
	
	
	
	
	@AfterTest
	public void endTest() {
		endReport();
	}
	
	@AfterMethod
	public void getStatus(ITestResult result) throws IOException {
		getTestStatus(result);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
