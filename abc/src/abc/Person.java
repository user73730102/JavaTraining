package abc;

public class Person implements Cloneable {
	private String name;
	private int age;
	public Person() {
		this("abc",20);
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void print() {
		System.out.println("Name: "+name+", Age: "+age);
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Person)
		{
			Person p=(Person) obj;
			if(name.equals(p.name) && p.age==this.age)
				return true;
		}
		return false;
			
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1=new Person("abc", 20);
		p1.print();
		Person p2=new Person();
		p2.print();
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p1.equals(p2));
		Person p3 = (Person) p1.clone();
		System.out.println(p3);
	}
	
}
