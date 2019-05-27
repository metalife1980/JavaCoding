package com.ictexpertsgroup.practice;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrinterQueue {
	private final Semaphore semaphore;
	private final Lock printerLock;
	private boolean freePrinters[];
	
	public PrinterQueue() {
		semaphore = new Semaphore(3);
		printerLock = new ReentrantLock();
		freePrinters = new boolean[3];
		for (int i=0; i<3; i++) {
			freePrinters[i] = true;
		}
	}
	
	private int getPrinter () {
		int foundPrinter = -1;
		try {
			printerLock.lock();
			
			for (int i=0; i< freePrinters.length; i++) {
				if (freePrinters[i]) {
					foundPrinter=i;
					freePrinters[i]=false;
					break;
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			printerLock.unlock();
		}
		return foundPrinter;
				
	}
	
	private void releasePrinter (int i) {
		printerLock.lock();
		freePrinters[i] = true;
		printerLock.unlock();
	}
	
	public void printJob (Object document) {
		try {
			semaphore.acquire();
			int assignPrinter = getPrinter();
			Long duration = (long) (Math.random()* 10000);
			System.out.println(Thread.currentThread().getName()
					+ " : Printer " + assignPrinter
					+ " : printing a job during " + (duration / 1000)
					+ " seconds ::: Time - " + new Date()		
					);
			Thread.sleep(duration);
			releasePrinter(assignPrinter);
		}catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.printf("\n**%s: The dodument has been printed (x)\n", Thread.currentThread().getName());
			semaphore.release();
		}
	}
	
}
