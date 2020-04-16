package com.mindtree.restaurantapp.service;

import java.util.List;



import com.mindtree.restaurantapp.entity.Block;
import com.mindtree.restaurantapp.entity.Shop;
import com.mindtree.restaurantapp.exception.service.RestaurantAppServiceexception;

public interface ShopService {

	public Block addShopToBlock(List<Shop> shops, int blockId) throws  RestaurantAppServiceexception;
	
	public List<Shop> getAllShopsByType(String type);
	
	public List<Shop> getAllShopsByBlock(int blockId);

}
