package com.mmcoe.cart;

public interface Shopping {
	void addtocart(Product P) throws CartFullException;
	void checkout() throws CartEmptyException;
}
