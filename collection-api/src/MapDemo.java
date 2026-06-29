import java.util.*;
public class MapDemo {
	public static void main(String[] args) {
		HashMap<String,String> mp=new HashMap<>();
		mp.put("jack", "jill");
		mp.put("jack", "rose");
		mp.put("polo", "lili");
		mp.put("scott", "tiger");
		
		System.out.println("scott: "+mp.get("scott"));
		System.out.println("jack: "+mp.get("jack"));
		for(String k:mp.keySet()) {
			System.out.println("Key: "+k+", Value: "+mp.get(k));
		}
		mp.forEach((k,v)-> System.out.println("Key: "+k+", Value: "+v));
	}
}
