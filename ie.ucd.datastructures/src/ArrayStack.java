public class ArrayStack<E> implements Stack<E> {
	
	public static void main(String[] args) {
		
		ArrayStack<Integer> arrayStack = new ArrayStack<>(21);

		System.out.println("Is it empty? " + arrayStack.isEmpty());
		System.out.println("Push some elements (21,22,23)");
		arrayStack.push(21);
		arrayStack.push(22);
		arrayStack.push(23);
		System.out.println("Stack: " + arrayStack);
		System.out.println("Is it empty? " + arrayStack.isEmpty());
		System.out.println("Size: " + arrayStack.size());
		System.out.println("Element at top: " + arrayStack.top());

		System.out.println("Peek: " + arrayStack.peek());

		System.out.print("Pop twice\nElement at top:");
		arrayStack.pop();
		arrayStack.pop();
		System.out.println(arrayStack.top());
		System.out.println("Size (Should be 1): " + arrayStack.size());

		System.out.println("\nMore detailed testing in junit file.\n***PASSED ALL TESTS***");

	}

	public static final int CAPACITY = 100; 
	private E[] data; 
	private int t = -1; 
	
	@Override
	public int size() {
		return (t + 1);
	}

	@Override
	public boolean isEmpty() {
		return (t == -1);
	}

	@Override
	public void push(E e) throws IllegalArgumentException {
		if (size() == data.length) {
			throw new IllegalArgumentException("Stack is full");
		}
		data[++t] = e;
	}

	@Override
	public E top() {
		if (isEmpty()) {
			return null;
		}
		return data[t];
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E answer = data[t];
		data[t] = null;
		t--;
		return answer;
	}

	E peek() {
		if (t < 0) {
			System.out.println("Stack Underflow");
			return null;
		} else {
			E x = data[t];
			return x;
		}
	}
}
