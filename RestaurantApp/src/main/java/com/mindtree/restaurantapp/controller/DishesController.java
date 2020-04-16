package com.mindtree.restaurantapp.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.restaurantapp.entity.Dishes;
import com.mindtree.restaurantapp.entity.Shop;
import com.mindtree.restaurantapp.exception.RestaurantAppException;
import com.mindtree.restaurantapp.service.DishesService;
import com.mindtree.restaurantapp.service.impl.SortByPrice;
import com.mindtree.restaurantapp.service.impl.SortByPriceDesc;

@RestController
@RequestMapping("/dishes")
public class DishesController {
	
	@Autowired
	private DishesService dishesService;
	
	@PostMapping("/adddishes/{shopId}")
	public ResponseEntity<?> addDishesToShop(@PathVariable int shopId,@RequestBody List<Dishes> dishes)throws RestaurantAppException{
		Shop shop=dishesService.addDishesToShop(shopId, dishes);
		return new ResponseEntity<Shop>(shop,HttpStatus.OK);
	}
	
	@GetMapping("/getdishesbyshop/{shopId}/{type}")
	public ResponseEntity<?> getAllDishesByshopAndTypeasc(@PathVariable int shopId,@PathVariable String type)throws RestaurantAppException{
		List<Dishes> dishes= dishesService.getAllDishesByShop(shopId, type);
		Collections.sort(dishes, new SortByPrice());
		return new ResponseEntity<List<Dishes>>(dishes,HttpStatus.OK);
	}
	@GetMapping("/getdishesbyshopdesc/{shopId}/{type}")
	public ResponseEntity<?> getAllDishesByshopAndTypedesc(@PathVariable int shopId,@PathVariable String type)throws RestaurantAppException{
		List<Dishes> dishes= dishesService.getAllDishesByShop(shopId, type);
		Collections.sort(dishes, new SortByPriceDesc());
		return new ResponseEntity<List<Dishes>>(dishes,HttpStatus.OK);
	}
	

}
