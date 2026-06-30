package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamDemo {
	public static void process(int i) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		List<Integer> numbers=IntStream.range(1,99).boxed().collect(Collectors.toList());
		
		long start=System.currentTimeMillis();
		numbers.stream().forEach(ParallelStreamDemo::process);
		long end=System.currentTimeMillis();
		System.out.println("Time taken :"+(end-start));


		start=System.currentTimeMillis();
		numbers.parallelStream().forEach(ParallelStreamDemo::process);
		end=System.currentTimeMillis();
		System.out.println("Time taken :"+(end-start));
	}
}
