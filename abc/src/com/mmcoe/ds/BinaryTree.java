package com.mmcoe.ds;

public class BinaryTree{
	private class Node{
		private int data;
		public Node left,right;
		public Node(int data) {
			this.data = data;
		}
		public int getData() {
			return data;
		}
	}
	public Node root;
	public Node ReturnRoot() {
		return root;
	}
	public void add(int data) {
		Node n=new Node(data);
		if(root==null) {
			root=n;
		}
		else {
		Node cur=root;
		while(true) {
			if(cur.data==data)
				break;
			if(data<cur.data) {
				if(cur.left==null) {
					cur.left=n;
					break;
				}
				else 
					cur=cur.left;
			}
			else {
				if(cur.right==null) {
					cur.right=n;
					break;
				}
				else
					cur=cur.right;
						
				}
			}
		}	
	}
	void in(Node n) {
		if(n==null)
			return;
		in(n.left);
		System.out.println(n.getData());
		in(n.right);
	}
}
