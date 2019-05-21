package com.ictexpertsgroup.practice;

@FunctionalInterface
public interface FilterFunctionalInterface {

	public boolean checkKeyWord(String str);
 	public default boolean evaluateKeyWord(String str) {
// 		if ()
		return str.contains("streams");
	} 
}
