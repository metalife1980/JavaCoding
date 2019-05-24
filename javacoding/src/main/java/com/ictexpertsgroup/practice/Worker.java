package com.ictexpertsgroup.practice;

import java.util.concurrent.CountDownLatch;

public class Worker extends Thread {
	
	private int delay ;
	CountDownLatch latch;
	public Worker (int delay, CountDownLatch latch, String name ){
		super(name);
		this.delay=delay;
		this.latch=latch;
	}
	
	@Override
	public void run() {
		try {
			
			System.out.println("Before Countdown and sleep");
			latch.countDown();
			Thread.sleep(delay);
			latch.countDown();
			System.out.println("After second Countdown and sleep");
			System.out.println( Thread.currentThread().getName() + " finished..");
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
