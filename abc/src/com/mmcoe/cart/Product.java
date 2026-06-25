package com.mmcoe.cart;

public class Product {
	private String name;
	private double price;
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Product [Name=" +name+ ", Price="+price+"]";
	}
	
	
}
