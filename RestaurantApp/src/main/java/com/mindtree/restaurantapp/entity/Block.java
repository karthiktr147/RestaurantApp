package com.mindtree.restaurantapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "block")
public class Block {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blockId;

	private String blockName;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "blocks")
	private List<Shop> shops = new ArrayList<Shop>();

	public int getBlockId() {
		return blockId;
	}

	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}

	@Override
	public String toString() {
		return "Block [blockId=" + blockId + ", blockName=" + blockName + ", shops=" + shops + "]";
	}

	public Block(int blockId, String blockName, List<Shop> shops) {
		super();
		this.blockId = blockId;
		this.blockName = blockName;
		this.shops = shops;
	}

	public Block() {
		super();
		// TODO Auto-generated constructor stub
	}

}
