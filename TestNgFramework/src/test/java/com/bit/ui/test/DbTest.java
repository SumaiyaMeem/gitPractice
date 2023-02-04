package com.bit.ui.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DB.DataDrivenTest;

public class DbTest {
	
	//it helps to perform data driven testing
	@Test(dataProviderClass= DataDrivenTest.class, dataProvider = "logIn")
	  public void f(Integer n, String s) {
	  }

}
