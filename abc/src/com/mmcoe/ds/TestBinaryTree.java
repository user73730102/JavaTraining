package com.mmcoe.ds;

public class TestBinaryTree {
	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.add(50);
		bt.add(25);
		bt.add(60);
		bt.add(20);
		bt.add(30);
		bt.in(bt.ReturnRoot());;
	}
}
