package Thread;
import java.util.concurrent.*;
class GoRunnable implements Runnable{
	private final long countUntil;
	GoRunnable(long countUntil){
		this.countUntil=countUntil;
	}
	@Override
	public void run() {
		long sum=0;
		for(int i=0;i<countUntil;i++) {
			sum+=i;
		}
		System.out.println("Sum: "+sum);
	}
}
public class ExecutorDemo {
	private static final int NTHREDS=10;
	
	public static void main(String[] args) {
		ExecutorService executor=Executors.newFixedThreadPool(NTHREDS);
		long start=System.currentTimeMillis();
		for(int i=0;i<500;i++) {
			Runnable worker=new GoRunnable(100000000L+i);
			executor.execute(worker);
		}
		executor.shutdown();
		while(!executor.isTerminated()) {
			
		}
		long end=System.currentTimeMillis();
		System.out.println("Finished all threads in :"+(end-start));
	}
}
