package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.BaseClass;
import com.pages.LoginPage;

public class Test_Class extends BaseClass {
  public Test_Class() {
		super("");
		// TODO Auto-generated constructor stub
	}

//Test Cases
	@Test(priority = 1)
	public void validateErroMessageOnInvalidLogin(){
		LoginPage login = new LoginPage();
		Assert.assertTrue(login.isPageDisplayed());
		Assert.assertTrue(login.enterUsername());
		Assert.assertTrue(login.enterPassword());
		Assert.assertTrue(login.clickonLoginButton());
		Assert.assertTrue(login.isErrorMessageDisplayed());
		
		
	}
}
