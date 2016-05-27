
public class MyLinkedList {

	private Node head;

	public MyLinkedList() {
		head = new Node(1);
		Node two = new Node(2);
		head.setNext(two);
		Node three = new Node(3);
		two.setNext(three);
		Node four = new Node(4);
		three.setNext(four);
		Node five = new Node(5);
		four.setNext(five);
	}

	public void removeNode(int match) {
		if (head.data == match) {
			head = head.next;
			return;
		} else {
			Node temp = head;
			while (temp.next != null) {
				if (temp.next.data == match) {
					temp.next = temp.next.next;
					return;
				}
				temp = temp.next;
			}
		}
	}

	public void addNode(int matchNodeData, int data) {
		Node tempNode = head;
		while (tempNode != null) {
			if (tempNode.data == matchNodeData) {
				Node temp = tempNode.next;
				tempNode.next = new Node(data);
				tempNode.next.next = temp;
				return;
			}
			tempNode = tempNode.next;
		}
	}

	public void removeAtPosition(int index) {
		if(index == 0){
			head = head.next;
			return;
		}else{
			int i=1;
			Node temp = head;
			while(i<index){
				temp = temp.next;
				i++;
			}
			temp.next = temp.next.next;
		}
	}

	public void printLinkedList() {
		Node temp = head;
		System.out.println(head);
		while (temp.getNext() != null) {
			System.out.println(temp.getNext());
			temp = temp.getNext();
		}
	}

	public static void main(String args[]) {
		MyLinkedList list = new MyLinkedList();
		list.printLinkedList();
		System.out.println("");
		list.addNode(5, 9);
		list.printLinkedList();
		System.out.println("");
		list.removeNode(9);
		list.printLinkedList();
		System.out.println("after removing");
		list.removeAtPosition(2);
		list.printLinkedList();
		/*
		 * list.printLinkedList(); System.out.println(""); list.removeNode(3);
		 * list.printLinkedList();
		 */
	}

	class Node {
		private int data;
		private Node next;

		Node(int d) {
			data = d;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node n) {
			next = n;
		}

		public String toString() {
			return Integer.toString(data);
		}
	}
}
