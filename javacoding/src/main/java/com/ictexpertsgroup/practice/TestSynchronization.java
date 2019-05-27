package com.ictexpertsgroup.practice;

import javax.naming.TimeLimitExceededException;

import java.util.concurrent.*;

public class TestSynchronization {
	
	volatile static int MY_INT = 0;

	public static void testVolatile() {

		Thread vthread1 = new Thread (()->{
			int local_variable = MY_INT;
			while (local_variable<5) {
				if (local_variable!=MY_INT) {
					System.out.println("value of MY_INT = " + MY_INT + " value of local_variable = " + local_variable);
					local_variable = MY_INT;
				}
			}
		}
				);
		
		Thread vthread2 = new Thread (()-> {
			int local_variable = 0;
			while (MY_INT < 5 ) {
				MY_INT = ++local_variable;
				System.out.println("incrementing value of MY_INT by 1");
				try {
	                Thread.sleep(500);
	            } catch (InterruptedException e) { e.printStackTrace(); 
	            }
			}
			
		});
		
		vthread1.start();
		vthread2.start();
	}
	
	public static void testSynchroniztion() {
		SynchronizedWorker worker = new SynchronizedWorker();
		Thread t1 = new Thread(() -> {
			try {
				System.out.println("Inside Thread 1 scope");
				worker.add(5000, "Hello ", "Thread 1");
			} catch (InterruptedException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				System.out.println("Inside Thread 2 scope");
				worker.add(6000, "World!", "Thread 2");
			
			} catch (InterruptedException  e) {
				e.printStackTrace();
			}
		}

		);

		Thread t3 = new Thread(() -> {
			try {
				System.out.println("Inside Thread 3 scope");
				worker.synchronizedBlockFoo(6000, "Thread 3");
			} catch (InterruptedException | TimeLimitExceededException e) {
				e.printStackTrace();
			}
		}

		);

		Thread t4 = new Thread(() -> {
			try {
				System.out.println("Inside Thread 4 scope");
				worker.synchronizedBlockFoo(2000, "Thread 4");
			} catch (InterruptedException | TimeLimitExceededException e) {
				e.printStackTrace();
			}
		}

		);

		System.out.println("Before starting threads !");
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		System.out.println("After starting threads.");
	}
	
	public static void main(String[] args) {
	
		/*
		 * Following function tests the synchronization block and function 
		 */
	
		//testSynchroniztion();

		/*
		 * following code is to test the volatile keyword. 
		 */
			
		//testVolatile();
		
		
	}
}
