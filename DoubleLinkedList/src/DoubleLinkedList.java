import java.util.HashMap;

public class DoubleLinkedList {
	private HashMap<Integer, Node> map = new HashMap<>();
	private Node head;
	private Node tail;
	private int capacity = 0;
	
	public DoubleLinkedList(int capacity) {
		this.capacity = capacity;
	}
	
	public void add(int key, int value){
		System.out.println("Add "+key);
		Node node = new Node(key, value);
		if(map.size() <= capacity){
			if(map.size() > 0){
				Node prevNode = map.get(tail.key);
				prevNode.next = node;
				node.previous = prevNode;
				tail = node;
			}else{
				head = node;
				tail = head;
			}
			map.put(key, node);
		}
	}
	
	public void addAfter(int key, Node n){
		System.out.println("Add "+n.key+" After "+key);
		Node node = map.get(key);
		if(node.next != null){
			node.next.previous = n;
			n.next = node.next;
		}else{
			tail = n;
		}
		node.next = n;
		n.previous = node;
		map.put(n.key, n);
	}
	
	public void addBefore(int key, Node n){
		System.out.println("Add "+n.key+" Before "+key);
		Node node = map.get(key);
		if(node.previous == null){
			n.previous = null;
			head = n;
		}else{
			n.previous = node.previous;
			node.previous.next = n;
		}
		n.next = node;
		node.previous = n;
		map.put(n.key,n);
	}
	
	public void remove(int key){
		System.out.println("Remove "+key);
		if(map.size() > 0){
			Node temp = map.get(key);
			if(temp.previous == null){
				temp.next.previous = null;
				head = temp.next;
				tail = head;
			}
			if(temp.next == null){
				Node last = map.get(temp.previous.key);
				last.next = null;
				tail = last;
			}
			if(temp.previous != null && temp.next != null){
				map.get(temp.previous.key).next = temp.next;
				map.get(temp.next.key).previous = temp.previous;
				
			}
			map.remove(key);
		}	
	}
	
	public void show(int order){
		if(order == 1){
			System.out.println("First to last:");
			Node n = map.get(head.key);
			n.print();
			while(n.next != null){
				n = n.next;
				n.print();
			}
		}else if(order == -1){
			System.out.println("Last to first:");
			Node n = map.get(tail.key);
			n.print();
			while(n.previous != null){
				n = n.previous;
				n.print();
			}
		}
		
	}
	
	public static void main(String[] args){
		DoubleLinkedList dblList = new DoubleLinkedList(10);
		dblList.add(1, 1);
		dblList.add(2, 2);
		dblList.add(3, 3);
		dblList.show(1);
		dblList.show(-1);
		
		dblList.remove(2);
		dblList.show(1);
		dblList.show(-1);
		
		dblList.remove(3);
		dblList.show(1);
		dblList.show(-1);
		
		dblList.add(4, 4);
		dblList.show(1);
		dblList.show(-1);
		dblList.add(6, 6);
		dblList.show(1);
		dblList.show(-1);
		
		dblList.addAfter(4, new Node(5,5));
		dblList.show(1);
		dblList.show(-1);
		
		dblList.remove(4);
		dblList.show(1);
		dblList.show(-1);
		
		dblList.addAfter(5, new Node(2,2));
		dblList.show(1);
		dblList.show(-1);
		
		dblList.addAfter(6, new Node(7,7));
		dblList.show(1);
		dblList.show(-1);
		
		dblList.addBefore(6, new Node(4,4));
		dblList.show(1);
		dblList.show(-1);
		
		dblList.addBefore(1, new Node(0,0));
		dblList.show(1);
		dblList.show(-1);
		System.out.println(dblList.map);
	}
}

class Node{
	int key;
	int value;
	Node previous;
	Node next;
	
	Node(int key, int value){
		this.key = key;
		this.value = value;
	}
	
	public void print(){
		System.out.println("["+key+","+value+"]");
	}
}
