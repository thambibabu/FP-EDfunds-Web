package com.financepeer.testcases;

import java.io.IOException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.financepeer.base.TestBase;
import com.financepeer.pages.LoginPage;
import com.financepeer.pages.applicationsCreation;
import com.financepeer.util.TestUtil;
import com.financepeer.util.Xls_Reader;

public class applicationsCreationTest extends TestBase {

	public static LoginPage login;
	public static applicationsCreation appsCreation;

	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);

	String sheetName 		= "Login";
	String MobileNum 		= "MobileNumber";

	String dashboard_sheet 	= "Dashboard";
	String DOB 				= "DOB";
	String instituteKeys	= "instituteKeys";
	String branchKeys 		= "branchKeys";
	String courseKeys 		= "courseKeys";
	String institute_Name 	= "InstituteName";
	String branchName 		= "branchName";
	String courseName 		= "course";
	String PAN_filepath 	= "PAN filepath";
	String Aadhaar_filepath = "Aadhaar filepath";
	String relationship 	= "relationship";
	String appleDevices 	= "appleDevices";

	String studentDOB 		= reader.getCellData(dashboard_sheet, DOB, 2);
	String instituteKey 	= reader.getCellData(dashboard_sheet, instituteKeys, 2);
	String branchKey 		= reader.getCellData(dashboard_sheet, branchKeys, 2);
	String courseKey 		= reader.getCellData(dashboard_sheet, courseKeys, 2);
	String institute 		= reader.getCellData(dashboard_sheet, institute_Name, 2);
	String branch 			= reader.getCellData(dashboard_sheet, branchName, 2);
	String course 			= reader.getCellData(dashboard_sheet, courseName, 2);
	String instituteKey1 	= reader.getCellData(dashboard_sheet, instituteKeys, 3);
	String branchKey1 		= reader.getCellData(dashboard_sheet, branchKeys, 3);
	String courseKey1 		= reader.getCellData(dashboard_sheet, courseKeys, 3);
	String institute1 		= reader.getCellData(dashboard_sheet, institute_Name, 3);
	String branch1 			= reader.getCellData(dashboard_sheet, branchName, 3);
	String course1 			= reader.getCellData(dashboard_sheet, courseName, 3);
	String relation 		= reader.getCellData(dashboard_sheet, relationship, 2);
	String appleProduct 	= reader.getCellData(dashboard_sheet, appleDevices, 2);
	String appleProduct1 	= reader.getCellData(dashboard_sheet, appleDevices, 3);
	String mobileNum_row2 	= reader.getCellData(sheetName, MobileNum, 2);
	 

	public applicationsCreationTest() {
		super();
	}

	@BeforeMethod
	public void startTest(ITestResult result) throws Throwable {
		initialization();
		login = new LoginPage();
		login.loginFromStudentPage(mobileNum_row2, prop.getProperty("OTP"));
		appsCreation = new applicationsCreation();
		testStart(result);
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}

	// create B2B fee finance application
	@Test(priority = 1, enabled = true)
	public void createB2BFeeFinanceTest() throws Throwable {
		String[] actualValidations = appsCreation.createB2BFeeFinance(studentDOB, instituteKey, institute, branchKey,
				branch, courseKey, course, prop.getProperty("Aadhaar_Number"), relation);

		Assert.assertTrue(true, actualValidations.toString());
		System.out.println(Arrays.toString(actualValidations));
		System.out.println("=====================================================");
	}

	// create B2B apple finance application
	@Test(priority = 2, enabled = true)
	public void createB2BAppleFinanceTest() throws Throwable {
		String[] actualValidations = appsCreation.createB2BAppleFinance(studentDOB, instituteKey, institute, branchKey,
				branch, courseKey, course, relation, appleProduct);

		Assert.assertTrue(true, actualValidations.toString());
		System.out.println(Arrays.toString(actualValidations));
		System.out.println("=====================================================");
	}

	// Create B2B fee and apple finance
	@Test(priority = 3, enabled = true)
	public void createB2BFeeAndAppleFinanceTest() throws Throwable {
		String[] actualValidations = appsCreation.createB2BFeeAndAppleFinance(studentDOB, instituteKey1, institute1,
				branchKey1, branch1, courseKey1, course1, relation, appleProduct1);
		Assert.assertTrue(true, actualValidations.toString());
		System.out.println(Arrays.toString(actualValidations));
		System.out.println("=====================================================");
	}

	// Create B2C fee finance
	@Test(priority = 4, enabled = true)
	public void createB2CFeeFinanceTest() throws Throwable {
		String[] actualValidations = appsCreation.createB2CFeeFinance(studentDOB, relation);
		Assert.assertTrue(true, actualValidations.toString());
		System.out.println(Arrays.toString(actualValidations));
		System.out.println("=====================================================");
	}

	// Create B2C apple finance
	@Test(priority = 5, enabled = true)
	public void createB2CAppleFinanceTest() throws Throwable {

		String[] actualValidations = appsCreation.createB2CAppleFinance(studentDOB, relation, "hyd", "Hyderabad",
				appleProduct);
		Assert.assertTrue(true, actualValidations.toString());
		System.out.println(Arrays.toString(actualValidations));
		System.out.println("=====================================================");
	}

	@Test(priority = 6, enabled = true)
	public void createB2CFeeAndAppleFinanceTest() throws Throwable {
		String[] actualValidations = appsCreation.createB2CFeeAndAppleFinance(studentDOB, relation, "hyd", "Hyderabad",
				appleProduct);
		Assert.assertTrue(true, actualValidations.toString());
		System.out.println(Arrays.toString(actualValidations));
		System.out.println("=====================================================");
	}

	@AfterTest
	public void endTest() {
		endReport();
	}

	@AfterMethod
	public void getStatus(ITestResult result) throws IOException {
		getTestStatus(result);
		driver.quit();
	}

}
