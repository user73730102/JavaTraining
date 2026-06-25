package Thread;

public class MyThread extends Thread{
	private int data;
	public MyThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		Thread ct=Thread.currentThread();
		String tname=ct.getName();
		for(int i=0;i<50;i++) {
			System.out.println(tname+": "+ ++data);
		}
	}
	public static void main(String[] args) {
		MyThread t1=new MyThread("1st");
		MyThread t2=new MyThread("2nd");
		MyThread t3=new MyThread("3rd");
		
		t2.setPriority(MAX_PRIORITY);
		t1.setPriority(MIN_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		
		Thread ct=Thread.currentThread();
		String tname=ct.getName();
		for(int i=0;i<50;i++) {
			System.out.println(tname+": "+ i);
		}
	}
}
