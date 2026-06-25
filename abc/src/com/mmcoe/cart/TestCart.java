package com.mmcoe.cart;

public class TestCart {
	public static void main(String[] args) {
		Product p1 = new Product("Laptop", 50000);
		Product p2 = new Product("Mouse", 500);
		Product p3 = new Product("Keyboard", 800);
		Product p4 = new Product("Mouse", 500);
		Product p5 = new Product("Mouse", 500);
		Product p6 = new Product("Mouse", 500);

		//ShoppingCart cart = new ShoppingCart();
//		Shopping cart=CartFactory.NewCart();
//		
//		try {
//			cart.addtocart(p1);
//			cart.addtocart(p2);
//			cart.addtocart(p3);
//			cart.addtocart(p4);
//			cart.addtocart(p5);
//			cart.addtocart(p6);
//			
//		} catch (CartFullException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e);
//		}
		ShoppingCartLinkedList<Product> cart=new ShoppingCartLinkedList<>(5);
		try {
			cart.addtocart(p1);
			cart.addtocart(p2);
			cart.addtocart(p3);
			cart.addtocart(p4);
			cart.addtocart(p5);
			cart.addtocart(p6);
		} catch (CartFullException e) {
			System.out.println(e);
		}
		cart.checkout();
		
		
	}
}
