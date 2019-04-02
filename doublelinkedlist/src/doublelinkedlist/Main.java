package doublelinkedlist;

public class Main {

	public static void main(String[] args) {
		DoubleLinked linkedlist = new DoubleLinked();
		linkedlist.insert(5);
		linkedlist.insert(1);
		linkedlist.insert(56);
		linkedlist.insert(17);
		linkedlist.walktheplank();
		linkedlist.delete(17);
		linkedlist.walktheplank();
	}
	
}
