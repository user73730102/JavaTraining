package Thread;

public class MyThreadRunnable implements Runnable{
	private int data;
	@Override
	public void run() {
		Thread ct=Thread.currentThread();
		String tname=ct.getName();
		for(int i=0;i<50;i++) {
			System.out.println(tname+": "+ ++data);
		}
	}
	public static void main(String[] args) {
		MyThreadRunnable mr=new MyThreadRunnable();
		Thread t1=new Thread(mr,"1st");
		Thread t2=new Thread(mr,"2nd");
		Thread t3=new Thread(mr,"3rd");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
