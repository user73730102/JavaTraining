package asign3;

import asign3.Book;
import asign3.Member;

public class TestLibrary {
	public static void main(String[] args) {
		Book b1 = new Book("The Alchemist");
		Book b2 = new Book("Kite RUnner");
		
		Member m1=new Member("abc");
		Member m2=new Member("xyz");
		
		b1.issue(m1);
		b2.issue(m2);
		
		b1.status();
		m1.status();
		
		b1.revoke(m1);
		b2.revoke(m2);
		
		b1.status();
		m1.status();
	}
}
