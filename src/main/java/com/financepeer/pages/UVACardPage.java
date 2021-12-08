package com.financepeer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.financepeer.base.TestBase;
import com.financepeer.util.TestUtil;

public class UVACardPage extends TestBase{

		//Page Factory : OR
		@FindBy(xpath="//*[text()='More Services']")
		WebElement moreServices;
		
		@FindBy(xpath="//*[@href='/UVA-Card']")
		WebElement uvaCard;
	
		@FindBy(xpath="//*[@id='Phone_fname']")
		WebElement phoneNums;
		
		@FindBy(xpath="//*[@id='Name_fname']")
		WebElement name;
		
		@FindBy(xpath="//button//*[text()='I’m interested!']")
		WebElement imIntrested_Btn;
		
		@FindBy(xpath="//div[@class='webfooter']//div//div//div//div[@class='dropdown']")
		WebElement privacyAndMore;
		
		@FindBy(xpath="//div[@class='webfooter']//div//div//div//a[normalize-space()='Privacy Policy']")
		WebElement privacyPolicyLink;
		
		@FindBy(xpath="//div[@class='webfooter']//div//div//div//a[normalize-space()='Terms & Conditions']")
		WebElement termsAndConditionsLink;
		
		@FindBy(xpath="//*[@class='Rectangle-Copy-42-kids']//p[@style]")
		WebElement validationMsg;
		
		//Initializing the page objects
		public UVACardPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public String joinTheTrend(String phoneNumber) {
			
			moreServices.click();
			uvaCard.click();
			phoneNums.sendKeys(phoneNumber);
			name.sendKeys(TestUtil.randomChars(8));
			imIntrested_Btn.click();
			return validationMsg.getText();
		}
		
		public String verifyPrivacyAndPolicyLink() throws Throwable
		{
			moreServices.click();
			uvaCard.click();
			TestUtil.scrollIntoView(driver, privacyAndMore);
			privacyPolicyLink.click();
			return driver.getCurrentUrl();
		}
		
		//verify the terms and conditions link click action in the student page
		public String verifyTermsAndConditionsLink() throws Throwable
		{
			moreServices.click();
			uvaCard.click();
			TestUtil.scrollIntoView(driver, privacyAndMore);
			termsAndConditionsLink.click();
			return driver.getCurrentUrl();		
		}
		
		
}
