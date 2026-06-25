package com.mmcoe.cart;

public class ShoppingCartLinkedList <E extends Product>{
	private class Node{
		private E data;
		public Node next;
		public Node(E data) {
			this.data = data;
		}
		public E getData() {
			return data;
		}
		public double getPrice() {
			return data.getPrice();
		}
	}
	private Node head, last;
	private int size;
	private int capacity;

	public ShoppingCartLinkedList(int capacity) {
		this.capacity = capacity;
	}

	public void addtocart(E data) throws CartFullException {
		if (size >= capacity) {
			throw new CartFullException("Cart is full");
		}
		Node n = new Node(data);
		if(head==null) {
			head=n;
			size++;
		}
		else {
			last.next=n;
			size++;
		}
		last=n;
	}
	public void checkout() {
		Node curr=head;
		double total=0;
		if(head==null)
			return;
		else {
			while(curr!=null) {
				System.out.println(curr.getData());
				total+=curr.getData().getPrice();
				curr=curr.next;
			}
		}
		System.out.println("Total Amount: " + total);
	}

}
