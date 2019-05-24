package com.ictexpertsgroup.practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

	CyclicBarrier cb = new CyclicBarrier(3);
	Thread t1 = new Thread( {
		public void run() {
			System.out.println("inside thread 1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				cb.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			
		}
	}
	);

Thread t2 = new Thread( {
	public void run() {
		System.out.println("inside thread 2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
});

t1.start();
t2.start();


	System.out.println("2 threads already called");
	try {
		cb.await();
	}catch (InterruptedException | BrokenBarrierException e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	System.out.println("3 threads completed");
	
	}
