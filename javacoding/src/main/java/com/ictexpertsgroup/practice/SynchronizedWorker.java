package com.ictexpertsgroup.practice;


import java.util.ArrayList;
import java.util.List;

import javax.naming.TimeLimitExceededException;

public class SynchronizedWorker {
	private List <String> strList = new ArrayList<>();

	public List<String> getStrList() {
		return strList;
	}

	public void setStrList(List<String> strList) {
		this.strList = strList;
	}
	
	public synchronized  boolean add(int delay, String val, String modifiedBy) throws InterruptedException {
		
		System.out.println(" ** " + modifiedBy + " -> working");
		Thread.sleep(delay);
		this.strList.add(val);
		System.out.println("Modified by : " + modifiedBy);
		return true;
	}
	
	public void synchronizedBlockFoo(int delay, String threadName) throws InterruptedException, TimeLimitExceededException{
		System.out.println(threadName + " : inside synchronizedBlockFoo)");
		synchronized (this) {
			System.out.println("Blockd by : " + threadName);
			Thread.sleep(delay);
		}
		System.out.println(threadName + " Finished his work!");
	}

}
