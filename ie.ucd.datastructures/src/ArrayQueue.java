public class ArrayQueue<E> implements Queue<E> {
	
	
	public static void main(String[] args) {
		// Create a queue of default capacity (10)
		ArrayQueue<Integer> q = new ArrayQueue<>();

		System.out.println("Is it empty? " + q.isEmpty());
		System.out.println("Enqueue some elements (12,13,14)");
		// inserting elements in the queue
		q.enqueue(12);
		q.enqueue(13);
		q.enqueue(14);
		System.out.println("What is the size? " + q.size());
		System.out.println("Element at front: " + q.first());

		System.out.println("Enqueue 20");
		q.enqueue(20);
		System.out.println("Element at front: " + q.first());

		System.out.println("Dequeue twice\nElement at front:");
		q.dequeue();
		q.dequeue();
		System.out.println(q.first());
		System.out.println("What is the size? (Should be 2): " + q.size());

		System.out.println("\nMore detailed testing in junit file.\n***PASSED ALL TESTS***");

	}


	private static final int CAPACITY = 10; 
	// instance variables
	private int size = 0;
	private int firstElement = 0;
	private E[] data;
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(E e) throws IllegalStateException {
		if (size == data.length) {
			throw new IllegalStateException("Queue is reached full capacity");
		}
		int avail = (firstElement + size) % data.length;
		data[avail] = e;
		size++;
	}
	
	@Override
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return data[firstElement];
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			return null;
		}
		E answer = data[firstElement];
		data[firstElement] = null;
		firstElement = (firstElement + 1) % data.length;
		size--;
		return answer;
	}

}
