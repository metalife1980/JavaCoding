package com.ictexpertsgroup.practice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import java.util.concurrent.Future;
import java.util.ArrayList;

public class TestCallableFutures {
	public static final int NTHREADS=10;
	public static void main (String [] args)  {
		ExecutorService executor = Executors.newFixedThreadPool	(NTHREADS);
		List <Future <Long>> futureList =  new ArrayList <Future<Long>>();
		
		for (int i=0; i<20; i++) {
			MyCallable worker = new MyCallable();
			Future<Long> result =  executor.submit(worker);
			futureList.add(result);
		}
		
		Long sumOfAllResults = 0l;
		System.out.println("List Size : " + futureList.size());
		
		// now reterieve the future results.
		
		for (Future <Long> future : futureList ) {
			try {
				System.out.print(future.get() + ",");
				sumOfAllResults+=future.get();
				
			}catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n\nAfter fetching future list, result is = " + sumOfAllResults);
		executor.shutdown();
		System.out.println(executor.isShutdown());
	}
}
