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
import com.financepeer.pages.InstitutePage;
import com.financepeer.util.TestUtil;
import com.financepeer.util.Xls_Reader;


public class InstitutePageTest extends TestBase{

	public static InstitutePage institutePage;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);

	String sheetName		= "Login";
	String MobileNum 		= "MobileNumber";
	String mobileNum_row2	= reader.getCellData(sheetName, MobileNum, 2);
	
	
	public InstitutePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void startTest(ITestResult result) {
		initialization();
		institutePage=new InstitutePage();	
		testStart(result);
	}
	
	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	

	@Test(priority=1, enabled=true)
	public void getInTouchTest() {
		institutePage.getInTouch(mobileNum_row2);
	}
	
	@Test(priority=2, enabled=true)
	public void privacyAndPolicyLinkTest_Institute() throws Throwable {
		String act_url = institutePage.verifyPrivacyAndPolicyLink();
		Assert.assertEquals(act_url, prop.getProperty("privacyPolicy_url"));
		System.out.println(act_url);
	}
	
	@Test(priority=3, enabled=true)
	public void termsAndConditionsLinkTest_Institute() throws Throwable
	{
		String act_url = institutePage.verifyTermsAndConditionsLink();
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
