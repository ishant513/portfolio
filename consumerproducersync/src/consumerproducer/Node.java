package consumerproducer;

public class Node {
	public Node next; //next node for linked list
	public Node prev; //doubly linked list so tracks prev node as well
	public static int count = 0; //running count of all nodes ever created
	public int key;
	
	public Node(Node prevnode, Node nextnode, String nodekey) {
		this.prev = prevnode;
		this.next = nextnode;
		Node.count++; //total count increases with every new node created
		this.key = count; //key for each individual node is the current amount of nodes created
	}
	
	public Node() {
		Node.count++;
		this.key = count;
	}
}
