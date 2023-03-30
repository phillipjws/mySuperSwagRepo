public class SinglyLinkedList<T> implements A5List<T>{

	private A5Node<T> head;
	private A5Node<T> tail;
	private int size;

	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void add (T data){
		A5Node<T> n = new A5Node<T>(data);
		if(head == null) {
			head = n;
		} else {
			tail.next = n;
		}
		tail = n;
		size++;
	}

	public int size () {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}

	public T get (int position) {
		return getRec(head, 0, position);
	}
	
	public T getRec(A5Node<T> cur, int i, int position) {
		if (i == position) {
			return cur.getData();
		} else {
			return getRec(cur.next, i+1, position);
		}
	}
	
	public void change (int position, T newValue) {
		changeRec(head, 0, position, newValue);
	}
	
	public void changeRec(A5Node<T> cur, int i, int position, T newValue) {
		if (i == position) {
			cur.setData(newValue);
		} else {
			changeRec(cur.next, i+1, position, newValue);
		}
	}
	
	public T removeFront() {
		if (head == null) { // list is empty case
			return null; 
		} else if (head == tail) {
			tail = null; // one element case
		}
		
		T toReturn = head.getData();
		head = head.next;
		size--;
		return toReturn;		
	}
	
	public T removeBack() {
		if (head == null) { // list is empty case
			return null; 
		} 
		
		T toReturn = tail.getData();
		
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			A5Node<T> cur = getTailPrev(head);
			cur.next = null; 
			tail = cur;
		}
		size--;
		return toReturn;		
	}
	
	public A5Node<T> getTailPrev(A5Node<T> cur) {
		if (cur.next == null) {
			return cur;
		} else {
			return getTailPrev(cur.next);
		}
	}

	/* Purpose: create a string representation of list
	 * Parameters: nothing	 
	 * Returns: String - the string representation of the list
	 */
	public String toString() {
		if (head == null) {
			return "{}";
		} else {
			return "{" + toStringRec(head) + "}";
		}
	}
	
	public String toStringRec(A5Node<T> cur) {
		if (cur == null) {
			return "";
		} else if (cur.next == null) {
			return cur.getData().toString();
		} else {
			return cur.getData().toString() + ", " + toStringRec(cur.next);
		}
	}

	/*
	 * Purpose: Insert all elements from array into this linked list
	 * Parameters: T[] array - the elements to add to this list
	 * Returns void - nothing
	 */
	public void buildFromArray(T[] array) {
		buildFromArrayRec(array, 0);
	}
	
	public void buildFromArrayRec(T[] array, int i) {
		if (i == array.length) {
			return;
		} else {
			add(array[i]);
			buildFromArrayRec(array, i+1);
		}
	}
}