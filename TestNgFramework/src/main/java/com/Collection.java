package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Collection {
	WebDriver dr;

	ArrayList<Integer> m1() {
		ArrayList<Integer> ar = new ArrayList<Integer>();

		ArrayList ar1 = new ArrayList();

		ar.add(7);
		ar.add(7);
		ar.add(9);
		ar.add(19);
		ar.get(2);

		Iterator<Integer> i = ar.iterator();
		while (i.hasNext()) {
			i.next();
		}
		return ar;
	}

	ArrayList<String> actValue(List<WebElement> elements, String actName) {
		ArrayList<String> ar = new ArrayList<String>();

		for (WebElement e : elements) {
			ar.add(e.getAttribute(actName));

		}
		return ar;

	}

	ArrayList<String> expValue(String[] ex) {
		ArrayList<String> a = new ArrayList<String>();
		for (String x : ex) {

			a.add(x);

		}
		return a;

	}

	void compare(ArrayList<String> a, ArrayList<String> e) {

		Iterator i = a.iterator();
		Iterator i1 = e.iterator();

		while (i.hasNext() && i1.hasNext()) {

			if (i.next().equals(i1.next())) {
				System.out.println("passed");
			} else {
				System.out.println("not passed");
			}

		}

	}

	@Test
	void test() {
		ArrayList<String> a = actValue(dr.findElements(By.id("")), "");

		String[] e1 = { "123", "321" };

		ArrayList<String> e = expValue(e1);
		compare(a, e);

	}

}
