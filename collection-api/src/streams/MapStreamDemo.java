package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStreamDemo {
	public static void main(String[] args) {
		Map<String,String> people=new HashMap<>();
		people.put("Polo1","Pune1");
		people.put("Polo2","Pune2");
		people.put("Polo3","Pune3");
		
		people.values().stream().forEach(System.out::println);
		List<String> cities = people.values().stream().map(c->c.toUpperCase()).sorted().collect(Collectors.toList());
		cities.forEach(System.out::println);
		
		Map<String,List<String>> contacts =new HashMap<>();
		contacts.put("Frudo", Arrays.asList("123-46546","2189-6515"));
		contacts.put("Sean", Arrays.asList("123-4684646","189-6515"));
		contacts.put("Mean", Arrays.asList("553-6546","4489-6515"));
	//	contacts.values().stream().flatMap(Collection::stream).forEach(System.out::println);
//		contacts.values()
//        .stream()
//        .flatMap(List::stream)
//        .filter(number -> number.contains("8"))
//        .forEach(System.out::println);
		
		contacts.values()
        .stream()
        .flatMap(List::stream)
        .map(number -> number.replace("-", ""))
        .forEach(System.out::println);
		
		
		
	}
}
