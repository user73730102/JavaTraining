package Asign4;

public class TestStack {
	public static void main(String[] args) {
		Stack s=new Stack(5);
		s.push(10);
		s.push(20);
		s.push(30);
		s.display();
		System.out.println(s.pop());
		s.display();
	}
}
