package notlinkedlist;

public class Node {
	
	public int contents;

	@SuppressWarnings("null")
	public Node() {
		this.contents = (Integer) null;
	}
	
	public Node(int content) {
		this.contents = content;
	}
	
	public int getContents(){
		return this.contents;
	}
	
	public void setContents(int content) {
		this.contents = content;
	}
}