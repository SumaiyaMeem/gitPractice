package com.bit.ui.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("BM");
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod() {
	  System.out.println("AM");
  }


  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("BC");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("AC");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("BT");

  }

  @AfterTest
  public void afterTest() {
	  System.out.println("AT");

  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("BS");

  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("AS");

  }

}
