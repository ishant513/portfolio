package consumerproducer;

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		 Thread producerThread = new Thread(new Producer(list));
	     producerThread.setName("producerThread");

	     Thread consumerThread1 = new Thread(new Consumer(list));
	     consumerThread1.setName("consumerThread1");

	     Thread consumerThread2 = new Thread(new Consumer(list));
	     consumerThread2.setName("consumerThread2");

	     producerThread.start();
	     consumerThread1.start();
	     consumerThread2.start();
	     
	}

}
