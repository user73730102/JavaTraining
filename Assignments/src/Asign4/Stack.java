package Asign4;

public class Stack{
	private int[] arr;
	private int top, size;
	public Stack(int size) {
		this.size=size;
		arr=new int[size];
		top=-1;
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public boolean isFull() {
		return top==size-1;
	}
	public void push(int data) {
		if(isFull())
			throw new RuntimeException("Stack Overflow");
		arr[++top]=data;
	}
	public int pop() {
		if(isEmpty())
			throw new RuntimeException("Stack Underflow");
		return arr[top--];
	}
	public void display() {
		for(int i=top;i>=0;i--) {
			System.out.println(arr[i]);
		}
	}
}
