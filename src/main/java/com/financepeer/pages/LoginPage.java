package com.financepeer.pages;

import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.financepeer.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory : OR
	@FindBy(xpath = "//*[@class='login-button']")
	WebElement loginBtn;

	@FindBy(xpath = "//*[@type='number']")
	WebElement mobileNum;

	@FindBy(xpath = "//*[@id='submitnumber']")
	WebElement getOTPBtn;

	@FindBy(xpath = "//*[@class='MuiInputBase-input MuiInput-input']")
	WebElement verifyBtn;

	@FindBy(xpath = "//*[contains(text(),'Sign Up')]")
	WebElement signupLink;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginLinkInSignup;

	@FindBy(xpath = "//*[@class='login-card-container']//*[@class='input-container']//*[@name='number']")
	WebElement mobileNumFieldInLoginPage;

	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signUpBtn;

	@FindBy(xpath = "//*[@type='tel']")
	WebElement OTP_Field;

	@FindBy(xpath = "//*[@href='/app/v2/dashboard']")
	WebElement dashboardBtn;

	@FindBy(xpath = "//*[text()='Verify']")
	WebElement verify;
	
	@FindBy(xpath="//*[contains(@aria-label,'Digit 1')]")
	WebElement OTPDigit;

	@FindBy(xpath="//*[@class='otp-container']//input")
	WebElement OTPInLoginPage;
	
	// Initializing the page objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	// Verify the login from the student home page
	public String loginFromStudentPage(String mobileNumber, String OTP) throws Throwable {
		loginBtn.click();
		thread();
		mobileNum.sendKeys(mobileNumber);
		getOTPBtn.click();
		OTPDigit.sendKeys(OTP);
		Thread.sleep(1000);
		verifyBtn.click();
		Thread.sleep(5000);
		return driver.getCurrentUrl();

	}

	// Verify the login from the sign up page by clicking on the sign in here link
	public String loginFromSignUpPage(String mobileNum, String OTP) throws Throwable {
		loginBtn.click();
		signupLink.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		String parentUrl = it.next();
		System.out.println("parent window: " + parentUrl);

		String childWindow = it.next();
		System.out.println("child window: " + childWindow);

		driver.switchTo().window(childWindow);
		loginLinkInSignup.click();
		mobileNumFieldInLoginPage.sendKeys(mobileNum);
		loginLinkInSignup.click();
		OTPInLoginPage.sendKeys(OTP);
		verify.click();
		Thread.sleep(3000);
		return driver.getCurrentUrl();
	}

}
