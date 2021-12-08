package com.financepeer.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.financepeer.base.TestBase;
import com.financepeer.pages.UVACardPage;
import com.financepeer.util.TestUtil;
import com.financepeer.util.Xls_Reader;

public class UVACardPageTest extends TestBase{

public static UVACardPage uvaCardPage;

	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);

	String sheetName		= "Login";
	String MobileNum 		= "MobileNumber";
	String mobileNum_row2= reader.getCellData(sheetName, MobileNum, 2);
	
	public UVACardPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void startTest(ITestResult result) {
		initialization();
		uvaCardPage=new UVACardPage();	
		testStart(result);
	}
	
	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	

	@Test(priority=1, enabled=true)
	public void joinTheTrendTest() {
		String actualValidation = uvaCardPage.joinTheTrend(mobileNum_row2);
		String expValidation = "Thanks for showing interest in our product. Our team will soon "
				+ "reach out to you with exclusive launch offers and rewards.";
		
		Assert.assertEquals(actualValidation, expValidation);
		System.out.println(actualValidation);
	}
	
	@Test(priority=2, enabled=true)
	public void privacyAndPolicyLinkTestInUVACard() throws Throwable {
		String act_url = uvaCardPage.verifyPrivacyAndPolicyLink();
		Assert.assertEquals(act_url, prop.getProperty("privacyPolicy_url"));
		System.out.println(act_url);
	}
	
	@Test(priority=3, enabled=true)
	public void termsAndConditionsLinkTestInUVACard() throws Throwable
	{
		String act_url = uvaCardPage.verifyTermsAndConditionsLink();
		Assert.assertEquals(act_url, prop.getProperty("termsAndConditions_url"));
		System.out.println(act_url);
	}
		
	
	@AfterMethod
	public void getTestReportStatus(ITestResult result) throws IOException {
		getTestStatus(result);
		driver.quit();
	}

	@AfterTest
	public void endTest() {
		endReport();
	}
}
