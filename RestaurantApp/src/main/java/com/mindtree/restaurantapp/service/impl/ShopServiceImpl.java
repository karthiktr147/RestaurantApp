package com.mindtree.restaurantapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.restaurantapp.entity.Block;
import com.mindtree.restaurantapp.entity.Shop;
import com.mindtree.restaurantapp.exception.service.RestaurantAppServiceexception;
import com.mindtree.restaurantapp.exception.service.ShopNotFoundException;
import com.mindtree.restaurantapp.repository.BlockRepository;
import com.mindtree.restaurantapp.repository.ShopRepository;
import com.mindtree.restaurantapp.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	public BlockRepository blockRepository;
	@Autowired
	private ShopRepository shopRepository;
	
	@Override
	public Block addShopToBlock(List<Shop> shops, int blockId) throws RestaurantAppServiceexception {

		Block block = blockRepository.findById(blockId).orElseThrow(() -> new ShopNotFoundException("There is no such shop"));
		if (block != null) {

			for (Shop shop : shops) {
				shop.setBlocks(block);
			}

			block.setShops(shops);

			blockRepository.save(block);
		}
		return block;

	}


	@Override
	public List<Shop> getAllShopsByType(String type) {
		
		List<Shop> shops = shopRepository.findAll();
//		Shop shop=shopRepository.findByType(type);
		List<Shop> shops1=new ArrayList<Shop>();
		for(Shop s:shops) {
			if(s.getType().contains(type)) {
				shops1.add(s);
			}
		}
		
		return shops1;
	}


	@Override
	public List<Shop> getAllShopsByBlock(int blockId) {

		List<Shop> shops= shopRepository.findAll();
		List<Shop> shops1=new ArrayList<Shop>();
		for(Shop s:shops) {
			if(s.getBlocks().getBlockId()==blockId) {
				shops1.add(s);
			}
		}
		return shops1;
	}
}
