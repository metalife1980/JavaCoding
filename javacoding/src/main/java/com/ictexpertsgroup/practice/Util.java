package com.ictexpertsgroup.practice;

public class Util {
	public void printMessage(String str) {
		System.out.println(str);
	}
	
	public boolean isPositiveNumber(String str) {
		Integer i;
		try {
			i = Integer.parseInt(str);
		
		} catch (Exception e) {
			printMessage(e.toString());
			return false;
		}
		//if (i<0) 
		return i<0?false:true; 
	}
}
