package asign2;

public class TestStock {
	public static void main(String[] args) {
		Holder h=StockSingleton.getStock();
		h.viewQuote();
		Broker b=StockSingleton.getStock();
		b.getQuote();
		Exchange x=StockSingleton.getStock();
		x.setQuote();
		System.out.println(h.equals(b));
		System.out.println(b.equals(x));
	}
}
