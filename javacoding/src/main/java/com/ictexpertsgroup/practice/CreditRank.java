package com.ictexpertsgroup.practice;

import java.util.Comparator;

/*
 * This class has rating and rank store in it.
 * this will be used as lookup as part of a collection
 */

public class CreditRank implements Comparable<CreditRank> {
	private Integer rating;
	private	String rank;
	
	CreditRank(){
		
	}
	CreditRank(int rating, String rank){
		this.rating=rating;
		this.rank=rank;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditRank other = (CreditRank) obj;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		return true;
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
	@Override
	public int compareTo(CreditRank o) {
		// TODO Auto-generated method stub
		return this.getRank().compareTo(((CreditRank)o).getRank());
	}
}

