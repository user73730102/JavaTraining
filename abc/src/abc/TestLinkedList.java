package abc;

import com.mmcoe.ds.LinkedList;

public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> ab=new LinkedList<Integer>();
		ab.add(10);
		ab.add(20);
		ab.add(30);
		ab.insert(3, 50);
	
		ab.delete(3);
		ab.add(30);
		ab.print();
	}
}
