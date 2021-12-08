package com.financepeer.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	static WebDriver driver;
	public static void main(String[]args) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://impactp2p.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='SIGN IN']")).click();
		driver.findElement(By.id("email")).sendKeys("waterfinance");
		driver.findElement(By.id("password")).sendKeys("test1234");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.xpath("//*[text()='Invest Now']")).click();
		driver.findElement(By.xpath("//*[text()='View All Lenders']")).click();
		
		
	}
	
	
	public static void selectDate(String exDay, String exMonth, String exYear) throws Throwable
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
		
		//to select month
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'picker__select--month')]//option"));
		System.out.println(list.size());
		WebElement month = driver.findElement(By.xpath("//*[text()='"+exMonth+"']"));
		
		for(int i=0; i<list.size();i++)
		{
			if(list.get(i).equals(month))
			{
				Thread.sleep(2000);
				list.get(i).click();
			}
		}
		
		Thread.sleep(3000);
		//to select year
		driver.findElement(By.xpath("//*[contains(@class,'picker__select--year')]")).click();
		List<WebElement> yearList = driver.findElements(By.xpath("//*[contains(@class,'picker__select--year')]//option"));
		System.out.println(yearList.size());
		WebElement year = driver.findElement(By.xpath("//*[text()='"+exYear+"']"));
		
		for(int i=0; i<yearList.size();i++)
		{
			if(yearList.get(i).equals(year))
			{
				Thread.sleep(2000);
				yearList.get(i).click();
			}
		}
		
		//to select day
		List<WebElement> dayslist = driver.findElements(By.xpath("//*[contains(@class,'picker__day picker__day')]"));
		System.out.println(dayslist.size());
		WebElement day = driver.findElement(By.xpath("//*[text()='"+exDay+"']"));
		
		for(int i=0; i<dayslist.size();i++)
		{
			if(dayslist.get(i).equals(day))
			{
				Thread.sleep(2000);
				dayslist.get(i).click();
			}
		}
		
	
	}
	
	
}
