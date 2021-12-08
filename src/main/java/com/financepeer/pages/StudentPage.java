package com.financepeer.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.AppCacheStatus;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.financepeer.base.TestBase;
import com.financepeer.util.TestUtil;

public class StudentPage extends TestBase{

	
	
		//Page Factory : OR
		@FindBy(xpath="//*[@alt='Financepeer Full Logo' and @class='desktopx']")
		WebElement financepeerLogo;
		
		@FindBy(xpath="//*[@class='webCalculator']//*[@placeholder='Student Name*']")
		WebElement studentNameField;
		
		@FindBy(xpath="//*[@class='webCalculator']//*[@placeholder='Institute Name*']")
		WebElement instituteName;
		
		@FindBy(xpath="//*[@class='webCalculator']//*[@placeholder='Mobile No.*']")
		WebElement mobileNumber;
		
		@FindBy(xpath="//*[@class='webCalculator']//*[@placeholder='Email Id']")
		WebElement emaiId;
		
		@FindBy(xpath="//*[@class='webCalculator']//*[text()='Apply Now']")
		WebElement applyNowBtn;
		
		
		@FindBy(xpath="//div[@class='webfooter']//div//div//div//div[@class='dropdown']")
		WebElement privacyAndMore;
		
		@FindBy(xpath="//div[@class='webfooter']//div//div//div//a[normalize-space()='Privacy Policy']")
		WebElement privacyPolicyLink;
		
		@FindBy(xpath="//div[@class='webfooter']//div//div//div//a[normalize-space()='Terms & Conditions']")
		WebElement termsAndConditionsLink;
		
		@FindBy(xpath="//*[@class='webfooter']//*[@href='/contactUs']//p")
		WebElement contactUs;
		
		@FindBy(xpath="//*[@href='/contact/' and text()='CONTACT US']")
		WebElement contactUsPage;
		
		@FindBy(xpath="//*[contains(@aria-label,'Digit 1')]")
		WebElement OTPDigit;
		
		@FindBy(xpath = "//*[@class='MuiInputBase-root MuiInput-root']//input")
		WebElement verifyBtn;
		
	
		
		//Validations:
		@FindBy(xpath="//*[text()='Please enter all the details.']")
		WebElement plsEnterAllDetails;
		
		
		
		
		
		
		//Initializing the Page Objects:
		public StudentPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		
		//Verify the title of the financepeer home page
		public String validateHomePageTitle() {
			return driver.getTitle();
		}
		
		public String clickApplyNowWithoutDetails() {
			applyNowBtn.click();
			return plsEnterAllDetails.getText();
		}
		
		public String studentNameEnterDigits(String mobileNum, String institute, String studentName, String email ) 
		{
			mobileNumber.sendKeys(mobileNum);
			instituteName.sendKeys(institute);
			studentNameField.sendKeys(studentName);
			emaiId.sendKeys(email);
			applyNowBtn.click();
			return plsEnterAllDetails.getText();
		}
		
		public boolean applyLoanWithValidDetails(String mobileNum, String institute, String studentName, String email,
				String OTP, String expURL) throws Throwable {
			mobileNumber.sendKeys(mobileNum);
			instituteName.sendKeys(institute);
			studentNameField.sendKeys(studentName);
			emaiId.sendKeys(email);
			applyNowBtn.click();
			OTPDigit.sendKeys(OTP);
			verifyBtn.click();
			Thread.sleep(5000);
			String actualURL = driver.getCurrentUrl();
			if(actualURL.contains(expURL)) {
				System.out.println(actualURL);
				return true;
			}else {
				return false;
			}
			
		}
		
		public String verifyStudentNameWithSplChars(String mobileNum, String institute, String studentName, String email )
		{
			mobileNumber.sendKeys(mobileNum);
			instituteName.sendKeys(institute);
			studentNameField.sendKeys(studentName);
			emaiId.sendKeys(email);
			applyNowBtn.click();
			return plsEnterAllDetails.getText();
		}
		
		public String veriryStudentNameWithAllCombinations(String mobileNum, String institute, String studentName, String email ) 
		{
			mobileNumber.sendKeys(mobileNum);
			instituteName.sendKeys(institute);
			studentNameField.sendKeys(studentName);
			emaiId.sendKeys(email);
			applyNowBtn.click();
			return plsEnterAllDetails.getText();
		}
		
		//verify the contact page link in student page
		public String verifyContactUsLink() throws Throwable
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactUs);
			Thread.sleep(500); 
			contactUs.click();
			return driver.getCurrentUrl();
		}
		
		//verify the privacy policy link click action in the student page
		public String verifyPrivacyAndPolicyLink() throws Throwable
		{
			TestUtil.scrollIntoView(driver, privacyAndMore);
			privacyPolicyLink.click();
			return driver.getCurrentUrl();
		}
		
		//verify the terms and conditions link click action in the student page
		public String verifyTermsAndConditionsLink() throws Throwable
		{
			TestUtil.scrollIntoView(driver, privacyAndMore);
			termsAndConditionsLink.click();
			return driver.getCurrentUrl();		
		}
		
}
