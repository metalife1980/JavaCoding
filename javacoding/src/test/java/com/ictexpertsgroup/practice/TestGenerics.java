package com.ictexpertsgroup.practice;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestGenerics {

	private GenericCalculator gc=null;
	@Before
	public void setup() {
		gc = new GenericCalculator();
	}
	
	@Test
	public void test() {
		GenericOperand<String> strObj1 = new GenericOperand<String>();
		GenericOperand<String> strObj2 = new GenericOperand<String>();
		
		strObj1.setOp("Hello ");
		strObj2.setOp("World");
		assertEquals("Check the correct answer", "Hello World", gc.add(strObj1.getOp(), strObj2.getOp()));

		GenericOperand<Integer> no1 = new GenericOperand<Integer>();
		GenericOperand<Integer> no2 = new GenericOperand<Integer>();
		GenericOperand<Integer> r = new GenericOperand<Integer>();
		
		no1.setOp(5);
		no2.setOp(6);
		r.setOp(gc.add(no1.getOp(), no2.getOp()));
		
		
		assertThat(r.getOp(), equalTo(11) );
		
		
	}

}
