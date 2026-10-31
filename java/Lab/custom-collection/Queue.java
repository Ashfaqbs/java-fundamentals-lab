package DSA;

public class Queue {

	int front, back, arr[], size;

	public Queue(int size) {
		this.arr = new int[size];
		this.size = size;
		this.front = -1;
		this.back = -1;
	}

	public boolean enqueue(int data) {
		boolean br = false;

		if (this.back == this.arr.length - 1) {
			System.out.println("Queue is Full");
			throw new RuntimeException("queue is Full");
		} else if (this.front == -1 && this.back == -1) {
			this.front++;
			this.back++;
			this.arr[front] = data;
			br = true;
		} else {
			this.back++;
			this.arr[back] = data;
			br = true;
		}

		return br;
	}

	public boolean isEmpty() {
		boolean br = false;
		;

		if (this.front == -1 && this.back == -1) {
			System.out.println("Queue is Empty");
			// throw new RuntimeException("queue is Empty");
			br = true;
		}

		return br;
	}

	public int dequeue() {
		int data = -1;
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			throw new RuntimeException("queue is Empty");
		} else {
			data = this.arr[front];
			this.front++;
		}

		return data;
	}

	public void traversal() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			throw new RuntimeException("queue is Empty");
		} else {

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		}

	}

	public static void main(String[] args) {

		Queue queue = new Queue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.isEmpty();
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

	}
}
