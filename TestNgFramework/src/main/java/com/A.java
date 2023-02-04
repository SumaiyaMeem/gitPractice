package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import org.testng.annotations.Test;

@Test
public class A {

	public void m1() {
		ArrayList a = new ArrayList();
		a.add("chicken");
		a.add("tiger");
		a.add("dag");
		Collections.sort(a, new B());
		
//		int x[]= {2,2,3,3,5,7};
//		HashSet h = new HashSet();
//		for(int b : x) {
//			if(h.add(a)==false) {
//				System.out.println(a + "is duplicate" );
//			}
//			
//		}

	}

}

class B implements Comparator {

	public int compare(Object o, Object o1) {

		if (o.toString().length() > o1.toString().length()) {
			return 1;
		} else if (o.toString().length() < o1.toString().length()) {
			return -1;
		} else {
			return 0;

		}

	}

}
