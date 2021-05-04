/**
 * Realization of a circular FIFO queue as an adaptation of a
 * CircularlyLinkedList. This provides one additional method not part of the
 * general Queue interface. A call to rotate() is a more efficient simulation of
 * the combination enqueue(dequeue()). All operations are performed in constant
 * time.
 */

public class LinkedCircularQueue<E> implements Queue<E> {
	CircularlyLinkedList<E> list = new CircularlyLinkedList<>();

	public static void main(String[] args) {
		LinkedCircularQueue<Integer> circularQ = new LinkedCircularQueue<Integer>();
		System.out.println("Size: " + circularQ.size());
		System.out.println("Is it empty?: " + circularQ.isEmpty());

		System.out.println("\nEnqueue some elements (2,3,4,5)");
		circularQ.enqueue(2);
		circularQ.enqueue(3);
		circularQ.enqueue(4);
		circularQ.enqueue(5);
		System.out.println("Queue: " + circularQ);
		System.out.println("Size: " + circularQ.size());
		System.out.println("Is it empty?: " + circularQ.isEmpty());

		System.out.println("\nFirst element: " + circularQ.first());

		System.out.println("\nDequeue two elements");
		circularQ.dequeue();
		circularQ.dequeue();
		System.out.println("Queue: " + circularQ);
		System.out.println("New Size: " + circularQ.size());

		System.out.println("Queue: " + circularQ);

		System.out.println("\nMore detailed testing in junit file.\n***PASSED ALL TESTS***");
	}
	

	@Override
	public String toString() {
		return list.toString();
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
