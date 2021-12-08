package com.financepeer.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.financepeer.base.TestBase;
import com.financepeer.pages.ContactUs;
import com.financepeer.util.TestUtil;
import com.financepeer.util.Xls_Reader;

public class ContactUsPageTest extends TestBase{

public ContactUs contactUs;
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetName	= "contactUs";
	String MobileNum 	= "MobileNumber";
	String emailid      = "emailId";
	
	String mobileNum_row2= reader.getCellData(sheetName, MobileNum, 2);
	String emailid_row2 = reader.getCellData(sheetName, emailid, 2);
	
	public ContactUsPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void startTest(ITestResult result) {
		initialization();
		contactUs=new ContactUs();	
		testStart(result);
	}
	
	@BeforeTest
	public void getReports() {
		getSysInfo();
	}
	
	
	@Test(priority=1, enabled=true)
	public void writeToUsTest() {
		
		contactUs.writeToUs(mobileNum_row2, emailid_row2);
		
	}
	
	
	
	@AfterMethod
	public void getTestReportStatus(ITestResult result) throws IOException {
		getTestStatus(result);
		//driver.quit();
	}

	@AfterTest
	public void endTest() {
		endReport();
	}
}
