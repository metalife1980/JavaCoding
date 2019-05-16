package com.ictexpertsgroup.practice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private MyCalculator a=null;
	private Util u=null;
	
	CalculatorService service = new CalculatorService() {
		
		@Override
		public int Add(int a, int b) {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
	@Before
	public void setup() {
    	a = new MyCalculator(service);
    	u = new Util();
    	a.setU(u);
		
	}
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAddPositiveNumbers() {
    	/*
    	 * addPositive method returns -1 in below cases
    	 * if the value of parameters less than 0
    	 * if the value of second parameter is not a number
    	 */
  
    assertTrue(a.addPositiveNumbers(8, "2")>=0?true:false);  
    }
    @Test
    public void testAddPositiveNumberForNegative()
    {
	  	assertEquals(-1, a.addPositiveNumbers(-25, "-12")); 
    }
    
    @Test
    public void testAddPositiveNumberForString()
    {
    	assertEquals(-1, a.addPositiveNumbers(11, "b"));
    }
    
    @Test 
    /*
     * Following method is written to the method using fake object of Calculator Service created above.
     */
    public void testCalculatorService() {  
    	
    	assertEquals(0, a.perform(5, 5) );
    }
}
