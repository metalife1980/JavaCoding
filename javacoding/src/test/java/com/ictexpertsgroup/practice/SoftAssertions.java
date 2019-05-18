package com.ictexpertsgroup.practice;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {

	@Test
	public void test() {

		int testResult1=1, testResult2=5;
		SoftAssert assertObj = new SoftAssert();
		
		assertObj.assertEquals(testResult1, 1);
		assertObj.assertEquals(testResult2, 5);
		
		assertObj.assertAll();

	}

}
