package com.mmcoe.cart;

public final class CartFactory {
	private CartFactory() {
		
	}
	public static Shopping NewCart() {
		return new ShoppingCart();
	}
}
