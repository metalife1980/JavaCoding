package com.ictexpertsgroup.practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadTesterCyclicBarrier implements Runnable {

	public CyclicBarrier cb = new CyclicBarrier(3);
	
	@Override
	public void run() {
		System.out.println("\n\n***Inside ThreadTesterCyclicBarrier.run() before product**\n\n");
		System.out.println("No of parties waiting " + cb.getParties());
		System.out.println("Sum of product and sum = " + (Computation1.sum +	Computation2.product));
		
		// create the new threads and run computation 1 and computation 2
		Computation1 comp1 = new Computation1();
		comp1.setCb(cb);
		Computation2 comp2 = new Computation2();
		comp2.setCyclicBarrier(cb);
		Thread t1 = new Thread(comp1);
		Thread t2 = new Thread(comp2);
		t1.start();
		t2.start();
		
		try {
			cb.await();
		}catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		 // at this point = 3 
        System.out.println("Sum of product and sum = " + (Computation1.sum +  
        Computation2.product)); 
                  
        // Resetting the newBarrier 
        cb.reset();
        System.out.println("Barrier reset successful"); 
	}
	
	public static void main (String [] args) {
		ThreadTesterCyclicBarrier ttcb = new ThreadTesterCyclicBarrier();
		Thread mt = new Thread(ttcb);
		mt.start();
		System.out.println("after main thread.");
	}
}
