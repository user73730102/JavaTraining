package abc;

@FunctionalInterface
interface Hello{
	String greet();
	default void demo() {
		System.out.println("Hello Demo"+temp());
	}
	static void test() {
		System.out.println("Hello Test");
	}
	private String temp() {
		return "Hello temp";
	}
}
@FunctionalInterface
interface Printer{
	void print(String name);
}
public class LambdaDemo {
	public static void main(String[] args) {
		Hello h1 = () -> "Hello Lambda";
		System.out.println(h1.greet());
		Hello h2 = () -> {
			String msg="hello lambda2";
			return msg;
		};
		System.out.println(h2.greet());
		Printer p1= (name) -> System.out.println(name);
		p1.print("Varad");
		Printer p2= System.out::println;
		p2.print("Amazing");
		Hello.test();
		h1.demo();
	}
}
