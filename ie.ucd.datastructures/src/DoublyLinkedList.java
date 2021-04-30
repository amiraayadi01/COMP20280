
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {

	private Node<E> head;
	private int size;

	private class Node<E> {
		private E element;
		private Node<E> next;
		private Node<E> prev;

		/* Constructor */
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
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

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> p) {
			prev = p;
		}
	}

	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<E>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
	}

	@Override
	public int size() {
		return size;
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
			Node<E> newest = new Node<E>(e, addIndex, addIndex.getNext()); // same as singly but we set the prev
			addIndex.setNext(newest);
			size++;
		}
	}

	@Override
	public E remove(int i) {
		Node<E> remove = head;
		if (i == 0)
			removeFirst();
		else {
			for (int j = 0; j < i; j++) {
				remove = remove.getNext(); // here we can get the element we want to remove
			}
			remove.getPrev().setNext(remove.getNext()); // we can then set its prevs next to the element 2 ahead
			remove.getNext().setPrev(remove.getPrev()); // we then set the element ahead of removes prev to 2 behind
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
	public E removeFirst() {
		if (isEmpty())
			return null;
		Node<E> first = head;
		if (size == 1) {
			head = null;
			size--;
			return first.getElement();
		}
		head = head.getNext();
		head.setPrev(null); // same as singly linked list but we set the new head prev to null
		size--;

		return first.getElement();
	}

	@Override
	public E removeLast() {
		if (isEmpty())
			return null;
		Node<E> last = head;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		last.getPrev().setNext(null); // same as singly linked list but we can use prev to set the second last
										// elements next to null
		size--;
		return last.getElement();
	}

	@Override
	public void addFirst(E e) {
		head = new Node<E>(e, null, head);
		if (head.getNext() != null) {
			head.getNext().setPrev(head); // same as singly linked list but we set the prev of old head to new head
		}
		size++;
	}

	@Override
	public void addLast(E e) {
		Node<E> newest = new Node<E>(e, null, null);
		Node<E> last = head;
		if (last == null) {
			head = newest;
		} else {
			while (last.getNext() != null) {
				last = last.getNext();
			}
			newest.setPrev(last); // same as singly linked list but we set the prev to the old last
			last.setNext(newest);
		}
		size++;
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
//		   DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
//           ll.addFirst(0);
//           ll.addFirst(1);
//           ll.addFirst(2);
//           ll.addLast(-1);
//           System.out.println(ll);
//           
//           ll.removeFirst();
//           System.out.println(ll);
//
//           ll.remove(1);
//           System.out.println(ll);
//           
//           ll.add(1,-9);
//           System.out.println(ll);
//           
//           ll.addBetween(99, ll.head, ll.head.getNext());
//           System.out.println(ll);
//           
//           for(Integer e: ll) {
//                   System.out.println("value: " + e);
//           }
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
