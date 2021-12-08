package com.financepeer.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.financepeer.base.TestBase;

public class SignUpPage extends TestBase{

	
	//Page Factory : Object repository(OR)
	@FindBy(xpath="//img[contains(@src,'user_icon.png')]")
	WebElement userIcon;
	
	@FindBy(xpath="//*[text()='Sign Up']")
	WebElement SignUp;
	
	@FindBy(xpath="//ul[@class='right hide-on-med-and-down']//*[contains(text(),'SIGN UP')]")
	WebElement singUpPage;
	
	
	
	
	
	
	
	
	//Initializing the Page Objects:
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	//Check the sign up link is there or not in the login screen
	public boolean verifySignUpLinkInLoginPopup() throws Throwable {
		userIcon.click();
		thread();
		return SignUp.isDisplayed();
		
	}
	
	//Verify the click action of sign up link in the login screen 
	public String verifySignUpLinkClickInLogin() throws Throwable
	{
		userIcon.click();
		SignUp.click();
		thread();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parentUrl = it.next();
		System.out.println("parent window: "+parentUrl);
		
		String childWindow = it.next();
		System.out.println("child window: "+childWindow);
		
		driver.switchTo().window(childWindow);
		
		return driver.getCurrentUrl();
		
		
	}
	
	
	
	
	
	
}
