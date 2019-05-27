package com.ictexpertsgroup.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorFrameWorkExample {
	
	public static void main (String [] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		for (int i=0 ; i<50; i++) {
			Runnable r = ()->{
				System.out.println(Thread.currentThread().getName() + " at work!");
				long sum =0;
				for (long n=0; n<1000000L; n++)
				{
					sum+=n;
				}
				System.out.println(Thread.currentThread().getName() + " produced result :"+ sum);
			};
			executor.execute(r);
		}
		
		executor.shutdown();
		executor.awaitTermination(1000000000L, TimeUnit.MILLISECONDS);
		System.out.println("All threads finished.");
	}
}
