package abc;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class FunctionalDemo {
	public static void print(Object obj) {
		System.out.println(obj);
	}
	public static void main(String[] args) {
        Consumer<String> c = (s) -> System.out.println(s);
        c.accept("Hello Consumer");
        Consumer<String> c1=System.out::println;
        c1.accept("Hello");
        c1.accept("Hola");
        Consumer<String> c2=FunctionalDemo::print;
        c2.accept("Aloha");
        
        Supplier<String> s1=() -> "Hello Supplier";
        System.out.println(s1.get());
        print(s1.get());

        Supplier<Double> random =() -> Math.random();
        System.out.println(random.get());

        Predicate<Integer> isEven= (n) -> n % 2 == 0;
        System.out.println(isEven.test(10));
        System.out.println(isEven.test(5));

        Predicate<Integer> nonNegative = (n) -> n > 0;
        System.out.println(nonNegative.test(10));
        System.out.println(nonNegative.test(-5));

        BiPredicate<String, String> contains = (str, sub) -> str.contains(sub);
        System.out.println(contains.test("Hello", "lo"));

        Function<Integer, Integer> sq=(n) -> n * n;
        System.out.println(sq.apply(10));
        
        BiFunction<Integer, Integer, Integer> greater =(a,b) -> a > b ? a : b;
        System.out.println(greater.apply(10, 20));
	}
}
