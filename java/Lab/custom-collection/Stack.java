package DSA;

import javax.management.RuntimeErrorException;

public class Stack {

	int arr[];
	int top;
	int size;

	public Stack(int size) {

		this.arr = new int[size];
		this.size = size;
		this.top = -1;
	}

	public boolean push(int data) {
		boolean br = false;

		if (this.top == this.arr.length - 1) {
			System.out.println("Stack is Full");
			throw new RuntimeException("Stack is Full");
		} else {

			this.top++;
			// System.out.println(top + " pos of pointer");
			this.arr[top] = data;
		}
		return br;
	}

	public boolean isEmpty() {
		return (this.top == -1) ? true : false;
	}

	public int pop() {
		int data = -1;

		if (this.isEmpty()) {
			System.out.println("Stack is empty Unable to POP");
			throw new RuntimeException("Stack is Empty");
		} else {
			data = this.arr[this.top];
			this.top--;
		}

		return data;
	}

	public void traversal() {
		if (this.isEmpty()) {
			System.out.println("Stack is empty Unable to traverse");
			throw new RuntimeException("Stack is Empty");
		} else {

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");

			}
		}
	}

	public static void main(String[] args) {

		Stack stack = new Stack(5);

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.isEmpty());
		;

		System.out.println(stack.pop());

		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
