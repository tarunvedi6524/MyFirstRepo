package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.framework.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		super("//a[contains(text(),'Forgot your password?')]");
	}
	
	//Web Elements
	private String webElementUserName = "username";
	private String webElementPassword = "password-field";
	private String webElementLoginButton = "//input[@value='Log In']";
	private String webElementForgotPasswdLink = "//a[contains(text(),'Forgot your password?')]";
	private String webElementErrorMessage = "//p[text()='Sorry, we were not able to find a user with that username and password.']";
	
	//Actions
	
	public boolean enterUsername(){
		try{
			getWaitObject().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(webElementUserName)));
			getDriver().findElement(By.id(webElementUserName)).sendKeys("tvedi");
		}
        catch (Exception e){
            System.out.println("Error in entering username");
            return false;
        }
        return true;
		
	}
	
	public boolean enterPassword(){
		try{
			
			getDriver().findElement(By.id(webElementPassword)).sendKeys("passwd");
		}
        catch (Exception e){
            System.out.println("Error in entering password");
            return false;
        }
        return true;
	}
	
	public boolean clickonLoginButton(){
		try{
			getDriver().findElement(By.xpath(webElementLoginButton)).click();
		}
        catch (Exception e){
            System.out.println("Error in clicking login button");
            return false;
        }
        return true;
	}
	
	public boolean isErrorMessageDisplayed(){
		if(getDriver().findElement(By.xpath(webElementErrorMessage)).isDisplayed()==true){
			System.out.println("Error Message Is Displayed");
			return true;
		}
		else
			System.out.println("Error Message not Displayed");
			return false;
	}
	
	

}
