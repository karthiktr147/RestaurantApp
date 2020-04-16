package com.mindtree.restaurantapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.restaurantapp.entity.Dishes;
import com.mindtree.restaurantapp.entity.Shop;
import com.mindtree.restaurantapp.repository.DishesRepository;
import com.mindtree.restaurantapp.repository.ShopRepository;
import com.mindtree.restaurantapp.service.DishesService;

@Service
public class DishesServiceImpl implements DishesService {

	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private DishesRepository dishesRepository;
	
	@Override
	public Shop addDishesToShop(int shopId, List<Dishes> dishes) {
		
		Shop shop= shopRepository.findById(shopId).orElse(null);
		if(shop.getRating()>4.5) {
			for(Dishes d:dishes) {
				d.setPrice(d.getPrice()-(d.getPrice()*0.1));
				d.setShops(shop);
			}
			shop.setDish(dishes);
			shopRepository.save(shop);
		}else if(shop.getRating()>3.5&&shop.getRating()<=4.5) {
			for(Dishes d:dishes) {
				d.setPrice(d.getPrice()-(d.getPrice()*0.05));
				d.setShops(shop);
			}
			shop.setDish(dishes);
			shopRepository.save(shop);
		}else if(shop.getRating()>2.5&&shop.getRating()<=3.5) {
			for(Dishes d:dishes) {
				d.setPrice(d.getPrice()-(d.getPrice()*0.02));
				d.setShops(shop);
			}
			shop.setDish(dishes);
			shopRepository.save(shop);
		}
		
		return shop;
	}

	@Override
	public List<Dishes> getAllDishesByShop(int shopId, String type) {

		List<Dishes> dishes=dishesRepository.findAll();
		List<Dishes> dishes1=new ArrayList<Dishes>();
		for(Dishes d: dishes) {
			if(d.getShops().getShopId()==shopId) {
				if(d.getType().contains(type)) {
					dishes1.add(d);
				}
			}
		}
		return dishes1;
	}

}
