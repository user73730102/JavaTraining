package abc;

public class StringDemo {
	public static void main(String[] args) {
		String s1="Hello";
		String s2=new String("Hello");
		String s3="Hello";
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		s1=s1+"World";
		System.out.println(s1);
		String name="Varad";
		String nRegx="[A-Z]{1}[a-z]{3,}";
		System.out.println(name.matches(nRegx));
		String eRegx="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
		String email="varadvaidya36@gmail.com";
		System.out.println(email.matches(eRegx));
	}
}
