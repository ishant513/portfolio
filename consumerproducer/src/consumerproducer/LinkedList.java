package consumerproducer;

public class LinkedList {
	public Node head;
	public Node tail;
	
	public LinkedList(Node listhead, Node listtail) {
		this.head = listhead;
		this.head.next = listtail;
		this.tail = listtail;
		this.tail.prev = this.head;
	}
	
	public LinkedList(Node listhead) {
		this.head = listhead;
		this.tail = null;
		this.head.next = this.tail;
	}
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public boolean insert(Node node) {
		if(this.head == null) {
			this.head = node;
			return true;
		}
		if(this.tail == null && this.head != null) {
			this.head.next = node;
			this.tail = node;
			this.tail.prev = this.head;
			return true;
		}
		if(this.tail != null) {
			this.tail.next = node;
			node.prev = this.tail;
			this.tail = node;
		}
		return false;
	}
	
	public Node delete() {
		if(this.head == null) {
			return null;
		}
		if(this.head.next == null) {
			Node ret = this.head;
			this.head = null;
			this.tail = null;
			return ret;
		}
		if(this.head.next == this.tail) {
			Node ret = this.head;
			this.tail.prev = null;
			this.head.next = null;
			this.head = this.tail;
			this.tail = null;
			return ret;
		}
		Node ret = this.head;
		this.head = ret.next;
		this.head.prev = null;
		ret.next = null;
		return ret;
	}
}
