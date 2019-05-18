package com.ictexpertsgroup.practice;

public class CalculatorImpl implements CalculatorService {
	private int a;
	private int b;
	public CalculatorImpl() {
		// TODO Auto-generated constructor stub
	}
	CalculatorImpl(int a, int b){
		this.a=a;
		this.b=b;
	}
	@Override
	public int Add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int Subtract(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}
}
