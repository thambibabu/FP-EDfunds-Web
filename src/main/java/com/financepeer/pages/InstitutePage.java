package com.financepeer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.financepeer.base.TestBase;
import com.financepeer.util.TestUtil;

public class InstitutePage extends TestBase {

	// Page Factory : OR
	@FindBy(xpath = "//*[text()='For Institute']")
	WebElement instituteTab;

	@FindBy(xpath = "//*[@class='instituteLeadCollectionBox']//*[@placeholder='Contact']")
	WebElement contact;

	@FindBy(xpath = "//*[@class='instituteLeadCollectionBox']//*[@placeholder='Name']")
	WebElement name;

	@FindBy(xpath = "//*[@placeholder='Institute Name']")
	WebElement instituteName;

	@FindBy(xpath = "//*[@class='instituteLeadCollectionBox']//*[@placeholder='Where did you hear about us?']")
	WebElement whereDidHearAbout;

	@FindBy(xpath = "//*[@class='instituteLeadCollectionBox']//*[@placeholder='Message..']")
	WebElement message;

	@FindBy(xpath = "//*[text()='Get in Touch']")
	WebElement getInTouchBtn;

	@FindBy(xpath = "//div[@class='webfooter']//div//div//div//div[@class='dropdown']")
	WebElement privacyAndMore;

	@FindBy(xpath = "//div[@class='webfooter']//div//div//div//a[normalize-space()='Privacy Policy']")
	WebElement privacyPolicyLink;

	@FindBy(xpath = "//div[@class='webfooter']//div//div//div//a[normalize-space()='Terms & Conditions']")
	WebElement termsAndConditionsLink;

	@FindBy(xpath = "//*[@class='instituteLeadCollectionBox']//p")
	WebElement validationMsg;

	// Initializing the page objects
	public InstitutePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String getInTouch(String contactNum) {
		instituteTab.click();
		contact.sendKeys(contactNum);
		name.sendKeys(TestUtil.randomChars(8));
		instituteName.sendKeys(TestUtil.randomChars(15));
		whereDidHearAbout.sendKeys(TestUtil.randomChars(50));
		message.sendKeys(TestUtil.randomChars(100));
		getInTouchBtn.click();

		return validationMsg.getText();
	}

	public String verifyPrivacyAndPolicyLink() throws Throwable {
		instituteTab.click();
		TestUtil.scrollIntoView(driver, privacyAndMore);
		privacyPolicyLink.click();
		return driver.getCurrentUrl();
	}

	// verify the terms and conditions link click action in the student page
	public String verifyTermsAndConditionsLink() throws Throwable {
		instituteTab.click();
		TestUtil.scrollIntoView(driver, privacyAndMore);
		termsAndConditionsLink.click();
		return driver.getCurrentUrl();
	}

}
