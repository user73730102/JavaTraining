package com.mmcoe.ds;

public class LinkedList<E> {
	private class Node{
		private E data;
		public Node next;
		public Node(E data) {
			this.data = data;
		}
		public E getData() {
			return data;
		}
	}
	private Node head, last;
	private int size;
	public void add(E data) {
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
	public void print() {
		Node curr=head;
		if(head==null)
			return;
		else {
			while(curr!=null) {
				System.out.println(curr.getData());
				curr=curr.next;
			}
		}
	}
	public void insert(int idx, E data) {
		if(idx>size)
			throw new IllegalArgumentException("Index out of bound");
		Node curr=head;
		int ct=0;
		Node ins=new Node(data);
		if(idx==0) {
			ins.next=head;
			head=ins;
		}
		else {
			while(ct<idx-1) {
				curr=curr.next;
				ct++;
			}
			ins.next=curr.next;
			curr.next=ins;
		}
			
	}
	public void delete(int idx) {
		if(idx>size)
			throw new IllegalArgumentException("Index out of bound");
		Node curr=head;
		int ct=0;
		if(idx==0) {
			head=head.next;
		}
		else {
			while(ct<idx-1) {
				curr=curr.next;
				ct++;
			}
			if(idx==size)
				last=curr;
			curr.next=curr.next.next;
		}	
		size--;
	}
}
