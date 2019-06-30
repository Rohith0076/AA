package com.cts.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Basetest {
	
	public static WebDriver driver;
	
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}
	
	@Parameters
	@BeforeMethod
	public void openingApp(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		driver.get("www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			driver.get("www.google.com");
		}
	}
	
	@AfterMethod
	public void closingapp() {
		driver.quit();
	}

}
