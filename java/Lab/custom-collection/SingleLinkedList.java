package DSA;

import java.util.Scanner;

public class SingleLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}

		public Node head;

		public void creation() {
			Scanner sc = new Scanner(System.in);
			int con;
			do {
				System.out.println("Enter the data");
				int data = sc.nextInt();
				Node new_node = new Node(data);
				if (head == null) {
					head = new_node;
				} else {
					System.out.println("Enter the position where top add 1 to front ,2 to end , 3 at specific postion");
					int pos = sc.nextInt();
					switch (pos) {
					case 1:

						Node temp = head;
						new_node.next = temp;
						head = new_node;

						break;

					case 2:
						Node tempL = head;
						while (tempL.next != null) {
							tempL = tempL.next;

						}
						tempL = new_node;

						break;
					case 3:
						System.out.println("Enter the pos to add");
						int poss = sc.nextInt();
						Node temps = head;
						for (int i = 1; i <= (poss - 2); i++) {
							temps = temps.next;

						}
						new_node.next = temps.next;
						temps.next = new_node;

						break;
					default:
						break;
					}

				}
				con = sc.nextInt();
				System.out.println("Enter 1 continue ");
			} while (con == 1);
		}

		public void traversal() {
			if (head == null) {
				System.out.println("Linked list is empty");

			} else {

				Node temp = head;
				while (temp != null) {
					System.out.println(temp.data);
					temp = temp.next;

				}

			}
		}

		public void deletion() {
			if (head == null) {
				throw new RuntimeException("SingleLinkedList is Empty");
			} else {

				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter 1 delete from front, 2 delete front end , 3 at specific end");
				int pos = scanner.nextInt();

				switch (pos) {
				case 1:
					Node temp = head;
					head = temp.next;

					break;
				case 2:
					Node tempd = head;
					Node spot = tempd.next;

					while (spot.next != null) {
						tempd = spot;
						spot = spot.next;

					}
					tempd.next = null;
					break;
				case 3:
					Node tmpd = head;
					Node tms = tmpd.next;
					int spd = scanner.nextInt();
					for (int i = 1; i <= (spd - 2); i++) {

						tmpd=tms;
						tms=tms.next;
						
						
					}
					tmpd.next=tms.next;

					break;

				default:
					break;
				}

			}

		}

	}

}
