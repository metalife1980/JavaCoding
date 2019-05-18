package com.ictexpertsgroup.practice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class TestCalculatorService {
	
	MyCalculator mc = null;
	
	/*
	 * Method 1: 
	 * you can create the mock object of type Calculator Service by following way or use @Mock annotation and @Rule annotation to tell 
	 * Mockito that it is working together with Junit
	 * 
	*/
	//CalculatorService service = mock(CalculatorService.class); // we
	
	/*
	 * Method 2:
	 * Create Mock objects by annotations 
	 */
	@Mock
	CalculatorService service;
	
	@Rule public MockitoRule rule = MockitoJUnit.rule();
	
	/*
	 * End of method 2 
	 */
	
	
	@Before
	public void setup() {
		mc = new MyCalculator(service);
	}
	
	@Test
	public void testCalculatorService() {
		/*
		 * when is the mockito static function that can be called 
		 * to set the expected hard coded result based on any spcific call like below e are passing 5, 5 values 
		 * in parameter.
		 */
		//when(service.Add(5, 5)).thenReturn(10);
		assertEquals(20, mc.perform(5, 5));
		/*
		 * verify is the mockito static function that can be called 
		 * to check if mock object method is ivoked inside the class method where it wanted.
		 */
		verify(service).Add(5, 5);  
	}

}
