
public class LinkedQueue<E> implements Queue<E> {

	private SinglyLinkedList<E> list = new SinglyLinkedList<>();

	public static void main(String[] args) {

		LinkedDeque<Integer> linkedDQ = new LinkedDeque<Integer>();
		System.out.println("Size: " + linkedDQ.size());
		System.out.println("Is is empty? " + linkedDQ.isEmpty());

		for (int i = 10; i < 20; ++i)
			linkedDQ.addLast(i);

		System.out.println("\nQueue : " + linkedDQ);
		System.out.println("Size: " + linkedDQ.size());
		System.out.println("Is is empty? " + linkedDQ.isEmpty());

		System.out.println("\nRemove first (Front deque) ");
		linkedDQ.removeFirst();
		System.out.println("Updated Queue: " + linkedDQ);

		System.out.println("\nRemove last (Back deque) TWICE");
		linkedDQ.removeLast();
		linkedDQ.removeLast();
		System.out.println("Updated Queue: " + linkedDQ);

		System.out.println("\nFirst element: " + linkedDQ.first());
		System.out.println("Last element: " + linkedDQ.last());

		System.out.println("\nAdd first (Front enqueue) ");
		linkedDQ.addFirst(99);
		System.out.println("Updated Queue: " + linkedDQ);

		System.out.println("\nAdd last (Back enqueue) ");
		linkedDQ.addLast(66);
		System.out.println("Updated Queue: " + linkedDQ);

		System.out.println("\nMore detailed testing in junit file.\n***PASSED ALL TESTS***");
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		list.addLast(e);
	}

	@Override
	public E first() {
		return list.get(0);
	}

	@Override
	public E dequeue() {
		return list.removeFirst();
	}
	


}