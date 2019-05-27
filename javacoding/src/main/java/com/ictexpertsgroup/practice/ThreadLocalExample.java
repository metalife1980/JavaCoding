package com.ictexpertsgroup.practice;

import java.util.concurrent.locks.Lock;

public class ThreadLocalExample {

	public static class MyRunnable  implements Runnable {
		ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("threadLocal.get() : " + threadLocal.get());
			threadLocal.set((int) (Math.random() * 100));
			System.out.println("1-After Set, Threadlocal.get() : " + threadLocal.get());
			try {
				Thread.sleep(2000);
			}catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("2-After Set, Threadlocal.get() : " + threadLocal.get());
		 
			
		}	
	}
	
	
	public static void main (String [] args) throws InterruptedException{
		MyRunnable mr = new MyRunnable();
		Thread t1 = new Thread(mr);
		Thread t2 = new Thread (mr);
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
	}

}
