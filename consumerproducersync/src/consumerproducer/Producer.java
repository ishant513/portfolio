package consumerproducer;

public class Producer implements Runnable{
	
	public LinkedList list;
	
	public Producer(LinkedList linkedlist) {
		this.list = linkedlist;
	}
	
	@Override
	public void run() {
		Thread t = Thread.currentThread(); //tracking the current thread
		while(Node.count < 100) { //ends the loop when 100 nodes created total
			synchronized(this.list) {
				if(this.list.head == null) { //base case if the linked list is empty
					Node node = new Node();
					this.list.head = node;
					System.out.println("Produced: " + node.key + " " + t.getId() + " count: " + 1);
				} else {
					int count = 0;
					Node n = this.list.head;
					/* getting the current size of the linked list
					 there should never be more than 5 nodes in the list at any point */
					while(n.next != null) {
						count++;
						n = n.next;
					}
					if(count < 5) {
						Node node = new Node();
						this.list.insert(node);
						System.out.println("Produced: " + node.key + " " + t.getId() + " count: " + (count + 1));
					}
				}
			}
		}
	}
}
