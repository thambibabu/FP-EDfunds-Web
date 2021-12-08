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
import com.financepeer.pages.StudentPage;
import com.financepeer.util.TestUtil;
import com.financepeer.util.Xls_Reader;

public class StudentPageTest extends TestBase{

	
		public static StudentPage studentPage;
		public TestUtil testUtil;
		
		Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
		
		String sheetName		= "StudentPage";
		String studentName		= "Student Name";
		String instituteName	= "Institute Name";
		String MobileNum 		= "Mobile Number";
		String emaiId			= "Email id";
		
		String mobileNum_row2= reader.getCellData(sheetName, MobileNum, 2);
		String instituteName_row2= reader.getCellData(sheetName, instituteName, 2);
		String studentName_row2= reader.getCellData(sheetName, studentName, 2);
		String studentName_row3= reader.getCellData(sheetName, studentName, 3);
		String studentName_row4= reader.getCellData(sheetName, studentName, 4);
		String studentName_row5= reader.getCellData(sheetName, studentName, 5);

		String emaiId_row2= reader.getCellData(sheetName, emaiId, 2);
		
		
		public StudentPageTest() {
			super();
		}
		
		
		@BeforeMethod
		public void startTest(ITestResult result) {
			initialization();
			studentPage=new StudentPage();	
			testStart(result);
		}
		
		@BeforeTest
		public void getReports() {
			getSysInfo();
		}
		
		
		
		
	
		//signin page title test
		@Test(priority=1, enabled = true)
		public void financepeer_HomePageTitle() {
				
			String title=studentPage.validateHomePageTitle();
			Assert.assertEquals(title, "Financepeer : Education Loans | Institution Fee Financing");
			System.out.println(title);
				
		}
		
		@Test(priority=2, enabled = true)
		public void applyLoanWithoutDetails() {
			String validation = studentPage.clickApplyNowWithoutDetails();
			Assert.assertEquals(validation, "Please enter all the details.");
			System.out.println(validation);
		}
		
		
		@Test(priority=3, enabled = false)
		public void studentNameEnterDigits() {
			String validation = studentPage.studentNameEnterDigits(mobileNum_row2, instituteName_row2, studentName_row2, emaiId_row2);
			Assert.assertEquals(validation, "Please enter all the details.");
			System.out.println(validation);
		}
		
		@Test(priority=4, enabled = true)
		public void applyLoanWithValidDetails() throws Throwable {
			 Assert.assertTrue(studentPage.applyLoanWithValidDetails(mobileNum_row2, instituteName_row2, studentName_row3, 
						emaiId_row2, prop.getProperty("OTP"), prop.getProperty("expURL")));
		}
		
		@Test(priority=5, enabled = false)
		public void verifyStudentNameWithSplCharsTest() {
			String validation = studentPage.verifyStudentNameWithSplChars(mobileNum_row2, instituteName_row2, studentName_row4, emaiId_row2);
			Assert.assertEquals(validation, "Please enter all the details.");
			System.out.println(validation);
		}
		
		@Test(priority=6, enabled = false)
		public void verifyStudentNameWithAllCombinationsTest()
		{
			String validation = studentPage.veriryStudentNameWithAllCombinations(mobileNum_row2, instituteName_row2, studentName_row5, emaiId_row2);
			Assert.assertEquals(validation, "Please enter all the details.");
			System.out.println(validation);
		}
		
		//verify the contact page link in student page
		@Test(priority=7, enabled=true)
		public void contactUsLinkTestInStudentPage() throws Throwable {
			String act_url = studentPage.verifyContactUsLink();
			String exp_url = prop.getProperty("contactPageURL");
			Assert.assertEquals(act_url, exp_url);
			System.out.println(act_url);
		}
		
		//verify the privacy policy link
		@Test(priority=8, enabled=true)
		public void privacyAndPolicyLinkTestInStudentPage() throws Throwable
		{
			String act_url = studentPage.verifyPrivacyAndPolicyLink();
			Assert.assertEquals(act_url, prop.getProperty("privacyPolicy_url"));
			System.out.println(act_url);
		}
		
		@Test(priority=9, enabled=true)
		public void termsAndConditionsLinkTestInStudentPage() throws Throwable
		{
			String act_url = studentPage.verifyTermsAndConditionsLink();
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
