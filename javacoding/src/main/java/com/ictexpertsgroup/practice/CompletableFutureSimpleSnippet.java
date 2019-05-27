package com.ictexpertsgroup.practice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSimpleSnippet {

	public static void main (String [] args) {
		testCompletableFuture();
		testThenApplyCompletableFuture();
	}

	private static void testCompletableFuture() {
		long started = System.currentTimeMillis();
		System.out.println("testCompletableFuture() " + started);
		CompletableFuture<Integer> futureCount = createCompletableFuture();
		System.out.println("Took " + (started - System.currentTimeMillis()) + " millseconds");
		try {
			int count = futureCount.get();
			System.out.println("CompletableFuture Took " + (started - System.currentTimeMillis()) + " millseconds");
			System.out.println(" Result "  + count);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private static void testThenApplyCompletableFuture() {
		
		long started = System.currentTimeMillis();
		System.out.println("testThenApplyCompletableFuture() " + started);
		CompletableFuture<String> data = createCompletableFuture().thenApply(
				(futureCount) -> futureCount * 10).thenApply(transformedVal -> "Finally creates a string result : " + transformedVal);
		
		try {
			System.out.println(data.get());
		}catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}
	private static CompletableFuture<Integer>  createCompletableFuture(){
		CompletableFuture <Integer> futureCount = CompletableFuture.supplyAsync(
				()->{
					try {
						Thread.sleep(5000);
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
					return 20;
				}
				);
		return futureCount;
		
	}
}
