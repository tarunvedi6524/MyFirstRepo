package com.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	private static WebDriver driver;
	private static WebDriverWait wait;
	private String PageIdentifier;
	
    public BaseClass(String pageIdentifier) {
        this.PageIdentifier = pageIdentifier;
    }
    
    public static WebDriver getDriver(){
    	if(driver != null){
    		return driver;
    	} else
    		System.out.println("Driver is null");
    		return null;
    }
    
    public static WebDriverWait getWaitObject(){
    	if(wait != null){
    		return wait;
    	} else
    		wait = new WebDriverWait(driver,10);
    		//System.out.println("Wait object is null");
    		return wait;
    }
    
    public boolean isPageDisplayed(){
    	boolean bstatus = false;
    	try{
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		bstatus = driver.findElement(By.xpath(PageIdentifier)).isEnabled();
    	} catch(Exception e){
    		e.printStackTrace();
    		System.out.println("Page Not Displayed");
    		return false;
    	}
    	return bstatus;
    }
    
    @BeforeMethod
    protected void beforeEveryTest(){
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tarun\\workspace\\Automation_Task\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	System.out.println("Launching URL: https://viewer-dev.leverton.ai/login/auth");
    	driver.get("https://viewer-dev.leverton.ai/login/auth");
    }
    
    @AfterMethod
    protected void closeBrowsers(){
    	driver.close();
    }
    
    

}
