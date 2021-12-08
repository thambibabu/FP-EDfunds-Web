package com.financepeer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.financepeer.base.TestBase;
import com.financepeer.util.TestUtil;

public class ContactUs extends TestBase{

	//Page Factory : OR
	@FindBy(xpath="//*[@id='Name1']")
	WebElement name;
	
	@FindBy(xpath="//*[@id='myTopnav']//*[text()='Contact Us']")
	WebElement contactUsLink;
	
	@FindBy(xpath="//*[@id='School']")
	WebElement phone;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//*[@name='message']")
	WebElement message;
	
	@FindBy(xpath="//*[@id='selectList']")
	WebElement emiOption;
	
	@FindBy(xpath="//*[text()='Send']")
	WebElement sendBtn;
	
	
	//Initializing the Page Objects:
	public ContactUs() {
		PageFactory.initElements(driver, this);
	}
				
	//Actions:
	public void writeToUs(String phoneNumber, String emailId) {
		
		contactUsLink.click();
		name.sendKeys(TestUtil.randomChars(6)+" "+ TestUtil.randomChars(4));
		phone.sendKeys(phoneNumber);
		email.sendKeys(emailId);
		message.sendKeys(TestUtil.randomChars(150));
		sendBtn.click();
		
		
	}
	
}
