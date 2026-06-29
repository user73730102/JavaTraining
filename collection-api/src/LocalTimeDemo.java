import java.time.LocalTime;

public class LocalTimeDemo {
	public static void main(String[] args) {
		LocalTime t1=LocalTime.now();
		LocalTime t2=LocalTime.of(6, 30);
		System.out.println(t1);
		System.out.println(t2.plusHours(3));
	}
}
