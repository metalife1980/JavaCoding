package com.ictexpertsgroup.practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
	
	public static void main (String[] args) throws InterruptedException, BrokenBarrierException {

	CyclicBarrier cb = new CyclicBarrier(3);
	Thread t1 = new Thread ( () -> {
			System.out.println("inside thread 1");
			try {
				System.out.println("inside thread 1 before sleep");
				Thread.sleep(1500);
				System.out.println("inside thread 1, after sleep - remaining parties=" + cb.getNumberWaiting());
				cb.await();
				System.out.println("inside thread 1 after await");
			} catch (InterruptedException | BrokenBarrierException e2) {
				e2.printStackTrace();
			}
			
		}
	);

Thread t2 = new Thread( () -> {
		System.out.println("inside thread 2");
		try {
			System.out.println("inside thread 2 before sleep");
			Thread.sleep(1000);
			System.out.println("inside thread 2, after sleep - remaining parties=" + cb.getNumberWaiting());
			cb.await();
			System.out.println("inside thread 2 after await");
		} catch (InterruptedException | BrokenBarrierException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
	});

	Thread t3 = new Thread (()->{
		t2.start();
		t1.start();

		System.out.println("inside thread 3");
		try {
			System.out.println("inside thread 3 before sleep");
				Thread.sleep(500);
				System.out.println("inside thread 3, after sleep - remaining parties= " + cb.getNumberWaiting());
				cb.await();
				System.out.println("inside thread 3 after await");
			} catch (InterruptedException | BrokenBarrierException et) {
				
			}
			}
		);
	t3.start();
	System.out.println("3 threads completed");
	}	
}
