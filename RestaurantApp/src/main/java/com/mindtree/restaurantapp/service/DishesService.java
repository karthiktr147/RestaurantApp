package com.mindtree.restaurantapp.service;

import java.util.List;

import com.mindtree.restaurantapp.entity.Dishes;
import com.mindtree.restaurantapp.entity.Shop;

public interface DishesService {

	public Shop addDishesToShop(int shopId,List<Dishes> dishes);
	public List<Dishes> getAllDishesByShop(int shopId,String type);
	
}
