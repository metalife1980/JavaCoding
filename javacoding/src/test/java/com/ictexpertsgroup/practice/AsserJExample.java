package com.ictexpertsgroup.practice;

//import static org.junit.Assert.fail;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class AsserJExample {

	@Test
	public void test() {
		int testResult1 = 5;
		int testResult2=4, testResult3 = 3;
		
		
// 
//		assertThat(testResult1).isEqualTo(5);
//		assertThat(testResult2).isLessThan(testResult1);
//		assertThat(testResult3).isBetween(testResult2, testResult1);
//		assertThat(testResult3).isLessThan(testResult1).isGreaterThan(testResult2);
//		
		
		SoftAssertions objAssertions = new SoftAssertions();
		objAssertions.assertThat(testResult1).isEqualTo(5);
		objAssertions.assertThat(testResult2).isEqualTo(4);
		objAssertions.assertThat(testResult3).isEqualTo(3);
		
//		objAssertions.assertThat(testResult2).isLessThan(testResult1);
//		objAssertions.assertThat(testResult3).isBetween(testResult2, testResult1);
//		objAssertions.assertThat(testResult3).isLessThan(testResult1).isGreaterThan(testResult2);
//		
		objAssertions.assertAll();
	}

}
