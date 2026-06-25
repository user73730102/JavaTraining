package Thread;

class Data{
	private int value;
	private boolean flag;
	public synchronized void set() {
		if(flag) {
			try {
				wait();
			}
			catch(InterruptedException e) {}
		}
		value =(int) (Math.random()*100);
		System.out.println("Set: "+value);
		flag=!flag;
		notify();
	}
	public synchronized void get() {
		if(!flag)
			try {wait();} catch(InterruptedException e) {}
		System.out.println("Get: "+value);
		flag=!flag;
		notify();
	}
}
class Producer extends Thread{
	Data d;
	public Producer(Data d) {
		this.d=d;
	}
	@Override
	public void run() {
		while(true) {
			d.set();
		}
	}
}
class Consumer extends Thread{
		Data d;
	public Consumer(Data d) {
		this.d=d;
	}
	@Override
	public void run() {
		while(true) {
			d.get();
		}
	}
}
public class InterComm {

	public static void main(String[] args) {
		Data d=new Data();
		Producer p=new Producer(d);
		Consumer c=new Consumer(d);
		p.start();
		c.start();
	}


}
