package com.ictexpertsgroup.practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Computation1 implements Runnable {

	public static int sum= 0;
	
	CyclicBarrier cb;
	
	public CyclicBarrier getCb() {
		return cb;
	}

	public void setCb(CyclicBarrier cb) {
		this.cb = cb;
	}

	@Override
	public void run() {
		System.out.println("\n\n***Inside Computation 1.run() before sum**\n\n");
		// TODO Auto-generated method stub
		sum = 2+3;
		System.out.println("is barrier broken ..." + cb.isBroken());
		try {
			cb.await(3000, TimeUnit.MILLISECONDS);
			System.out.println("Number of parties waiting at this point " + cb.getNumberWaiting());
		}catch (InterruptedException | BrokenBarrierException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
