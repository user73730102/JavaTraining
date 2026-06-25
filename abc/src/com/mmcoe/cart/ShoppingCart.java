package com.mmcoe.cart;

public class ShoppingCart implements Shopping {
	private Product[] items;
	private double total;
	private int count;
	
	public ShoppingCart() {
		items = new Product[5];
	}
	
	public void addtocart  (Product p) throws CartFullException {
		if (count < items.length) {
			items[count++] = p;
			total += p.getPrice();
		} 
		else {
			throw new CartFullException("Cart is full");
		}
	}

	public void checkout(){
		System.out.println("Total Amount: " + total);
			for (int i = 0; i < count; i++) {
				System.out.println(items[i]);
				items[i]=null;
		}
		count = 0;
		total = 0.0;
	}
	
}
