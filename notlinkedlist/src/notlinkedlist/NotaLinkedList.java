package notlinkedlist;

public class NotaLinkedList {
	ListNode head;
	
	public NotaLinkedList() {
		this.head = null;
	}
	
	public static void main(String[] args) {
		NotaLinkedList linkedlist = new NotaLinkedList();
		linkedlist.insert(1);
		linkedlist.insert(9);
		linkedlist.insert(16);
		linkedlist.insert(7);
		linkedlist.walktheplank();
		linkedlist.deleteAt(3);
		linkedlist.walktheplank();
	}
	
	public void insert(int newvalue) {
		if(head == null) {
			head = new ListNode(newvalue);
		} else{
			ListNode newNode = new ListNode(newvalue);
			if(newNode.contents < head.contents) {
				newNode.next = head;
				head = newNode;
			} else {
				ListNode temp = head;
				while(temp.next != null && temp.next.contents < newNode.contents){
					temp = temp.next;
					newNode.next = temp.next;
				}
				newNode.next = temp.next;
				temp.next = newNode;
			}
		}
	}
	
	public void walktheplank() {
		ListNode temp = head;
		while(temp != null) {
			System.out.println(temp.contents);
			temp = temp.next;
		}
	}
	
	public int size(ListNode list) {
		int size = 0;
		ListNode temp = list;
		while(temp.next != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}
	
	public void deleteAt(int index) {
		if(index == 0) {
			head = head.next;
		}
		if(index >= size(head)) {
			throw new IndexOutOfBoundsException("Index too high");
		}
		ListNode temp = head;
		for(int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
	}
}