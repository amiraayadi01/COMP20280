import java.util.Iterator;


public class CircularlyLinkedList<E> implements List<E> {
	

	private class Node<E> {
		private E element;
		private Node<E> next;
	}
	private Node<E> tail = null;
	private int size = 0;
	
	public CircularlyLinkedList();
	
	@Override
	public int size() {
		return size;
	}
	

	@Override
	public boolean isEmpty() {
		return size==0;
	}
	    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {

    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
	    /**
     * Returns (but does not remove) the first element of the list
     * @return element at the front of the list (or null if empty)
     */
    public E first() {             // returns (but does not remove) the first element
        // TODO
        return null;
    }

    /**
     * Returns (but does not remove) the last element of the list
     * @return element at the back of the list (or null if empty)
     */
    public E last() {              // returns (but does not remove) the last element
        // TODO
        return null;
    }

    // update methods
    /**
     * Rotate the first element to the back of the list.
     */
    public void rotate() {         // rotate the first element to the back of the list
      if (tail != null) {
	    tail = tail.getNext();
	}
    }

    /**
     * Adds an element to the front of the list.
     * @param e  the new element to add
     */
    public void addFirst(E e) {                // adds element e to the front of the list
		if (size == 0) {
			tail = new Node<>(e, null);
			tail.setNext(tail);
		} else {
			Node<E> newest = new Node<>(e, tail.getNext());
			tail.setNext(newest);
		}
		size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param e  the new element to add
     */
    public void addLast(E e) {                 // adds element e to the end of the list
		addFirst(e);
		tail = tail.getNext();
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {                   // removes and returns the first element
		if (isEmpty()) {
			return null;
		}
		Node<E> head = tail.getNext();

		if (head == tail) {
			tail = null;
		} else {
			tail.setNext(head.getNext());
		}
		size--;
		return head.getElement();
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
		String newString = "[ ";

		Node<E> current = tail.getNext();
		while (current != tail) {
			newString = newString + current.getElement();
			newString = newString + "->";

			if (current.getNext() == tail) {
				newString = newString + tail.getElement() + " ]";
			}

			current = current.getNext();
		}

		return newString;
    }


    public static void main(String [] args) {
        //ArrayList<String> all;
        //LinkedList<String> ll;
        CircularlyLinkedList<String> ll = new CircularlyLinkedList<>();

        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            ll.addFirst(s);
            ll.addLast(s);
        }
        System.out.println(ll.toString());

        ll.rotate();
        ll.rotate();

        for (String s : ll) {
            System.out.print(s + ", ");
        }

    }
}
