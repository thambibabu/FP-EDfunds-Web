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
import com.financepeer.pages.LoginPage;

import com.financepeer.util.TestUtil;
import com.financepeer.util.Xls_Reader;

public class LoginPageTest extends TestBase {

	public static LoginPage loginPage;
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);

	String sheetName = "Login";
	String MobileNum = "MobileNumber";
	String mobileNum_row2 = reader.getCellData(sheetName, MobileNum, 2);

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void startTest(ITestResult result) {
		testStart(result);
		initialization();
		loginPage = new LoginPage();
	}

	@BeforeTest
	public void getReports() {
		getSysInfo();
	}

	@Test(priority = 1, enabled = true)
	public void loginFromStudentPageTest() throws Throwable {
		String actual_URL = loginPage.loginFromStudentPage(mobileNum_row2, prop.getProperty("OTP"));
		Assert.assertEquals(actual_URL, "https://financepeer.com/app/v2/dashboard");
		System.out.println(actual_URL);
	}

	@Test(priority = 2, enabled = true)
	// Verify the login from the sign up page by clicking on the sign in here link
	public void loginFromSignUpPageTest() throws Throwable {
		String actual_Url = loginPage.loginFromSignUpPage(mobileNum_row2, prop.getProperty("OTP"));
		Assert.assertEquals(actual_Url, "https://financepeer.com/app/v2/dashboard");
		System.out.println(actual_Url);
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
