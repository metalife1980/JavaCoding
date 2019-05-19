package com.ictexpertsgroup.practice;

/*
 * This class has rating and rank store in it.
 * this will be used as lookup as part of a collection
 */

public class CreditRank {
	Integer rating;
	String rank;
	
	CreditRank(){
		
	}
	CreditRank(int rating, String rank){
		this.rating=rating;
		this.rank=rank;
	}
	
	@Override
	public String toString() {
		return "CreditRank [rating=" + rating + ", rank=" + rank + "]";
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
}
