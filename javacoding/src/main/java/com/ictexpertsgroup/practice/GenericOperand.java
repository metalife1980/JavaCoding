package com.ictexpertsgroup.practice;

/*
 * this class is written to practice java generic classes
 * this class can take any type e.g. string, Integer, Double etc.
 */
public class GenericOperand <T>{
	private T op;

	public T getOp() {
		return op;
	}

	public void setOp(T op) {
		this.op = op;
	}
	
	public String toString() {
		System.out.println("toString is called");
		System.out.println(op.toString());
		
		return (String)op.toString();
	}
}