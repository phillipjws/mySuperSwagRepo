public class A4Stack<T> implements Stack<T> {
	
	private A4Node<T> head;
	// Do NOT add any other fields to this class.
	// You should be able to implement the Stack 
	// interface with just a head field.

	public A4Stack() {
		// TODO: implement this
		this.head = null;
	}
	
	public void push(T value) {
		// TODO: implement this
		A4Node<T> newNode = new A4Node<T>(value);
		newNode.setNext(head);
		head = newNode;
	}
	
	public T pop() {
		// TODO: implement this
		if(isEmpty()){
			return null;
		}
		T value = head.getData();
		head = head.next;
		return value;
	}
	
	public void popAll() {
		// TODO: implement this
		head = null;
	}
	
	public boolean isEmpty() {
		// TODO: implement this
		return head == null; // so it compiles
	}
	
	public T peek() {
		// TODO: implement this
		if(head == null){
			return null;
		}else{
			return head.getData();
		}
	}
	
	// Implemented for you for debugging purposes
	public String toString() {
		String result = "{";
		String separator = "";
		
		A4Node<T> cur = head;
		while (cur != null) {
			result += separator + cur.getData().toString();
			separator = ", ";
			cur = cur.next;
		}
	
		result += "}";
		return result;
	}
}