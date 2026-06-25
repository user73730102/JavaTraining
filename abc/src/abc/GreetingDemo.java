package abc;

interface Greeting
{
	void sayHello();
}
public class GreetingDemo {
	class InnerGreeting implements Greeting{
		@Override
		public void sayHello(){
			System.out.println("Inner Greeting");
		}
	}
	public void ClassInsideMethod(){
		class GreetingMeth implements Greeting{
			@Override
			public void sayHello() {
				System.out.println("Greeting Nested Impl");
			}
		}
		new GreetingMeth().sayHello();
	}
	public static void main(String[] args) {
		GreetingDemo g1=new GreetingDemo();
		Greeting g2=g1.new InnerGreeting();
		g2.sayHello();
		
		g1.ClassInsideMethod();
		Greeting g = new Greeting() {
		@Override
			public void sayHello()
			{
				System.out.println("Anonymous Class");
			}
		};
		g.sayHello();
		Greeting greet = () -> System.out.println("Hello from Lambda");
		greet.sayHello();
	}
	
}