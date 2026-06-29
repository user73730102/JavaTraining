import java.util.*;


public class CollectionDemo {
	public static void main(String[] args) {
		LinkedList<String> lst=new LinkedList<String>();
		lst.add("Microsoft");
		lst.addFirst("Apple");
		lst.add("Google");
		lst.addLast("Apache");
		lst.add(2,"Oracle");
		System.out.println("---------Traversing for loop");
		for (int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i));
		}
		System.out.println("--------Traversing iterator");
		Iterator<String> itr = lst.iterator(); 
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println("--------Traversing foreach");
		for (String string : lst) {
			System.out.println(string);
		}
		System.out.println("-------Traversing for-each method");
		lst.forEach(System.out::println);
		
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("IBM");
		arr.add("Apple");
		arr.add("Jboss");
		
		arr.addAll(lst);
		System.out.println("------Merged collection");
		for (String string : arr) {
			System.out.println(string);
		
		System.out.println("-------ArrayList to Hashset");
		HashSet<String> hs=new HashSet<String>(arr);
		for (String string2 : hs) 
			System.out.println(string2);
		
		System.out.println("------TreeSet(Sorted)");
		TreeSet<String> ts=new TreeSet<String>(hs);
		for (String string2 : ts) {
			System.out.println(string2);
		}
		}
	}
}
