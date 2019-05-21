package com.ictexpertsgroup.practice;

import java.util.function.Predicate;

public class PredicateImpl<String> implements Predicate<String> {

	@Override
	public boolean test(String t) {
		// TODO Auto-generated method stub
		return t.toString().contains("streams");
	}
}
