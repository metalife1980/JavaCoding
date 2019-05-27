package com.ictexpertsgroup.practice;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long>{

	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		long sum =0l;
		for (long i =0; i<100L; i++) {
			sum+=i;
		}
		Thread.sleep(2000);
		return sum;
	}

}
