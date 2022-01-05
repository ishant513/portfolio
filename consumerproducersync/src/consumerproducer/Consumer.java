package consumerproducer;

public class Consumer implements Runnable{
	
	public LinkedList list;
	
	public Consumer(LinkedList linkedlist) {
		this.list = linkedlist;
	}

	@Override
	public void run() {
		Thread t = Thread.currentThread(); //tracks current thread
		while(Node.count < 100) {
			synchronized(this.list) {
				if(this.list.head != null) {
					Node n = this.list.head;
					int count = 0;
					while(n.next != null) { //checking size of the linked list
						count++;
						n = n.next;
					}
					if(count > 0) { //making sure list is not empty, only deletes when the list has contents
						Node node = this.list.delete();
						System.out.println("Consumed: " + node.key + " " + t.getId() + " count: " + (count - 1));
					}
				}
			}
		}
	}
}
