package doublelinkedlist;

public class DoubleLinked {
	Node head;
	Node tail;
	
	public DoubleLinked() {
		head = null;
	}
	
	public static void main(String[] args) {
		
	}

	public void walktheplank() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.contents);
			temp = temp.next;
		}
	}
	
	public void insert(int newvalue) {
		Node newNode = new Node(newvalue);
		if(head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
	
	public void delete(int num) {
		Node temp = head;
		if(head == null) {
			System.out.println("nothing in Double Linked List");
			return;
		} 
		if(head.contents == num) {
			System.out.println("deleting head node " + head.contents);
			head = head.next;
			head.prev = null;
			return;
		} 
		if(tail.contents == num) {
			System.out.println("deleting tail node " + tail.contents);
			tail = tail.prev;
			tail.next = null;
			return;
		}
		//Find the node and delete it
		while(temp != null) {
			if(temp.contents == num) {
				System.out.println("deleting node " + temp.contents);
				(temp.prev).next = temp.next;
				(temp.next).prev = temp.prev;
				break;
			}
			temp = temp.next;
		}
	}
}
