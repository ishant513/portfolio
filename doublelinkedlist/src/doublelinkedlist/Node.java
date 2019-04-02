package doublelinkedlist;

public class Node {
	public Node next;
	public Node prev;
	public Integer contents;
	
	public Node() {
		this.contents = null;
		this.next = null;
		this.prev = null;
	}
	
	public Node(int content) {
		this.contents = content;
		this.next = null;
	}
	
	public int getContents(){
		return this.contents;
	}
}
