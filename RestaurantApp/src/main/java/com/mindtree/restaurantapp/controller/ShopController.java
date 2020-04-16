package com.mindtree.restaurantapp.controller;

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
import com.mindtree.restaurantapp.entity.Block;
import com.mindtree.restaurantapp.entity.Shop;
import com.mindtree.restaurantapp.exception.RestaurantAppException;
import com.mindtree.restaurantapp.service.impl.ShopServiceImpl;

@RestController
@RequestMapping("/shops")
public class ShopController {

	@Autowired
	private ShopServiceImpl service;

	@PostMapping("/addshop/{blockId}")
	public ResponseEntity<?> addShop(@RequestBody List<Shop> shops, @PathVariable int blockId)
			throws RestaurantAppException {
		Block block = null;
		
			block = service.addShopToBlock(shops, blockId);
		
		return new ResponseEntity<Block>(block, HttpStatus.OK);
	}

	@GetMapping("/getshopsbytype/{type}")
	public ResponseEntity<?> getAllShopsByType(@PathVariable String type)throws RestaurantAppException{
		List<Shop> shops = service.getAllShopsByType(type);
		return new ResponseEntity<List<Shop>>(shops,HttpStatus.OK);
	} 
	
	@GetMapping("/getshopsbyblock/{blockId}")
	public ResponseEntity<?> getAllShopsByBlock(@PathVariable int blockId)throws RestaurantAppException{
		List<Shop> shops=service.getAllShopsByBlock(blockId);
		return new ResponseEntity<List<Shop>>(shops,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}
