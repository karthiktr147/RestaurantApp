package com.mindtree.restaurantapp.service.impl;

import java.util.Comparator;

import com.mindtree.restaurantapp.entity.Dishes;

public class SortByPriceDesc implements Comparator<Dishes>{
	@Override
	public int compare(Dishes o1, Dishes o2) {	
		return -(int)(o1.getPrice()-o2.getPrice());
	}

}
