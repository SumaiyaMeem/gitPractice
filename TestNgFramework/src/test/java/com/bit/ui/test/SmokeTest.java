package com.bit.ui.test;

import org.testng.annotations.Test;

import DB.DbTest2;

public class SmokeTest extends BaseTest {
	@Test(groups = "ui", dataProviderClass = DbTest2.class, dataProvider = "logIn")
	public void login(Object o, Object o1) {
		System.out.println(o);
		System.out.println(01);
		
		
	}
	public void test1() {
		System.out.println("test1");
	}
	@Test(groups = "BackEnd")
	public void test2() {
		System.out.println("test2");
	}


}
