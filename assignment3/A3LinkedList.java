// Name:
// Student number: v00

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addFront(String s) {
		// TODO: implement this
		A3Node newNode = new A3Node(s);
		if (head == null){
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
		length++;
	}

	public void addBack(String s) {
		// TODO: implement this
		A3Node newNode = new A3Node(s);
		if(tail == null){
			head = newNode;
		}else{
			newNode.prev = tail;
			tail.next = newNode;
		}
		tail = newNode;
		length++;
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void removeFront() {
		// TODO: implement this
		head = head.next;
		head.prev = null;
		length--;
	}
	
	public void removeBack() {
		// TODO: implement this
		tail = tail.prev;
		tail.next = null;
		length--;
	}
	
	public void removeAt(int pos) {
		// TODO: implement this
		int count = 0;
		A3Node cur = head;
		if(pos == 0){
			removeFront();
			return;
		}else if(pos == length-1){
			removeBack();
			return;
		}
		while(cur.next != null){
			if(count == pos){
				cur.prev.next = cur.next;
				cur.next.prev = cur.prev;
			}
		cur = cur.next;
		count++;
		}
		length--;
	}


	/* 
	 * Purpose: create and return a new A3LinkedList containing all the 
	 *          values from this list and other list, sorted alphabetically
	 * Parameters: A3LinkedList other - the other linked list
	 * Returns: A3LinkedList - a new linked list containing all of the values
	 *                         merged from this list and other list
	 *
	 * Pre-condition: the elements in both this list and other list are 
	 *                sorted alphabetically
	 * Post-condition: none of the elements in this list or other list
	 *                 have been modified or removed
	 *
	 * HINT: Look through the Node class for helpful methods
	 * Note: there are no pre-conditions about the size of either list
	 */
	public A3LinkedList mergeSorted(A3LinkedList other) {
		A3LinkedList merged = new A3LinkedList();
		A3Node thisNode = head;
		A3Node otherNode = other.head;
	
		while (thisNode != null && otherNode != null) {
			if (thisNode.getData().compareTo(otherNode.getData()) <= 0) {
				merged.addBack(thisNode.getData());
				thisNode = thisNode.getNext();
			} else {
				merged.addBack(otherNode.getData());
				otherNode = otherNode.getNext();
			}
		}
		while (thisNode != null) {
			merged.addBack(thisNode.getData());
			thisNode = thisNode.getNext();
		}
		while (otherNode != null) {
			merged.addBack(otherNode.getData());
			otherNode = otherNode.getNext();
		}
		return merged;
	}
	
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 *
	 * USED TO HELP YOU WITH DEBUGGING
	 * DO NOT CHANGE THIS METHOD
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 *
	 * USED TO HELP YOU WITH DEBUGGING
	 * DO NOT CHANGE THIS METHOD
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}
	