import java.util.*;

public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> q=new LinkedList<String>();
		q.offer("Apple");
		q.offer("Banana");
		q.offer("Cherry");
//		System.out.println(q.peek());
//		while(!q.isEmpty())
//			System.out.println(q.poll());
		
		Deque<String> dq=new LinkedList<String>();
		dq.offerFirst("Guawa");
		dq.offer("Apple");
		dq.offer("Banana");
		dq.offer("Cherry");
		dq.offerLast("Orange");
		System.out.println(dq.peekLast());
		while(dq.size()!=0)
			System.out.println(dq.pollFirst());
	}
}
