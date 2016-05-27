import java.util.HashMap;

public class LRUCache {
	HashMap<Integer, Node> map = new HashMap<>();
	Node head;
	Node tail;
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	/*public int get(int key) {
		Node n = map.get(key);
		if (n == null) {
			return -1;
		} else {
			return n.val;
		}
	}*/

	public void remove(Node n) {
		Node node = map.get(n.key);
		if (node.pre == null) {
			head = node;
		} else {
			node.pre.next = node.next;
		}
		if (node.next == null) {
			tail = node.pre;
		} else {
			node.next.pre = node.pre;
		}
		
		if (head.next == null) {
			tail = head;
		}
	}

	private void setHead(Node n) {
		if (head != null) {
			head.pre = n;
			n.next = head;
			n.pre = null;
		}
		head = n;
		if (tail == null) {
			tail = head;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node oldNode = map.get(key);
			oldNode.val = value;
			remove(oldNode);
			setHead(oldNode);
		} else {
			Node node = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(tail);
				remove(tail);
				setHead(node);
			} else {
				setHead(node);
			}
			map.put(key, node);
		}
		System.out.println("head="+head.key+", tail="+tail.key);
		print();
	}

	public void print() {
		Node n = head;
		System.out.println(head.key);
		while (n.next != null) {
			System.out.println(n.next.key);
			n = n.next;
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(6);
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.set(4, 4);
		cache.set(5, 5);
		cache.set(6, 6);
		cache.set(7, 7);
		cache.set(8, 8);
		cache.set(7, 7);
		cache.set(3, 3);
	}
}

class Node {
	int key;
	int val;
	Node pre;
	Node next;

	Node(int key, int val) {
		this.key = key;
		this.val = val;
	}
}
