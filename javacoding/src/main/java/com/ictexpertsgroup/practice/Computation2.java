package com.ictexpertsgroup.practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Computation2 implements Runnable {

	public static int product=0;
	private CyclicBarrier cb;
	public void setCyclicBarrier(CyclicBarrier cb) {
		this.cb=cb;
	}
	public CyclicBarrier getCyclicBarrier() {
		return cb;
	}
	
	@Override
	public void run() {
		System.out.println("\n\n***Inside Computation 2.run() before product**\n\n");
		product = 2*6;
		try {
			cb.await();
			System.out.println("After ");
		}catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	
}
