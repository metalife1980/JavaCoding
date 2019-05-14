package com.ictexpertsgroup.practice;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAddPositiveNumbers() {
    	App a = new App();
    	Util u = new Util();
    	a.setU(u);
    assertTrue(a.addPositiveNumbers(10, "-2")>=0?true:false);
    }
    /*  public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    */
}
