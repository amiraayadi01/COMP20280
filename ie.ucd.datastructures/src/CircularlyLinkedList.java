import java.util.Iterator;


public class CircularlyLinkedList<E> implements List<E> {
	
	private Node<E> tail;
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
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public E get(int i) {
		Node<E> get=tail.getNext();
		for (int j = 0; j < i; j++) {
			get=get.getNext();
		}
		return get.getElement();
	}

	@Override
	public void add(int i, E e) {
		if (i==0)
			addFirst(e);
		else {
			Node<E> addIndex = tail.getNext();
			for (int j = 0; j < i-1; j++) {
				addIndex=addIndex.getNext();
			}
			Node<E> newest = new Node<E>(e,addIndex.getNext());
			addIndex.setNext(newest);
			size++;
		}
	}

	@Override
	public E remove(int i) {
		Node<E> curr=tail.getNext();
		Node<E> remove=null;
		if(i==0) 
			first();
		else {
			for (int j = 0; j < i-1; j++) {
				curr=curr.next;
			}
			remove=curr.getNext();
			curr.setNext(curr.getNext().getNext());
		}
		size--;
		return remove.getElement();
	}
	@Override
	    public Iterator<E> iterator() {
	        return null;
	    }

	@Override
	public E removeFirst() {
		if(isEmpty())
			return null;
		Node<E> first= tail.getNext();
		if(first==tail)
			tail=null;
		else
			tail.setNext(first.getNext());
		size--;
		return first.getElement();
	}

	@Override
	public E removeLast() {
		if(isEmpty())
			return null;
		Node<E> secondLast = tail.getNext();
		for (int i = 1; i < size-1; i++) {
			secondLast=secondLast.getNext();
		}
		secondLast.setNext(tail.getNext());
		size--;
		return tail.getElement();
	}
	

	public void rotate() {
		if(tail !=null) {
			tail = tail.getNext();
		}
	}

	@Override
	public void addFirst(E e) {
		if(isEmpty()) {
			tail = new Node<E>(e,null);
			tail.setNext(tail);
		}
		else {
			Node<E> newest = new Node<E>(e,tail.getNext());
			tail.setNext(newest);
		}
		size++;
	}

	@Override
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
	}

	
	public String toString() {
		String result = "";
        Node<E> current = tail.getNext(); //first node is the next node after the tail
        for (int i = 0; i < size; i++) {
        	result += current.getElement();
        	if(i+1<size) {
            	result += ",";
            	
            }
            current = current.getNext();
			
		}
        return result;
	}
	
	public static void main(String[] args) {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
		for(int i = 10; i < 20; ++i) {
			ll.addLast(i);
		}

		System.out.println(ll);

		ll.add(1, 99);;
		System.out.println(ll);

		ll.last();

		ll.rotate();
		System.out.println(ll.get(1));

		ll.first();
		ll.rotate();
		System.out.println(ll);

		ll.last();
		ll.rotate();
		System.out.println(ll);

//		for (Integer e : ll) {
//			System.out.println("value: " + e);
//		}

	}
}
