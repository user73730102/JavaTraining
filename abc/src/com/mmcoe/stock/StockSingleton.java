package com.mmcoe.stock;

public class StockSingleton {
	private static Stock instance;
	
	private StockSingleton() {}
	
	public static Stock getStock() {
		if(instance == null)
			instance = new Stock();
		return instance;
	}
}
