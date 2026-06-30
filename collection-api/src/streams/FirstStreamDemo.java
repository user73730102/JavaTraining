package streams;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FirstStreamDemo {
	public static void print(Object obj) {
		System.out.println(obj);
	}
	public static int add(int a, int b) {
		return a+b;
	}
	public static void main(String[] args) {
		Integer[] ar={2,5,7,8,11,3,1};
		List<Integer> num=Arrays.asList(ar);
		
//		for(int n:num)
//			System.out.println(n);
		
//		Stream<Integer> str1=num.stream();
//		str1.forEach(System.out::println);
//		System.out.println(str1.count());
		
//		num.stream().distinct().forEach(System.out::println); 
//		System.out.println(num.stream().distinct().count());
//		System.out.println(num.stream().filter(n->n>5).count());
//		num.stream().distinct().sorted().forEach(System.out::println);
//		System.out.println(num.stream().reduce(0,(n,m)->n+m));
//		System.out.println(num.stream().reduce(0,Integer::sum));
//		System.out.println(num.stream().reduce(0,FirstStreamDemo::add));
//		num.stream().limit(5).forEach(System.out::println); 
		
		IntStream istr = IntStream.range(1, 99);
//		System.out.println(istr.count());
//		System.out.println(istr.sum());
//		System.out.println(istr.skip(50).sum()); 
		IntStream istr2=IntStream.of(5,6,9,7,2,1);
		System.out.println(istr2.count());
		
		IntSummaryStatistics statics=istr.summaryStatistics();
		System.out.println(statics);
	}
}
