package com.ictexpertsgroup.practice;

import java.util.function.Consumer;

public class Filter implements Consumer<Object>  {

	@Override
	public void accept(Object t) {
		Book b = (Book) t;
		if (b.getRating()>=4 ) {
			System.out.println(b);
		}
		// TODO Auto-generated method stub
		
	}

}
