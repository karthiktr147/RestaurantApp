package com.mindtree.restaurantapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.restaurantapp.entity.Block;
import com.mindtree.restaurantapp.repository.BlockRepository;
import com.mindtree.restaurantapp.service.BlockService;

@Service
public class BlockServiceImpl implements BlockService {
	
	
	@Autowired
	public BlockRepository blockRepository;

	public Block addblock(Block block) {
		Block block1=null;
		block1 = blockRepository.save(block);
		return block1;
	}

}
