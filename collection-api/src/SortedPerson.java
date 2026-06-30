import java.util.Comparator;
import java.util.TreeSet;

public class SortedPerson {
	public static void main(String[] args) {
		
//		Comparator<Person> ageCom=(p1,p2) -> p1.getAge()-p2.getAge();
//		Comparator<Person> NameCom=(p1,p2) -> p1.getName().compareTo(p2.getName());
//		TreeSet<Person> ts=new TreeSet<Person>(NameCom);
		TreeSet<Person> ts=new TreeSet<Person>();
		ts.add(new Person("Polo1",24));
		ts.add(new Person("Polo2",23));
		ts.add(new Person("Polo3",22));
		
		ts.forEach(System.out::println);
		
	}
}
