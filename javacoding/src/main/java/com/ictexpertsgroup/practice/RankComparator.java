package com.ictexpertsgroup.practice;

import java.util.Comparator;

public class RankComparator implements Comparator<CreditRank>{

	@Override
	public int compare(CreditRank o1, CreditRank o2) {
		// TODO Auto-generated method stub
		return ((CreditRank)o1).getRating().compareTo(((CreditRank)o2).getRating());
	}
	
}