package com.ictexpertsgroup.practice;

//import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;





public class HamcrestTest {

	
	@Test
	public void test() {
		List <Integer> score = new ArrayList<Integer>();
		score.add(10);
		score.add(20);
		score.add(25);
		score.add(35);
		
		assertThat(score, hasItem(20));
		assertThat(score,	hasSize(4));
		assertThat("myValue", allOf(startsWith("my"), containsString("Val")));
		
		assertThat(score, everyItem(greaterThan(5)));
		
		Integer [] arr = {1,2,3};
		
		assertThat(arr, arrayWithSize(3));
	}
	
	@Test
	public void classHasSummeryProperty() {
		ToDo objTodo = new ToDo(1, "Interview", "I have an interview as Java Developer @2.00PM");
		
		assertThat(objTodo, hasProperty("summary"));
	}
	
	@Test
	public void classHasPropertyValue() {
		ToDo objToDo = new ToDo(1, "Interview", "I have an inteview as Business Analyst at Acadia Unbiversity");
		
		assertThat(objToDo, hasProperty("summary", equalTo("Interview")));
	}
	
	@Test
	public void objectHasSameProperties () {

		ToDo todo1 = new ToDo(1, "Learn Hamcrest", "Important");
		ToDo todo2 = new ToDo(1, "Learn Hamcrest", "Important");

	    assertThat(todo1, samePropertyValuesAs(todo2));
	}

}
