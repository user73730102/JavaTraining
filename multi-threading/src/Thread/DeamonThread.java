package Thread;

public class DeamonThread extends Thread {
	private int limit;

	public DeamonThread(int limit, String name) {
		super(name);
		this.limit = limit;
	}
	@Override
	public void run() {
		String n=Thread.currentThread().getName();
		for(int i=0;i<=limit;i++)
			System.out.println(n+": "+i);
	}
	public static void main(String[] args) {
		DeamonThread t1=new DeamonThread(50, "1st");
		DeamonThread t2=new DeamonThread(100, "2nd");
		DeamonThread t3=new DeamonThread(150, "3rd");
		DeamonThread t4=new DeamonThread(5000, "Deamon");
		
		t4.setDaemon(true);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
