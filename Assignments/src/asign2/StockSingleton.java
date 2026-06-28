package asign2;

public class StockSingleton {
	private static Stock instance;
	
	private StockSingleton() {}
	
	public static Stock getStock() {
		if(instance == null)
			instance = new Stock();
		return instance;
	}
}
