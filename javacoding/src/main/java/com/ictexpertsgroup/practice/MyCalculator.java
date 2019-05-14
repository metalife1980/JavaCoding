package com.ictexpertsgroup.practice;

/**
 * Hello world!
 *
 */

public class MyCalculator{
	private  Util u;
	private CalculatorService service;
	
	public Util getU() {
		return u;
	}
	public void setU(Util u) {
		this.u = u;
	}
	
	MyCalculator(){
		
	}
	
	MyCalculator(CalculatorService cal){
		this.service = cal;
	}
	
	public int addPositiveNumbers (int a, String b)  {
		if (!u.isPositiveNumber(String.valueOf(b)) || a<0 ) {
			u.printMessage("Not a positive number");
			return -1; 
		}

		return a+Integer.valueOf(b);
	}
	
	public int perform(int a, int b ) {
		return service.Add(a, b) * 2;  // any logic 
	}
	
	public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
		//Util.printMessage("Hello World");
    }
}
