package com.financepeer.util;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.financepeer.base.TestBase;

public class TestUtil extends TestBase
{

	public static long PAGE_LOAD_TIMEOUT=40;
	public static long IMPLICIT_WAIT=30;
	
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"/src/test/resources/com/financepeer/testdata/TestData_InputSheet.xlsx";
	
	
	public static void scrollIntoView(WebDriver driver, WebElement element) throws Throwable
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void explicitWait(String element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).click();
	}
	
	public static String[] getMonthYear(String monthYearVal)
	{
		return monthYearVal.split(" ");
	}
	
	
	public static void selectDOB(String exDay, String exMonth, String exYear)
	{
		if(exMonth.equals("Feb") && Integer.parseInt(exDay)>29)
		{
			System.out.println("Wrong date: "+exMonth+" : "+exDay);
			return;
		}
		
		if(Integer.parseInt(exDay)>31)
		{
			System.out.println("Wrong date: "+exMonth+" : "+exDay);
			return;
		}
		
		String monthYear = exMonth+exYear;
		System.out.println(monthYear);
		String monthYearVal = driver.findElement(By.xpath("//*[@class='ant-picker-header-view']")).getText();
		System.out.println(monthYearVal);
		
		while(!(getMonthYear(monthYearVal)[0].equals(monthYear)))
		{
			driver.findElement(By.className("ant-picker-header-prev-btn")).click();
			monthYearVal = driver.findElement(By.xpath("//*[@class='ant-picker-header-view']")).getText();
			
		}
		
		driver.findElement(By.xpath("//*[text()='"+exDay+"']")).click();
	}
	
	public static void selectDropDownValue(By locator, String value) throws Throwable {
		List<WebElement> optionsList = driver.findElements(locator);
		for (WebElement e : optionsList) {
			if (e.getText().equals(value)) {
				Thread.sleep(1000);
				e.click();
				break;
			}
		}
	}
	
	public static String randomChars(int length) {

		   return RandomStringUtils.random( length, "abcdefghijklmnopqrstuvwxyz");
	}
	
	public static String randomDigits(int length) {

		   return RandomStringUtils.random( length, "123456789");
	}
	
	public static void uploadFile(String filePath) throws Throwable {
		Robot robot=new Robot();
		robot.setAutoDelay(2000);
		
		StringSelection stringSelection=new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		robot.setAutoDelay(1000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.setAutoDelay(1000);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.setAutoDelay(1000);
		 
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
