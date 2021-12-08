package com.financepeer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.financepeer.base.TestBase;

public class Edinfinity extends TestBase {

	// Page Factory : OR
	@FindBy(xpath = "//*[@alt='Financepeer Full Logo' and @class='desktopx']")
	WebElement financepeerLogo;

	@FindBy(xpath = "//*[text()='Kids Curiosity']")
	WebElement kidsCuriosity;

	@FindBy(xpath = "//*[text()='More Services']")
	WebElement moreServices;

	@FindBy(xpath = "//*[text()='EDinfinity']")
	WebElement edinfinity;

	@FindBy(xpath = "//*[@id='fname']")
	WebElement fullName;

	@FindBy(xpath = "//*[@id='emailId']")
	WebElement emailId;

	@FindBy(xpath = "//*[@id='class']")
	WebElement classNames;

	@FindBy(xpath = "//*[@id='pincode']")
	WebElement pincode;

	@FindBy(xpath = "//*[@id='addressOne']")
	WebElement addressOne;

	@FindBy(xpath = "//*[@id='addressTwo']")
	WebElement addressTwo;

	@FindBy(xpath = "//*[@id='addressThree']")
	WebElement addressThree;

	@FindBy(xpath = "//*[@id='city']")
	WebElement city;

	@FindBy(xpath = "//*[@id='state']")
	WebElement state;

	@FindBy(xpath = "//*[@type='number']")
	WebElement mobileNum;

	@FindBy(xpath = "//*[@id='submitnumber']")
	WebElement getOTPBtn;

	@FindBy(xpath = "//*[@class='MuiInputBase-input MuiInput-input']")
	WebElement verifyBtn;

	// Initializing the Page Objects:
	public Edinfinity() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public void freeCourseTest(String mobileNumber) {
		moreServices.click();
		edinfinity.click();
		kidsCuriosity.click();

		fullName.click();
		mobileNum.sendKeys(mobileNumber);
		// fullName.sendKeys(TestUtil.randomChars(8));

	}

}
