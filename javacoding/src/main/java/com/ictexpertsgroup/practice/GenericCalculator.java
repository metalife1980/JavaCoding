package com.ictexpertsgroup.practice;

/*
 * this class is written to practice java generics generics mthods, generic class
 */

public class GenericCalculator {
	
	public <T> T add (T n1, T n2){
		if (n1 == null || n2 == null)
			return null;
		T r;
		if(n1 instanceof String && n2 instanceof String) {
			r =  (T) new String(n1.toString()+n2.toString()); 
		} else if (n1 instanceof Integer && n2 instanceof Integer) {
			r =  (T) new Integer (Integer.parseInt(n1.toString()) + Integer.parseInt(n2.toString()));
		}else { //consider and treat them as double 
			r =  (T) new Double (Double.parseDouble(n1.toString()) + Double.parseDouble(n2.toString()));
		}
		return r;
	}
	
	
/*
 * 	following method is to practice bounded type parameters.
 *  only those type of parameters are allowed who's class is extended from "comparable" or has implementation of 
 *  comparable. 
 *  this comparable is just an example, here you can mention Number or any other class.
 */

	public <T extends Comparable<T>> T max (T n1, T n2) {
		T m=n1;
		if (m.compareTo(n2)<0) {
			m = n2;
		}
		return null;
	}
}
