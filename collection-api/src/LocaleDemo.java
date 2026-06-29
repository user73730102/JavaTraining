import java.util.*;
public class LocaleDemo {
	public static void main(String[] args) {
//		ResourceBundle rb= ResourceBundle.getBundle("msgs");
//		ResourceBundle rb= ResourceBundle.getBundle("msgs", Locale.FRANCE);
//		ResourceBundle rb= ResourceBundle.getBundle("msgs", Locale.of("hi"));
		ResourceBundle rb= ResourceBundle.getBundle("msgs", Locale.of("mr"));
		System.out.println(rb.getString("greeting"));
		System.out.println(rb.getString("message"));
	}
}
