package com.ictexpertsgroup.practice;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.Test;
/*
 * This test is written to test spy functionality of mockito framework.
 * spy functionality push the function to perform something forcefully.
 * for example whatever is the logic, but return '8' in all cases.
 * so in this case function will return only 8 and all other logic will be ignores.
 */
public class TestMockButter {

	
	@Test
	public void test() {
//		CalculatorService service = mock(CalculatorService.class);

//		CalculatorService service = new CalculatorImpl();
		
		CalculatorService serv2 = spy(CalculatorImpl.class);
		
		when (serv2.Add(anyInt(), anyInt())).thenReturn(8);
		
		MyCalculator mc = new MyCalculator(serv2);
		assertEquals(16, mc.perform(5, 6));

		//assertEquals(5, mc.subtract(6, 1));

		
		 
	}

}
