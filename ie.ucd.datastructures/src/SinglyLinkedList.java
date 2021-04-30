import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {

	private Node<E> head;
	private int size;

	private class Node<E> {
		private E element;
		private Node<E> next;

		/* Constructor */
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	@Override
	public void addFirst(E e) {
		head = new Node<E>(e, head);
		size++;
	}

	@Override
	public void addLast(E e) {
		Node<E> newest = new Node<E>(e, null);
		Node<E> last = head;
		if (last == null) {
			head = newest;
		} else {
			while (last.getNext() != null) {
				last = last.getNext();
			}
			last.setNext(newest);
		}
		size++;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E get(int i) {
		Node<E> get = head;
		for (int j = 0; j < i; j++) {
			get = get.getNext();
		}
		return get.getElement();
	}

	@Override
	public void add(int i, E e) {
		if (i == 0)
			addFirst(e);
		else {
			Node<E> addIndex = head;
			for (int j = 0; j < i - 1; j++) {
				addIndex = addIndex.getNext();
			}
			Node<E> newest = new Node<E>(e, addIndex.getNext());
			addIndex.setNext(newest);
			size++;
		}
	}

	@Override
	public E remove(int i) {
		if (isEmpty())
			return null;
		Node<E> curr = head;
		Node<E> remove = head;
		if (i == 0)
			removeFirst();
		else {
			for (int j = 0; j < i - 1; j++) {
				curr = curr.next;
			}
			remove = curr.getNext();
			curr.setNext(curr.getNext().getNext());
		}
		return remove.getElement();
	}

	private class ListIterator implements Iterator<E> {
		Node<E> curr;

		public ListIterator() {
			curr = head;
		}

		@Override
		public boolean hasNext() {
			return curr != null;
		}

		@Override
		public E next() {
			E n = curr.getElement();
			curr = curr.getNext();
			return n;
		}

	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E removeFirst() {
		if (head == null)
			return null;
		Node<E> first = head;
		head = head.getNext();
		size--;
		return first.getElement();
	}

	@Override
	public E removeLast() {
		if (isEmpty())
			return null;
		Node<E> secondLast = head;
		Node<E> last = head;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		while (secondLast.getNext().getNext() != null) {
			secondLast = secondLast.getNext();
		}
		secondLast.setNext(null);
		size--;
		return last.getElement();
	}

	public String toString() {
		String result = "[";
		Node<E> current = head;
		while (current != null) {
			result += current.getElement();
			if (current.getNext() != null) {
				result += ", ";

			}
			current = current.getNext();
		}
		result += "]";
		return result;
	}

	public static void main(String[] args) {
//		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
//
//		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
//		for (String s : alphabet) {
//			sll.addLast(s);
//		}
//		System.out.println(sll.toString());
//
//		sll.removeFirst();
//		System.out.println(sll.toString());
//		
//		sll.removeLast();
//		System.out.println(sll.toString());
//
//		sll.remove(0);
//		System.out.println(sll.toString());
//		
//		System.out.println(sll.get(0));
//		
//		sll.add(0, "a");
//		System.out.println(sll.toString());

//		for (String s : sll) {
//			System.out.print(s + ", ");
//		}
	}

	public E first() {
		if (isEmpty())
			return null;
		return head.getElement();
	}

	public E last() {
		if (isEmpty())
			return null;
		Node<E> last = head;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		return last.getElement();
	}
}
