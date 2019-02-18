package notlinkedlist;

public class ListNode {
	
	Integer contents;
	ListNode next;

	public ListNode() {
		this.contents = null;
		this.next = null;
	}
	
	public ListNode(int content) {
		this.contents = content;
		this.next = null;
	}
	
	public int getContents(){
		return this.contents;
	}
}
