package com.mindtree.restaurantapp.service.impl;

import java.util.Comparator;

import com.mindtree.restaurantapp.entity.Dishes;

public class SortByPrice implements Comparator<Dishes>{

	@Override
	public int compare(Dishes arg0, Dishes arg1) {
		
		return (int)(arg0.getPrice()-arg1.getPrice());
	}

}
