package com.ictexpertsgroup.practice;

/**
 * Hello world!
 *
 */
public class App{
	private  Util u;
	
	public Util getU() {
		return u;
	}
	public void setU(Util u) {
		this.u = u;
	}
	
	public int addPositiveNumbers (int a, String b)  {
		if (!u.isPositiveNumber(String.valueOf(b))) {
			u.printMessage("Not a positive number");
			return -1; 
		}
		
		return a+Integer.valueOf(b);
	}
	public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
		//Util.printMessage("Hello World");
    }
}
