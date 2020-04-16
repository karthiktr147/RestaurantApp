package com.mindtree.restaurantapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Shop implements Comparable<Shop> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shopId;

	private String shopName;

	private String type;

	private float rating;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Block blocks;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "shops")
	private List<Dishes> dish = new ArrayList<Dishes>();

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Block getBlocks() {
		return blocks;
	}

	public void setBlocks(Block blocks) {
		this.blocks = blocks;
	}

	public List<Dishes> getDish() {
		return dish;
	}

	public void setDish(List<Dishes> dish) {
		this.dish = dish;
	}

	public Shop(int shopId, String shopName, String type, float rating, Block blocks, List<Dishes> dish) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.type = type;
		this.rating = rating;
		this.blocks = blocks;
		this.dish = dish;
	}

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName + ", type=" + type + ", rating=" + rating
				+ ", blocks=" + blocks + ", dish=" + dish + "]";
	}

	@Override
	public int compareTo(Shop o) {
		return (int) (o.getRating()-this.getRating());
		
	}

	

}
